/**
 * 
 */
package com.aventurasalvaje.renta;

import java.util.Calendar;
import java.util.Set;

import org.apache.commons.collections.SetUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Popup;

/**
 * @author carlos
 *
 */
public class RentaCtrl extends GenericForwardComposer {

	private Button Revisa;
	private Popup Info;
	private Button Confirma;
	private Popup Comienza;
	private Label Texto;
	private Button Parar;
	private Button Inicio;
	private Label HoraI;

	/**
	*
	*
	*/
	@Override
	public void doAfterCompose(Component comp)throws Exception{
		super.doAfterCompose(comp);
		// TODO Auto-generated method stub
	
	}
	
	public void onClick$Inicio(){
	Comienza.open(Comienza);
	Parar.setVisible(true);
	Inicio.setVisible(false);
	Texto.setVisible(true);
	}
	
	public void onClick$Parar(){
	Info.open(Info);
	Parar.setVisible(false);
	Inicio.setVisible(true);
	Texto.setVisible(false);
	}
	
	public void onClick$Revisa(){
	Info.close();	
	}
	
	public void onClick$Confirma(){
	Comienza.close();	
	}
	
	public void Confirma(){
		HoraI.setValue(Calendar.getInstance().getTime().toString());
	}
}
