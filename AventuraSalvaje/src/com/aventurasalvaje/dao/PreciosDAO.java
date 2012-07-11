package com.aventurasalvaje.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.Precios;

public class PreciosDAO {

	public Precios findByidsucursal(int idsucursal) {
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Precios.class);
		criteria.add(Restrictions.eq("idSucursal", idsucursal));
		return (Precios) criteria.uniqueResult();
	}
}
