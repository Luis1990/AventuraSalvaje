/**
 * 
 */
package com.aventurasalvaje.pedidos;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;

import com.aventurasalvaje.pojos.ProductoExistencia;
import com.aventurasalvaje.pojos.Usuario;

/**
 * @author SDGA
 *
 */
public class PedidosCtrl extends GenericForwardComposer {

	private Listbox listadeanimales;
	private PedidosBo pedidoBo;
//	private envioPedido enviar;
	private prueba pru;
	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		pedidoBo = new PedidosBo();
 
			
		List<ProductoExistencia> listaped=pedidoBo.getListapedido();

		ListModelList model=new ListModelList(listaped);
		
		
		listadeanimales.setModel(model);

		listadeanimales.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem item, Object data, int arg2)//un objeto por cada elemento de la lista data= usuario
			throws Exception {

				final ProductoExistencia listaped=(ProductoExistencia) data;

				item.setValue(listaped);


				Listcell cell0=new Listcell();
				Listcell cell1=new Listcell();
				Listcell cell2=new Listcell();

				new Label(listaped.getCatalogo().getNombreProducto()).setParent(cell0);
				new Label(listaped.getDescripcionGral()).setParent(cell1);
				new Intbox(0).setParent(cell2);
				

				cell0.setParent(item);
				cell1.setParent(item);
				cell2.setParent(item);
			}

		});
	}

	public void onClick$enviar(){
//		envioPedido enviar= new envioPedido();
//		
//		try {
//			enviar.envio("aventurasalvajepedidos@gmail.com", "aventuraanimal");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String mensaje="";
		
		List<Usuario> usuariosCambio = new ArrayList<Usuario>();

		List hijo=listadeanimales.getChildren();
		for (Object object : hijo) {
			if(object instanceof Listitem){
				String resultado="";
				Listitem item=(Listitem) object;
				
				Intbox textcantidad=(Intbox) item.getChildren().get(2).getFirstChild();
				Label labeldescripcion=(Label)item.getChildren().get(1).getFirstChild();
				Label labelanimal=(Label)item.getChildren().get(0).getFirstChild();

				if(textcantidad.getValue()!=0){
				
				resultado=labelanimal.getValue()+labeldescripcion.getValue()+textcantidad.getValue()+"\n";
				mensaje=mensaje+resultado;
				}
				
			}
		}
	pru = new prueba("akilesdaniel2311@gmail.com",mensaje);
	}
}
