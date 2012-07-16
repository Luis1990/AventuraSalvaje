package com.aventurasalvaje.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.ProductoExistencia;

public class ProductoExistenciaDAO {

	@SuppressWarnings("unchecked")
	public List<ProductoExistencia> findAll(){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(ProductoExistencia.class);
		List<ProductoExistencia> pro=criteria.list();		
		return criteria.list();
	}

	public ProductoExistencia findByid(int idproducto) {
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(ProductoExistencia.class);
		criteria.add(Restrictions.eq("idProductoExistencia", idproducto));
		return (ProductoExistencia) criteria.uniqueResult();
	}
}
