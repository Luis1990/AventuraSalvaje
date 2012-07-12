/**
 * 
 */
package com.aventurasalvaje.renta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Popup;

import com.aventurasalvaje.pojos.ProductoExistencia;
import com.aventurasalvaje.pojos.Renta;
import com.sun.xml.internal.fastinfoset.util.StringArray;

/**
 * @author carlos
 *
 */
public class RentaCtrl extends GenericForwardComposer {

	private Button Revisa;
	private Popup Info;
	private Button Confirma;
	private Popup Comienza;
	private Label HoraI;
	private Label HoraI2;
	private Label HoraF;
	private RentaBo rentaBo;
	private Listbox listaProducto;
	private Label Producto;
	private Label Producto2;
	private Label Comparacion;
	int idSucursal=2;
	BigDecimal precio=new BigDecimal(0);
	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp)throws Exception{
		super.doAfterCompose(comp);
		// TODO Auto-generated method stub
		rentaBo=new RentaBo();
		precio=new BigDecimal(rentaBo.precios(idSucursal).getCostoTotal());
		List<ProductoExistencia> productos=rentaBo.getProductos();
		List<ProductoExitenciaDTO> ltPro=new ArrayList<ProductoExitenciaDTO>();

		for (ProductoExistencia productoExistencia : productos) {
			ltPro.add(new ProductoExitenciaDTO(productoExistencia));
		}


		ListModelList model=new ListModelList(ltPro);
		listaProducto.setModel(model);
		listaProducto.setItemRenderer(new ListitemRenderer()
		{

			@Override
			public void render(Listitem item, Object data, int arg2)
			throws Exception {
				// TODO Auto-generated method stub
				ProductoExitenciaDTO producto=(ProductoExitenciaDTO) data;
				item.setValue(producto);
				Listcell cell0=new Listcell();
				Listcell cell1=new Listcell();
				Listcell cell2=new Listcell();
				Listcell cell3=new Listcell();
				final Listcell cell4=new Listcell();
				final String productoNombre=producto.getCatalogo().getNombreProducto();
				new Label(producto.getCatalogo().getNombreProducto()).setParent(cell1);
				final Label hora=new Label();
				hora.setValue("");
				final Label mensaje=new Label();
				mensaje.setValue("");
				hora.setParent(cell4);
				mensaje.setParent(cell3);
				final int idProducto=producto.getIdProductoExistencia();


				final Button inicio=new Button();
				final Button parar=new Button();
				parar.setVisible(false);
				inicio.setLabel("Iniciar");
				inicio.addEventListener("onClick", new EventListener<Event>() {

					@Override
					public void onEvent(Event arg0) throws Exception {
						Comienza.open(Comienza);
						cambiaVisibilidad(parar,inicio);
						hora.setValue(getHora());
						mensaje.setValue("Ocupado");
						HoraI.setValue(getHora());
						HoraI2.setValue(getHora());
						Producto.setValue(productoNombre);
						rentaBo.Save(idProducto,Calendar.getInstance());
					}
				});
				inicio.setParent(cell2);
				parar.setLabel("Parar");
				parar.addEventListener("onClick", new EventListener<Event>() {

					@Override
					public void onEvent(Event arg0) throws Exception {
						// TODO Auto-generated method stub
						Renta renta=rentaBo.renta(idProducto);
						int idRenta=renta.getIdRenta();
						Date horaI=renta.getHoraEntrada();
						Calendar inicialHora=Calendar.getInstance();
						inicialHora.setTime(horaI);
						Calendar finalHora=Calendar.getInstance();
						long hor1 = inicialHora.getTimeInMillis();
						long hor2 = finalHora.getTimeInMillis();
						long diff=hor2-hor1;
						long diffMinutes = diff / (60 * 1000);
						Integer cobro=cobro(diffMinutes);
						String compara="$ "+cobro;
						Comparacion.setValue(compara);


						Info.open(Info);
						cambiaVisibilidad2(parar,inicio);
						hora.setValue("");
						mensaje.setValue("");
						HoraF.setValue(getHora());
						Producto2.setValue(productoNombre);
						rentaBo.Update(idRenta,finalHora);

					}
				});


				parar.setParent(cell2);

				cell0.setParent(item);
				cell1.setParent(item);
				cell2.setParent(item);
				cell3.setParent(item);
				cell4.setParent(item);
			}
		});

	}
	public void cambiaVisibilidad(Button parar,Button inicio){
		parar.setVisible(true);
		inicio.setVisible(false);
	}
	public void cambiaVisibilidad2(Button parar,Button inicio){
		parar.setVisible(false);
		inicio.setVisible(true);
	}

	public String getHora(){
		Calendar hora=Calendar.getInstance();
		int h =hora.get(Calendar.HOUR);
		String hor=h==0?"12":String.valueOf(h);
		int m = hora.get(Calendar.MINUTE);
		String x=(hora.get(Calendar.AM_PM))!=1?"am":"pm";
		String min=m<10?"0"+m:String.valueOf(m);
		String horaInicio=hor+":"+min+" "+x;
		return horaInicio;
	}

	public Integer cobro(long diffMinutes){
		//		precio.toBigInteger();
		Integer precio=0;
		String cobro="20,30,45,100";
		String[]a=cobro.split(",");
		if(diffMinutes<5){
			precio=Integer.valueOf(a[0]);
		}
		return precio;

	}

	public void onClick$Revisa(){
		Info.close();	
	}

	public void onClick$Confirma(){
		Comienza.close();	
	}
}