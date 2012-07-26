package com.aventurasalvaje.altaUsuarios;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
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
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.aventurasalvaje.pojos.Usuario;

public class AltaUsuariosCtrl extends GenericForwardComposer {

	private Integer idsucursal=2;
	private Window nuevaWindow;

	private AltaUsuariosBo altausuarioBO;

	private Listbox listaUsuario;
	private Button cancelar;
	private Button guardar;
	private Button modificar;
	//private Button confirma;
	private Button eliminar;
	private Button nuevo;
	//private Popup agregar;
	//private Textbox usuario_nom;
	//private Textbox usuario_pass;


	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		altausuarioBO=new AltaUsuariosBo();

		cargaUsuarios();
	}

	private void cargaUsuarios() {

		nuevo.setVisible(true);
		eliminar.setVisible(true);	
		modificar.setVisible(true);
		guardar.setVisible(false);
		cancelar.setVisible(false);

		List<Usuario> usuarios=altausuarioBO.getUsuarios();

		ListModelList model=new ListModelList(usuarios);
		
		
		listaUsuario.setModel(model);

		listaUsuario.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem item, Object data, int arg2)//un objeto por cada elemento de la lista data= usuario
			throws Exception {

				final Usuario usuario=(Usuario) data;

				item.setValue(usuario);


				Listcell cell0=new Listcell();
				Listcell cell1=new Listcell();
				Listcell cell2=new Listcell();


				new Label(usuario.getUsuario()).setParent(cell1);
				new Label(usuario.getPassword()).setParent(cell2);


				cell0.setParent(item);
				cell1.setParent(item);
				cell2.setParent(item);


			}

		});

	}

	public void onClick$eliminar(){	

		List hijo=listaUsuario.getChildren();
		for (Object object : hijo) {
			if(object instanceof Listitem){
				Listitem item=(Listitem) object;
				if(item.isSelected()){
					Usuario usuario=item.getValue();
					altausuarioBO.dellete(usuario);

					System.out.println("nombre:"+usuario.getUsuario());

				}
			}
		}

		cargaUsuarios();

	}

	public void onClick$modificar(){	

		//altausuarioBO=new AltaUsuariosBo();

		List<Usuario> usuarios=altausuarioBO.getUsuarios();

		ListModelList model=new ListModelList(usuarios);
		listaUsuario.setModel(model);

		listaUsuario.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem item, Object data, int arg2)//un objeto por cada elemento de la lista data= usuario
			throws Exception {

				final Usuario usuario=(Usuario) data;

				item.setValue(usuario);


				Listcell cell0=new Listcell();
				Listcell cell1=new Listcell();
				Listcell cell2=new Listcell();


				new Textbox(usuario.getUsuario()).setParent(cell1);
				new Textbox(usuario.getPassword()).setParent(cell2);


				cell0.setParent(item);
				cell1.setParent(item);
				cell2.setParent(item);

			}

		});

		nuevo.setVisible(false);
		eliminar.setVisible(false);	
		modificar.setVisible(false);
		guardar.setVisible(true);
		cancelar.setVisible(true);
	}
	public void onClick$cancelar(){

		cargaUsuarios();
	}

	public void onClick$guardar(){

		List<Usuario> usuariosCambio = new ArrayList<Usuario>();

		List hijo=listaUsuario.getChildren();
		for (Object object : hijo) {
			if(object instanceof Listitem){
				Listitem item=(Listitem) object;

				Usuario usuario=item.getValue();
				Textbox textUsuario=(Textbox) item.getChildren().get(1).getFirstChild();
				Textbox textPassword=(Textbox)item.getChildren().get(2).getFirstChild();
				String usu=textUsuario.getValue();
				String pass=textPassword.getValue();
				if (usu.isEmpty() || pass.isEmpty() ){
					alert("Nombre  y/o  Password  no tienen nada escrito ");	
					}
				else{
				usuario.setPassword(textPassword.getValue());
				usuario.setUsuario(textUsuario.getValue());
				usuariosCambio.add(usuario);
				}
			}
		}
		altausuarioBO.Update(usuariosCambio);

		System.out.println("Tamaño de lista:"+ hijo.size());

		cargaUsuarios();
	}
	@SuppressWarnings("unchecked")
	public void onClick$nuevo(){
		Window win= (Window) Executions.createComponents("popUpAgregar.zul", null, null);
		win.addEventListener("onConfiguracionModificada", new EventListener() {

			@Override
			public void onEvent(Event arg0) throws Exception {
				cargaUsuarios();
			}		
		});
		win.doModal();
		//agregar.open(agregar);					
	}
}
