package com.aventurasalvaje.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.Catalogo;
import com.aventurasalvaje.pojos.ProductoExistencia;

public class CatalogoDAO {

	@SuppressWarnings("unchecked")
	public List<Catalogo> findAll(){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Catalogo.class);
		return criteria.list();
	}
}