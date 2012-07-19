/**
 * 
 */
package com.aventurasalvaje.renta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Window;

import com.aventurasalvaje.pojos.ProductoExistencia;

/**
 * @author carlos
 *
 */
public class RentaCtrl extends GenericForwardComposer {


	private RentaBo rentaBo;
	private Listbox listaProducto;
	private Label Producto;
	private Label Producto2;
	private Label Comparacion;
	private Image Image;
	private Window Comienza;
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
				final String imagenes="/imagenes/"+producto.getCatalogo().getNombreArchivo();
				Image imagen=new Image();
				imagen.setSrc(imagenes);			
				imagen.setParent(cell0);
				new Label(producto.getCatalogo().getNombreProducto()).setParent(cell1);
				final Label hora=new Label();
				hora.setValue("");
				final Label mensaje=new Label();
				mensaje.setValue("");
				mensaje.setParent(cell3);
				hora.setParent(cell4);
				final int idProducto=producto.getIdProductoExistencia();
				final Button inicio=new Button();
				final Button parar=new Button();
				parar.setVisible(false);
				inicio.setLabel("Iniciar");

				inicio.addEventListener("onClick", new EventListener<Event>() {

					@Override
					public void onEvent(Event arg0) throws Exception {
						cambiaVisibilidad(parar,inicio);
						hora.setValue(getHora());
						mensaje.setValue("Ocupado");
						Map<String , Object> args= new HashMap<String, Object>();
						args.put("nombre", productoNombre);
						args.put("imagenes", imagenes);
						args.put("idprod", idProducto);
						Window win= (Window) Executions.createComponents("comenzarRenta.zul", null, args);
						win.doModal();
					}
				});
				inicio.setParent(cell2);
				parar.setLabel("Parar");
				parar.addEventListener("onClick", new EventListener<Event>() {

					@Override
					public void onEvent(Event arg0) throws Exception {
						// TODO Auto-generated method stub
						cambiaVisibilidad2(parar,inicio);
						hora.setValue("");
						mensaje.setValue("");
						Map<String , Object> args2= new HashMap<String, Object>();
						args2.put("nombre", productoNombre);
						args2.put("imagenes", imagenes);
						args2.put("idprod", idProducto);
						Window win2= (Window) Executions.createComponents("pararRenta.zul", null, args2);
						win2.doModal();
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
	private BigDecimal obtener(String costoTotal,long diffMinutes) {
		BigDecimal minutos=new BigDecimal(diffMinutes);
		String []cadenacostos=costoTotal.split(",");
		BigDecimal valor=new BigDecimal(0);
		if(diffMinutes<=9){
			valor=new BigDecimal(cadenacostos[0]);
			if(diffMinutes>5){
				for(int i=0;i<minutos.intValue()-5;i++){
					valor=valor.add(new BigDecimal(4));
				}
			}
		}
		else{
			if(diffMinutes<=14){
				valor=new BigDecimal(cadenacostos[1]);
				if(diffMinutes>10){
					for(int i=0;i<minutos.intValue()-10;i++){
						valor=valor.add(new BigDecimal(4));
					}
				}
			}
			else{
				if(diffMinutes<=19){
					valor=new BigDecimal(cadenacostos[2]);
					if(diffMinutes>15){
						for(int i=0;i<minutos.intValue()-15;i++){
							valor=valor.add(new BigDecimal(4));
						}
					}
				}
				else{
					if(diffMinutes<=29){
						valor=new BigDecimal(cadenacostos[3]);
						if(diffMinutes>20){
							for(int i=0;i<minutos.intValue()-20;i++){
								valor=valor.add(new BigDecimal(4));
							}
						}
					}
					else{
						if(diffMinutes<=59){
							valor=new BigDecimal(cadenacostos[4]);
							if(diffMinutes>30){
								for(int i=0;i<minutos.intValue()-30;i++){
									valor=valor.add(new BigDecimal(4));
								}
							}
						}
						if(diffMinutes>=60){
							valor=new BigDecimal(cadenacostos[5]);	
						}
					}
				}
			}
		}
		return valor;
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
}