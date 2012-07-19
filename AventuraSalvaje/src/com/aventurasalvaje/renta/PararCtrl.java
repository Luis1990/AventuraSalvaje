/**
 * 
 */
package com.aventurasalvaje.renta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.zkoss.zul.Popup;
import org.zkoss.zul.Window;

import com.aventurasalvaje.pojos.ProductoExistencia;
import com.aventurasalvaje.pojos.Renta;
import com.sun.xml.internal.fastinfoset.util.StringArray;

/**
 * @author carlos
 *
 */
public class PararCtrl extends GenericForwardComposer {

	private Label HoraI;
	private Label HoraI2;
	private Label HoraF;
	private Window Para;
	private RentaBo rentaBo;
	private Label Producto;
	private Label Comparacion;
	private Button Revisa;
	private Image Imagenpara;
	int idSucursal=2;
	int idProducto;
	int idRenta;
	BigDecimal precio=new BigDecimal(0);
	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp)throws Exception{
		super.doAfterCompose(comp);
		rentaBo=new RentaBo();
		Map<String, Object> args2 = (Map<String, Object>) Executions.getCurrent().getArg();
		String nombre=(String) args2.get("nombre");
		String pic=(String) args2.get("imagenes");
		idProducto=(Integer) args2.get("idprod");
		Renta renta=rentaBo.renta(idProducto);
		idRenta=renta.getIdRenta();
		Imagenpara.setSrc(pic);
		Producto.setValue(nombre);
		Calendar inicialHora=Calendar.getInstance();
		inicialHora.setTime(renta.getHoraEntrada());
		horalabel(inicialHora);
		HoraI.setValue(horalabel(inicialHora));
		Calendar finalHora=Calendar.getInstance();
		long hor1 = inicialHora.getTimeInMillis();
		long hor2 = finalHora.getTimeInMillis();
		long diff=hor2-hor1;
		long diffMinutes = diff / (60 * 1000);
		precio=obtener(rentaBo.precios(idSucursal).getCostoTotal(),diffMinutes);
		String compara="$ "+precio.setScale(2);
		HoraF.setValue(getHora());
		Comparacion.setValue(compara);
	}
	
	private String horalabel(Calendar inicialhora){
		int h =inicialhora.get(Calendar.HOUR);
		String hor=h==0?"12":String.valueOf(h);
		int m = inicialhora.get(Calendar.MINUTE);
		String x=(inicialhora.get(Calendar.AM_PM))!=1?"am":"pm";
		String min=m<10?"0"+m:String.valueOf(m);
		String horaInicio=hor+":"+min+" "+x;
		return horaInicio;
		
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

	public void onClick$Revisa(){
		rentaBo.Update(idRenta,Calendar.getInstance());
		Para.detach();
	}
}