/**
 * 
 */
package com.aventurasalvaje.pedidos;

import java.util.List;

import com.aventurasalvaje.dao.ProductoExistenciaDAO;
import com.aventurasalvaje.pojos.ProductoExistencia;

/**
 * @author SDGA
 *
 */
public class PedidosBo {
	
	public ProductoExistenciaDAO productoexistenciaDao;
	
	public  PedidosBo(){
		productoexistenciaDao = new ProductoExistenciaDAO();
	}

	public List<ProductoExistencia> getListapedido(){
		return productoexistenciaDao.findAll();		
	}
	
	
}
