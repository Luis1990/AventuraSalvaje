package com.aventurasalvaje.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.Precios;
import com.aventurasalvaje.pojos.Renta;

public class PreciosDAO {

	public Precios findByidsucursal(int idsucursal) {
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Precios.class);
		criteria.add(Restrictions.eq("sucursals.idSucursal", idsucursal));
		return (Precios) criteria.uniqueResult();
	}
	public void save(Precios precios){
		try {
			Session session = HibernateSessionFactory.getSession();
			session.save(precios);
			session.beginTransaction();
			closeSession(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void closeSession(Session session) {
		try {
			Transaction t = session.getTransaction();
				t.commit();
		}
		finally {
			session.close();
		}
	}
}
