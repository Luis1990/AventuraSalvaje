/**
 * 
 */
package com.aventurasalvaje.reportes;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.aventurasalvaje.dao.RentaDAO;
import com.aventurasalvaje.pojos.Renta;
import com.aventurasalvaje.pojos.Usuario;

/**
 * @author carlos
 *
 */
    public class ReporteMensualBo {
	public RentaDAO rentaDao;
	public ReporteMensualBo(){
		rentaDao = new RentaDAO();
	}
	
	public List<Renta> fechas(Calendar fechare) {
		Calendar horaInicial= (Calendar)fechare; 
		horaInicial.set(horaInicial.get(Calendar.YEAR),
				horaInicial.get(Calendar.MONTH),
				horaInicial.getActualMinimum(Calendar.DAY_OF_MONTH), 
				horaInicial.getActualMinimum(Calendar.HOUR_OF_DAY), 
				horaInicial.getActualMinimum(Calendar.MINUTE));
				
		Calendar horaFin=(Calendar) fechare.clone();
		
		horaFin.set(horaFin.get(Calendar.YEAR),
				horaFin.get(Calendar.MONTH), 
				horaFin.getActualMaximum(Calendar.DAY_OF_MONTH), 
				horaFin.getActualMaximum(Calendar.HOUR_OF_DAY), 
				horaFin.getActualMaximum(Calendar.MINUTE));
		
		Date inicio=horaInicial.getTime();
		Date fin = horaFin.getTime();		
		return rentaDao.findByFechas(inicio, fin);
	}

	public List<Renta> mes(){
		RentaDAO rentaDAO=new RentaDAO();
		Calendar horaI = Calendar.getInstance();
		horaI.set(horaI.get(Calendar.YEAR),
		horaI.get(Calendar.MONTH),
		horaI.getActualMinimum(Calendar.DAY_OF_MONTH));
		horaI.getActualMinimum(Calendar.SECOND);
		
		Calendar horaF = Calendar.getInstance();
		horaF.set(horaF.get(Calendar.YEAR),
		horaF.get(Calendar.MONTH),
		horaF.getActualMaximum(Calendar.DAY_OF_MONTH));
		horaF.getActualMaximum(Calendar.SECOND);
		Date ini=horaI.getTime();
		Date fn=horaF.getTime();
	    return rentaDAO.findByFechas(ini,fn);
	}
}
