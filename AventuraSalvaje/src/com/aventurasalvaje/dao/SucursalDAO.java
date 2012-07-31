package com.aventurasalvaje.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.Sucursal;
import com.aventurasalvaje.pojos.Usuario;

public class SucursalDAO {
	
	public Sucursal findById(Integer idSucursal){
		
		Session session= HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(Sucursal.class);
		
		criteria.add(Restrictions.eq("idSucursal", idSucursal));
		return (Sucursal) criteria.uniqueResult();
	}

	
	public void save(Sucursal sucursal) {
		
		Session session=HibernateSessionFactory.getSession();
		session.save(sucursal);
		System.out.println(sucursal.getNombre());
		session.beginTransaction(); 
		Transaction t=session.getTransaction();
		t.commit();
		session.close();
		
		
	}


	public Sucursal findsucursal(int idSucursal) {

		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Sucursal.class);
		criteria.add(Restrictions.eq("idSucursal", idSucursal));
		return  (Sucursal) criteria.uniqueResult();
	}
	
	

}
