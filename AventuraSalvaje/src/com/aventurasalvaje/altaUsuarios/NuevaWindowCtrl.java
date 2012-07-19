package com.aventurasalvaje.altaUsuarios;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class NuevaWindowCtrl  extends GenericForwardComposer{
	
	private Integer idsucursal=2;
	private Window nuevaWindow;
	private AltaUsuariosBo altausuarioBO;
	private Button cancelar;
	private Button confirma;
	private Textbox usuario_nom;
	private Textbox usuario_pass;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		altausuarioBO=new AltaUsuariosBo();

	}

	public void onClick$confirma(){
		String nombre=usuario_nom.getValue();
		String password=usuario_pass.getValue();
		altausuarioBO.save(nombre,password,idsucursal);
		usuario_nom.setText("");
		usuario_pass.setText("");
		Events.postEvent("onConfiguracionModificada", nuevaWindow, null);
		nuevaWindow.detach();
		
	}
	
	public void onClick$cancelar(){
		usuario_nom.setValue("");
		usuario_pass.setValue("");
		
		nuevaWindow.detach();
	}
}
