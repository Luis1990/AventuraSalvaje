package com.aventurasalvaje.reportes;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.aventurasalvaje.dao.RentaDAO;
import com.aventurasalvaje.dao.ReporteDiaDAO;
import com.aventurasalvaje.pojos.Renta;

public class ReporteDiaBo {
	public RentaDAO rentaDao;

	public ReporteDiaBo() {
		rentaDao = new RentaDAO();
	}

	public List<Renta> fechas(Calendar fechare, Calendar fechare2) {
	
		Calendar horaInicial=fechare; 
		horaInicial.set(horaInicial.get(Calendar.YEAR),
				horaInicial.get(Calendar.MONTH),
				horaInicial.get(Calendar.DAY_OF_MONTH), 
				horaInicial.getActualMinimum(Calendar.HOUR_OF_DAY), 
				horaInicial.getActualMinimum(Calendar.MINUTE));
				horaInicial.add(Calendar.DATE, 1);
				
		Calendar horaFin=fechare2;
		System.out.println(horaInicial.getTime()+"ver q show 0");
		
		horaFin.set(horaFin.get(Calendar.YEAR),
				horaFin.get(Calendar.MONTH), 
				horaFin.get(Calendar.DAY_OF_MONTH), 
				horaFin.getActualMaximum(Calendar.HOUR_OF_DAY), 
				horaFin.getActualMaximum(Calendar.MINUTE));
		horaFin.add(Calendar.DATE, -1);
		
		Date inicio=horaFin.getTime();
		Date fin = horaInicial.getTime();
		
		System.out.println(inicio);
		System.out.println(fin+"esta es la inicial");
		//List<Renta> listadia = reporteDiaDao.findByFechas(inicio, fin);
		//return listadia;
		
		return rentaDao.findByFechas(inicio, fin);
	}
	
	public List<Renta> fechasF() {
		
		Calendar horaInicial=Calendar.getInstance(); 
		Calendar horaFin=Calendar.getInstance();
	
		horaInicial.set(horaInicial.get(Calendar.YEAR),
				horaInicial.get(Calendar.MONTH),
				horaInicial.get(Calendar.DAY_OF_MONTH), 
				horaInicial.getActualMinimum(Calendar.HOUR_OF_DAY), 
				horaInicial.getActualMinimum(Calendar.MINUTE));
				horaInicial.add(Calendar.DATE, 1);
						
		horaFin.set(horaFin.get(Calendar.YEAR),
				horaFin.get(Calendar.MONTH), 
				horaFin.get(Calendar.DAY_OF_MONTH), 
				horaFin.getActualMaximum(Calendar.HOUR_OF_DAY), 
				horaFin.getActualMaximum(Calendar.MINUTE));
		horaFin.add(Calendar.DATE, -1);
		
		Date inicio=horaFin.getTime();
		Date fin = horaInicial.getTime();

		return rentaDao.findByFechas(inicio, fin);
	}

}
