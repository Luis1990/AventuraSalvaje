package com.aventurasalvaje.renta;

import java.util.List;

import com.aventurasalvaje.pojos.ProductoExistencia;
import com.aventurasalvaje.dao.ProductoExistenciaDAO;

public class RentaBo {

	public ProductoExistenciaDAO productoexistenciaDao;
	
	public RentaBo() {
		//se inicializa la clase ProductoExistenciaDAO para su uso a lo largo de su instancia
		productoexistenciaDao=new ProductoExistenciaDAO();
	}
	public List<ProductoExistencia> getProductos() {
		//Solo uso el metodo del Dao que regresa ya todos los usuarios y asi como se recuperan se mandan al Controller
		
		List<ProductoExistencia> pro=productoexistenciaDao.findAll();
		for (ProductoExistencia productoExistencia : pro) {
			System.out.println("BO:"+productoExistencia.getDescripcionGral());
			System.out.println("BO:--"+productoExistencia.getCatalogo().getNombreProducto());
		}
		return productoexistenciaDao.findAll();
	}
}
