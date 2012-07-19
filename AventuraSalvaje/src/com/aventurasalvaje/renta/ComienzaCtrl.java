/**
 * 
 */
package com.aventurasalvaje.renta;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

import com.aventurasalvaje.pojos.Renta;

/**
 * @author carlos
 *
 */
public class ComienzaCtrl extends GenericForwardComposer {

	private Label HoraI;
	private RentaBo rentaBo;
	private Label Producto;
	private Button Confirma;
	private Image Image;
	private Window Comienza;
	int idSucursal=2;
	int idProducto;
	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp)throws Exception{
		super.doAfterCompose(comp);
		Map<String, Object> args = (Map<String, Object>) Executions.getCurrent().getArg();
		String nombre=(String) args.get("nombre");
		String pic=(String) args.get("imagenes");
		idProducto=(Integer) args.get("idprod");
		rentaBo=new RentaBo();
		Image.setSrc(pic);
		Producto.setValue(nombre);
		HoraI.setValue(getHora());
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
			public void onClick$Confirma(){
				
				rentaBo.Save(idProducto,Calendar.getInstance());
				Comienza.detach();
			}
}