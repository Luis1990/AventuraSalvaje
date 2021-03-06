package com.aventurasalvaje.productolista;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Window;

import com.aventurasalvaje.pojos.ProductoExistencia;

public class ListaCtrl extends GenericForwardComposer{

	//private static final ProductoExistencia ListaBo = null;
	private Listbox listaproducto;
	private ListaBo listabo;
//	private Combobox producto_nom;
	private Window nuevowindow;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		listabo= new ListaBo();

		recarga();

	}

	private void recarga() {
		List<ProductoExistencia> lista=listabo.getProductoExistencias();

		ListModelList model= new ListModelList(lista);


		listaproducto.setModel(model);
		listaproducto.setItemRenderer(new ListitemRenderer(){
			@Override
			public void render(Listitem item, Object data, int arg2)
			throws Exception {
				final ProductoExistencia lista=(ProductoExistencia) data;
				item.setValue(lista);

				Listcell cell0=new Listcell();
				Listcell cell1=new Listcell();
				Listcell cell2=new Listcell();

				new Label(lista.getIdProductoExistencia().toString()).setParent(cell0);
				new Label(lista.getDescripcionGral()).setParent(cell2);
				new Label(lista.getCatalogo().getNombreProducto()).setParent(cell1);


				cell0.setParent(item);
				cell1.setParent(item);
				cell2.setParent(item);

			}				
		});
	}

	@SuppressWarnings("unchecked")
	public void onClick$nuevo(){
		Window win= (Window) Executions.createComponents("popUpLista.zul", null, null);
		win.addEventListener("onConfiguracionModificada", new EventListener() {

			@Override
			public void onEvent(Event arg0) throws Exception {
				recarga();
			}
			
		});
		win.doModal();
		
	}

	
	public void onClick$eliminar(){
		List hijo=listaproducto.getChildren();
		for (Object object : hijo) {
			if(object instanceof Listitem){
				Listitem item=(Listitem) object;
				if(item.isSelected()){
					ProductoExistencia producto=item.getValue();
					listabo.dellete(producto);

				}	
			}
		}
	recarga();
	}



}
