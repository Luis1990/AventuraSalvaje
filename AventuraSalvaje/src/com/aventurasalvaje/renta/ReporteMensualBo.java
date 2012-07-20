/**
 * 
 */
package com.aventurasalvaje.renta;

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

	public List<Renta> mes(){
		RentaDAO rentaDAO=new RentaDAO();
		Calendar horaI = Calendar.getInstance();
		horaI.set(horaI.get(Calendar.YEAR),
		horaI.get(Calendar.MONTH),
		horaI.getActualMinimum(Calendar.DAY_OF_MONTH));
		Calendar horaF = Calendar.getInstance();
		horaF.set(horaF.get(Calendar.YEAR),
		horaF.get(Calendar.MONTH),
		horaF.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date ini=horaI.getTime();
		System.out.println(ini);
		Date fn=horaF.getTime();
		System.out.println(fn);
	    return rentaDAO.findByFechas(ini,fn);
	}
	public List<Renta> getRentas() {
		return rentaDao.findAll();
	} 
}
