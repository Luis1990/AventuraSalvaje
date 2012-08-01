/**
 * 
 */
/**
 * 
 */
package com.aventurasalvaje.reportes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

import com.aventurasalvaje.pojos.Renta;
import com.aventurasalvaje.renta.RentaBo;
/**
 * @author carlos
 *
 */
public class PopUpMesCtrl extends GenericForwardComposer {

	private Listbox rentaProductos;
	private ReporteMensualBo ReporteMensualBo;
	private RentaBo rentaBo;
	int idSucursal=2;
	private Window reporteMes;
	private Jasperreport jasper;	
	/**
	 *
	 *
	 */
	@Override

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		Map<String, Object> args = (Map<String, Object>) Executions.getCurrent().getArg();
		Date fecha= (Date) args.get("fecha");
		Calendar fechare= Calendar.getInstance();
		fechare.setTime(fecha);
		
		ReporteMensualBo=new ReporteMensualBo();
		rentaBo=new RentaBo();
		List<Renta> lista=ReporteMensualBo.mes();
		List <Renta> rentas =ReporteMensualBo.fechas(fechare);
		List<ReportePDF> newlist=new ArrayList<ReportePDF>();
		
		for (int i=0;i<rentas.size();i++) {
			ReportePDF objeto=new ReportePDF();
			objeto.setNombrepro(rentas.get(i).getProductoExistencia().getCatalogo().getNombreProducto());
			objeto.setInic(rentas.get(i).getHoraEntrada());
			objeto.setFin(rentas.get(i).getHoraSalida());
			Calendar inicio = Calendar.getInstance();
			inicio.setTime(rentas.get(i).getHoraEntrada());
			Calendar fin = Calendar.getInstance();
			fin.setTime(rentas.get(i).getHoraSalida());
			objeto.setCalculo(calcula(inicio, fin, rentas.get(i)));
			objeto.setDiferencia(diffMin(inicio, fin,rentas.get(i)));
			newlist.add(objeto);
		}

		Map<Object, Object> parameters=new HashMap<Object, Object>();
		JRBeanCollectionDataSource base = new JRBeanCollectionDataSource(newlist);
		String format="pdf";
		jasper.setSrc("/formatos/reporteMensual.jasper");
		jasper.setDatasource(base);
		jasper.setType(format);
	}
	public BigDecimal calcula(Calendar inicialHora,Calendar finalHora, Renta renta){
		BigDecimal precio;
		long diffMinutes = diffMin(inicialHora, finalHora, renta);
		precio=obtener(rentaBo.precios(idSucursal).getCostoTotal(),diffMinutes);
		precio.setScale(2);
		return precio;
	}
	private long diffMin(Calendar inicialHora, Calendar finalHora, Renta renta) {
		BigDecimal precio=new BigDecimal(0);
		inicialHora.setTime(renta.getHoraEntrada());
		finalHora.setTime(renta.getHoraSalida());
		long hor1=inicialHora.getTimeInMillis();
		long hor2=finalHora.getTimeInMillis();
		long diff=hor2-hor1;
		long diffMinutes = diff / (60 * 1000);
		return diffMinutes;
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
}