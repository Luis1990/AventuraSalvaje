package com.aventurasalvaje.dao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.ProductoExistencia;
import com.aventurasalvaje.pojos.Renta;

public class RentaDAO {

	public void save(Renta renta){
		try {
			Session session = HibernateSessionFactory.getSession();
			//session.save(renta);
			session.save(renta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Renta findByid(int idrenta) {
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Renta.class);
		criteria.add(Restrictions.eq("idRenta", idrenta));
		return (Renta) criteria.uniqueResult();
	}
}