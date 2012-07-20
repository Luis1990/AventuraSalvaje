/**
 * 
 */
package com.aventurasalvaje.reportes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Window;

import com.aventurasalvaje.login.LoginBo;
import com.aventurasalvaje.pojos.ProductoExistencia;
import com.aventurasalvaje.pojos.Renta;
import com.aventurasalvaje.pojos.Usuario;
import com.aventurasalvaje.renta.ProductoExitenciaDTO;
import com.aventurasalvaje.renta.RentaBo;
import com.aventurasalvaje.renta.ReporteMensualBo;
import com.aventurasalvaje.reportes.ReportePDF;
/**
 * @author carlos
 *
 */
public class ReporteMensualCtrl extends GenericForwardComposer {

	private Listbox rentaProductos;
	private ReporteMensualBo ReporteMensualBo;
	private Jasperreport jasper;
	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		ReporteMensualBo=new ReporteMensualBo();
		List<Renta> lista=ReporteMensualBo.mes();
		List<ReportePDF> newlist=new ArrayList<ReportePDF>();
		for (int i=0;i<lista.size();i++) {
			ReportePDF objeto=new ReportePDF();
			objeto.setNombrepro(lista.get(i).getProductoExistencia().getCatalogo().getNombreProducto());
			objeto.setInic(lista.get(i).getHoraEntrada());
			objeto.setFin(lista.get(i).getHoraSalida());
			newlist.add(objeto);
		}
		Map<Object, Object> parameters= new HashMap<Object, Object>();
		parameters.put("Nombre", "Luis");
		jasper.setSrc("");
		jasper.setParameters(parameters);
		
		
		
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
	}
