package com.aventurasalvaje.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.ProductoExistencia;
import com.aventurasalvaje.pojos.Renta;

public class RentaDAO {

	public void save(Renta renta){
		try {
			Session session = HibernateSessionFactory.getSession();
			session.save(renta);
			session.beginTransaction();
			closeSession(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Renta renta){
		try {
			Session session = HibernateSessionFactory.getSession();
			//session.save(renta);
			session.update(renta);
			session.beginTransaction();
			closeSession(session);
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
	
	public Renta findByidproducto(int idProductoExistencia) {
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Renta.class);
		criteria.add(Restrictions.eq("productoExistencia.idProductoExistencia",idProductoExistencia));
		criteria.addOrder(Order.desc("idRenta"));        
		return (Renta) criteria.list().get(0);
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
	
	public List<Renta> findByFechas(Date fechaInicial, Date fechaFin){

		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Renta.class);
		criteria.add(Restrictions.between("horaEntrada",fechaInicial,fechaFin));
		return criteria.list();	
	}
}