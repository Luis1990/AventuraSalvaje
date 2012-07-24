package com.aventurasalvaje.productolista;

import java.util.List;

import com.aventurasalvaje.dao.CatalogoDAO;
import com.aventurasalvaje.dao.ProductoExistenciaDAO;
import com.aventurasalvaje.dao.SucursalDAO;
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

		public void save(Catalogo prod_cat, Integer idSucursal, String descripcion) {
			SucursalDAO sucursaldao= new SucursalDAO();
			ProductoExistencia cat_prod = new ProductoExistencia();
			cat_prod.setCatalogo(prod_cat);
			cat_prod.setDescripcionGral(descripcion);
			cat_prod.setSucursal(sucursaldao.findById(idSucursal));
			productolistaDao.save(cat_prod);
			
			
		}

		public void dellete(ProductoExistencia producto) {
			productolistaDao.dellete(productolistaDao.findByid(producto.getIdProductoExistencia()));
			
		}
		
 }
	



