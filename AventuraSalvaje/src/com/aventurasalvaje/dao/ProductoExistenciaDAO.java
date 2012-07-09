package com.aventurasalvaje.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.ProductoExistencia;

public class ProductoExistenciaDAO {

	@SuppressWarnings("unchecked")
	public List<ProductoExistencia> findAll(){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(ProductoExistencia.class);
		List<ProductoExistencia> pro=criteria.list();
		for (ProductoExistencia productoExistencia : pro) {
			System.out.println(productoExistencia.getDescripcionGral());
			System.out.println(productoExistencia.getCatalogo().getNombreProducto());
		}
		
		return criteria.list();
	}
}
