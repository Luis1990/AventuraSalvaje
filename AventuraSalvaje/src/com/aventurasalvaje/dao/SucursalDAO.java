package com.aventurasalvaje.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.Sucursal;

public class SucursalDAO {
	
	public Sucursal findById(Integer idSucursal){
		Session session= HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(Sucursal.class);
		
		criteria.add(Restrictions.eq("idSucursal", idSucursal));
		return (Sucursal) criteria.uniqueResult();
		
	
	}

}
