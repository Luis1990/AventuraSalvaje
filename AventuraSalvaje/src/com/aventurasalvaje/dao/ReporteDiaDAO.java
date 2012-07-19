package com.aventurasalvaje.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.Renta;


public class ReporteDiaDAO {
	
	public List<Renta> findAll(){
	
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Renta.class);
		
		return criteria.list();
	}
	
	public List<Renta> findByFechas(Date fechaInicial, Date fechaFin){
		
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Renta.class);
		criteria.add(Restrictions.between("horaEntrada",fechaInicial,fechaFin));
	
		//12:01 - 11:59
		
		return criteria.list();
				
	}
	
}
