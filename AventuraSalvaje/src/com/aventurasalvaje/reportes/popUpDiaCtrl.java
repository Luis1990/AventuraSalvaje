package com.aventurasalvaje.reportes;

import java.awt.Button;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zul.Window;

import com.aventurasalvaje.pojos.Renta;

public class popUpDiaCtrl extends GenericForwardComposer {
	private ReporteDiaBo reportediaBo;
	private Window nuevoDia;
	private Jasperreport reporte;
	private Button cancelar;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
			super.doAfterCompose(comp);
			reportediaBo = new ReporteDiaBo();		
			List <Renta> rentas =reportediaBo.fechas();
			List<ReportePDF> newlist=new ArrayList<ReportePDF>();
			
			for(int i=0;i<rentas.size();i++){
			ReportePDF objeto = new ReportePDF();
			objeto.setNombrepro(rentas.get(i).getProductoExistencia().getCatalogo().getNombreProducto());
			objeto.setInic(rentas.get(i).getHoraEntrada());
			objeto.setFin(rentas.get(i).getHoraSalida());
		    newlist.add(objeto);
			}
			JRBeanCollectionDataSource base = new JRBeanCollectionDataSource(newlist);
			String format="pdf";
			//reporte.setSrc("../formatos/reporteprueba.jasper");
			reporte.setSrc("/formatos/reporteDiario.jasper");
			reporte.setDatasource(base);
			reporte.setType(format);
	}
	public void onClick$cancelar(){
		nuevoDia.detach();
	}
	
}
