package com.aventurasalvaje.altaUsuarios;

import java.util.List;

import org.zkoss.zk.ui.Component;
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

import com.aventurasalvaje.pojos.Usuario;

public class AltaUsuariosCtrl extends GenericForwardComposer {
	
	private Integer idsucursal=2;
	
	private AltaUsuariosBo altausuarioBO;
	
	private Listbox listaUsuario;
	private Button confirma;	
	private Button nuevo;
	private Popup agregar;
	private Textbox usuario_nom;
	private Textbox usuario_pass;
			
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		altausuarioBO=new AltaUsuariosBo();
		
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
					new Label (usuario.getPassword()).setParent(cell2);
								
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
				
				System.out.println("nombre:"+usuario.getUsuario());}
			}
		}
		
	}
	
	public void onClick$modificar(){	
		
		
		
	}
	
	public void onClick$nuevo(){
		agregar.open(agregar);					
	}
	
	
	public void onClick$confirma(){
		String nombre=usuario_nom.getText();
		String password=usuario_pass.getText();
		
		
		altausuarioBO.save(nombre,password,idsucursal);
		
		agregar.close();	
	}
	
	
}
