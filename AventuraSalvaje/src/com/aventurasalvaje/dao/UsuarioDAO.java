package com.aventurasalvaje.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.Usuario;

public class UsuarioDAO {

	public List<Usuario> findAll(){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Usuario.class);
		
		return criteria.list();
	}
}
