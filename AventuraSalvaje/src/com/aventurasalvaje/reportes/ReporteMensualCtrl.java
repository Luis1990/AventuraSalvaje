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
import org.zkoss.zul.Datebox;
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
	private Datebox calendario;
	int idSucursal=2;
	
	/**
	 *
	 *
	 */
	@Override

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		ReporteMensualBo=new ReporteMensualBo();
	}
	public void onClick$genera(){
		Map<String , Object> args= new HashMap<String, Object>();
		args.put("fecha",calendario.getValue());
		Window win= (Window) Executions.createComponents("popUpMes.zul", null, args);
		win.doModal();
	}
}
