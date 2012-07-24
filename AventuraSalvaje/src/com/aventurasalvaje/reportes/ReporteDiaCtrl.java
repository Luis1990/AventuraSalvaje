package com.aventurasalvaje.reportes;
import java.util.ArrayList;

import org.zkoss.lang.Exceptions;
import org.zkoss.zkex.zul.Jasperreport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.aventurasalvaje.pojos.Renta;
import com.sun.java.swing.plaf.windows.resources.windows;
import org.zkoss.zul.Window;

public class ReporteDiaCtrl extends GenericForwardComposer{
	
	private ReporteDiaBo reportediaBo;
	private Button confirma;
	private Listbox listaRenta;
	private Jasperreport jasper;
	private Datebox calendario;
	private Button ver;
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		reportediaBo = new ReporteDiaBo();	
		//reportediaBo.fechas();
		cargaLista();
	}

	private void cargaLista() {
		
		List <Renta> rentas =reportediaBo.fechas();
		ListModelList model = new ListModelList(rentas);
		listaRenta.setModel(model);
		listaRenta.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem item, Object data, int arg2)
					throws Exception {
			final Renta renta=(Renta) data;
			item.setValue(renta);
			
			Listcell cell0=new Listcell();
			Listcell cell1=new Listcell();
			Listcell cell2=new Listcell();
			
			new Label(renta.getProductoExistencia().getCatalogo().getNombreProducto()).setParent(cell0);
			new Label(renta.getHoraEntrada().toString()).setParent(cell1);
			new Label(renta.getHoraSalida().toString()).setParent(cell2);

			cell0.setParent(item);
			cell1.setParent(item);
			cell2.setParent(item);
				
			}
		});
	}
	
	public void onClick$confirma(){
	Window win= (Window) Executions.createComponents("popUpDia.zul", null, null);
	win.addEventListener("onConfiguracionModificada", new EventListener() {
		@Override
		public void onEvent(Event arg0) throws Exception {
			
		}
		
	});
	win.doModal();					
}	

	public void onClick$ver(){
		System.out.println(calendario.getValue());
	}
	
	
	
	
}
