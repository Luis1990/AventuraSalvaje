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
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Window;

import com.aventurasalvaje.pojos.Renta;
import com.aventurasalvaje.renta.RentaBo;
import com.aventurasalvaje.reportes.ReporteMensualBo;
/**
 * @author carlos
 *
 */
public class ReporteMensualCtrl extends GenericForwardComposer {

	private Listbox rentaProductos;
	private ReporteMensualBo ReporteMensualBo;
	private Jasperreport jasper;
	private RentaBo rentaBo;
	private Button genera;
	int idSucursal=2;
	
	/**
	 *
	 *
	 */
	@Override

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		ReporteMensualBo=new ReporteMensualBo();
		rentaBo=new RentaBo();
		List<Renta> lista=ReporteMensualBo.mes();
		List<ReportePDF> newlist=new ArrayList<ReportePDF>();
		for (int i=0;i<lista.size();i++) {
			ReportePDF objeto=new ReportePDF();
			objeto.setNombrepro(lista.get(i).getProductoExistencia().getCatalogo().getNombreProducto());
			objeto.setInic(lista.get(i).getHoraEntrada());
			objeto.setFin(lista.get(i).getHoraSalida());
			newlist.add(objeto);
		}
		ListModelList model=new ListModelList(lista);
		rentaProductos.setModel(model);
		rentaProductos.setItemRenderer(new ListitemRenderer()
		{
			@Override
			public void render(Listitem item, Object data, int arg2)
			throws Exception {
				final Renta renta=(Renta) data;
				item.setValue(renta);
				Listcell cell0=new Listcell();
				Listcell cell1=new Listcell();
				Listcell cell2=new Listcell();
				new Label(renta.getProductoExistencia().getCatalogo().getNombreProducto()).setParent(cell0);
				String horaEmpieza=""+renta.getHoraEntrada();
				String horaAcaba=""+renta.getHoraSalida();
				new Label(horaEmpieza).setParent(cell1);
				new Label(horaAcaba).setParent(cell2);
				cell0.setParent(item);
				cell1.setParent(item);
				cell2.setParent(item);
			}
		});
	}
	public void onClick$genera(){
		Window win= (Window) Executions.createComponents("popUpMes.zul", null, null);
		win.doModal();
	}
}
