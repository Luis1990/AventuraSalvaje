package com.aventurasalvaje.renta;

import java.util.Calendar;
import java.util.List;

import com.aventurasalvaje.dao.PreciosDAO;
import com.aventurasalvaje.dao.ProductoExistenciaDAO;
import com.aventurasalvaje.dao.RentaDAO;
import com.aventurasalvaje.dao.SucursalDAO;
import com.aventurasalvaje.pojos.Precios;
import com.aventurasalvaje.pojos.ProductoExistencia;
import com.aventurasalvaje.pojos.Renta;
import com.aventurasalvaje.pojos.Sucursal;

public class RentaBo {

	public ProductoExistenciaDAO productoexistenciaDao;
	public RentaDAO rentaDao = new RentaDAO();
	public PreciosDAO PreciosDao = new PreciosDAO();

	public RentaBo() {
		//se inicializa la clase ProductoExistenciaDAO para su uso a lo largo de su instancia
		productoexistenciaDao=new ProductoExistenciaDAO();
	}
	public List<ProductoExistencia> getProductos() {
		//Solo uso el metodo del Dao que regresa ya todos los usuarios y asi como se recuperan se mandan al Controller

		List<ProductoExistencia> pro=productoexistenciaDao.findAll();
		return productoexistenciaDao.findAll();
	}

	public Renta renta(int idProductoExistencia){
		//		Renta renta=rentaDao.findByidproducto(idProductoExistencia);
		return rentaDao.findByidproducto(idProductoExistencia);
	}

	public void Save(Integer idproducto,Calendar inicio){
		//RentaDAO rentaDao=new RentaDAO();
		Renta renta=new Renta();
		//renta.setHoraEntrada(inicio.getTime());
		inicio.set(inicio.get(Calendar.YEAR),
		inicio.get(Calendar.MONTH), 
		inicio.get(Calendar.DATE), 
		inicio.get(Calendar.HOUR_OF_DAY), 
		inicio.get(Calendar.MINUTE), 
		inicio.getActualMinimum(Calendar.SECOND));
		renta.setHoraEntrada(inicio.getTime());
		renta.setProductoExistencia(productoexistenciaDao.findByid(idproducto));
		rentaDao.save(renta);
	}

	public void Update(Integer idrenta,Calendar fin){
		RentaDAO rentaDAO=new RentaDAO();
		Renta renta=rentaDAO.findByid(idrenta);
		fin.set(fin.get(Calendar.YEAR),
				fin.get(Calendar.MONTH), 
				fin.get(Calendar.DATE), 
				fin.get(Calendar.HOUR_OF_DAY), 
				fin.get(Calendar.MINUTE), 
				fin.getActualMinimum(Calendar.SECOND));
		renta.setHoraSalida(fin.getTime());
		rentaDAO.update(renta);
	}

	public Precios precios(int idSucursal){
		SucursalDAO sucursalDao=new SucursalDAO();
		return sucursalDao.findById(idSucursal).getPrecios();
	}

}
