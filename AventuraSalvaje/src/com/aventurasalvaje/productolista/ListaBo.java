package com.aventurasalvaje.productolista;

import java.util.List;

import com.aventurasalvaje.dao.CatalogoDAO;
import com.aventurasalvaje.dao.ProductoExistenciaDAO;
import com.aventurasalvaje.pojos.Catalogo;
import com.aventurasalvaje.pojos.ProductoExistencia;

	   public class ListaBo {
	
	   public ProductoExistenciaDAO productolistaDao;
	   

		public ListaBo() {
		productolistaDao=new ProductoExistenciaDAO();
		
	}

		public List<ProductoExistencia>  getProductoExistencias() {
			return productolistaDao.findAll();
			
		}

		public List<Catalogo> getCatalogo() {
			CatalogoDAO catalogo= new CatalogoDAO();
			
			return catalogo.findAll();
		}
		
 }
	



