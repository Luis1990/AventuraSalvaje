/**
 * 
 */
package com.aventurasalvaje.sucursal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;

import com.aventurasalvaje.pojos.Sucursal;

/**
 * @author SDGA
 *
 */
public class SucursalCtrl extends GenericForwardComposer {

	private int  idUsuario=15;
	
	private Button aceptar;
	private Textbox textdireccion;
	private Textbox textcorreo;
	private Intbox texttelefono;
	private Textbox textnombre;
	private SucursalBo sucursalBo;
	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		sucursalBo = new SucursalBo();
	
	}

	public void onClick$aceptar(){
	
		
		String direccion = textdireccion.getValue();
		String correo=textcorreo.getValue();
		int telefono=texttelefono.getValue();
		String nombre=textnombre.getValue();

		System.out.println(nombre);
		if(correo=="" || telefono== 0 || nombre==""){
			alert("Debes de colocar todos los requerimientos");
		}
		else{
			long tele=telefono;

			sucursalBo.save(nombre,correo,tele,direccion,idUsuario);
		}


	}



}
