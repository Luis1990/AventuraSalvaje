/**
 * 
 */
package com.aventurasalvaje.precios;

import java.util.Calendar;

import com.aventurasalvaje.dao.PreciosDAO;
import com.aventurasalvaje.pojos.Precios;

/**
 * @author carlos
 *
 */
public class PreciosBo {
	public PreciosDAO PreciosDao = new PreciosDAO();
	
	public PreciosBo() {
		PreciosDao=new PreciosDAO();	
	}
	
	public void Save(String precio,long extra){
		Precios precios= new Precios();
		precios.setIdSucursal(2);
		precios.setCostoTotal(precio);
		precios.setCostoExtra(extra);
		precios.setFechaVigencia(Calendar.getInstance().getTime());
		PreciosDao.save(precios);
	}
}
