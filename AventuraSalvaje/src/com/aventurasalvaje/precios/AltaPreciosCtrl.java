/**
 * 
 */
package com.aventurasalvaje.precios;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Window;

import com.aventurasalvaje.renta.RentaBo;

/**
 * @author carlos
 *
 */
public class AltaPreciosCtrl extends GenericForwardComposer {

	private Spinner precio1;
	private Spinner precio2;
	private Spinner precio3;
	private Spinner precio4;
	private Spinner precio5;
	private Spinner precio6;
	private Spinner precio7;
	private Button confirma;
	private PreciosBo preciosBo;
	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		preciosBo=new PreciosBo();
	}
	public void onClick$confirma(){
		int precio5min=precio1.getValue();
		int precio10min=precio2.getValue();
		int precio15min=precio3.getValue();
		int precio20min=precio4.getValue();
		int precio30min=precio5.getValue();
		int precio60min=precio6.getValue();
		long precioextra=precio7.getValue();
		String precios=""+precio5min+","+precio10min+","+precio15min+","+precio20min+","+precio30min+","+precio60min;
		preciosBo.Save(precios,precioextra);
		alert("Los precios han sido guardados correctamente");
	}
}
