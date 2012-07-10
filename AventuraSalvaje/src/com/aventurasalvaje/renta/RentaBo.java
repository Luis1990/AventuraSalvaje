package com.aventurasalvaje.renta;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import com.aventurasalvaje.dao.ProductoExistenciaDAO;
import com.aventurasalvaje.dao.RentaDAO;
import com.aventurasalvaje.pojos.ProductoExistencia;
import com.aventurasalvaje.pojos.Renta;

public class RentaBo {

	public ProductoExistenciaDAO productoexistenciaDao;
	public RentaDAO rentaDao;
	
	public RentaBo() {
		//se inicializa la clase ProductoExistenciaDAO para su uso a lo largo de su instancia
		productoexistenciaDao=new ProductoExistenciaDAO();
	}
	public List<ProductoExistencia> getProductos() {
		//Solo uso el metodo del Dao que regresa ya todos los usuarios y asi como se recuperan se mandan al Controller
		
		List<ProductoExistencia> pro=productoexistenciaDao.findAll();
		return productoexistenciaDao.findAll();
	}
	
	public Renta Renta(int idrenta){
		Renta renta=rentaDao.findByid(idrenta);
		return rentaDao.findByid(idrenta);
	}
	
	public void Save(Integer idproducto,Calendar inicio){
		RentaDAO rentaDao=new RentaDAO();
		Renta renta=new Renta();
		renta.setHoraEntrada(inicio.getTime());
		renta.setProductoExistencia(productoexistenciaDao.findByid(idproducto));
		rentaDao.save(renta);
	}
	
}
