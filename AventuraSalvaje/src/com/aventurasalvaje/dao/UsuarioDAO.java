package com.aventurasalvaje.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.Usuario;

public class UsuarioDAO {

	public List<Usuario> findAll(){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Usuario.class);
		
		return criteria.list();
	}

	public void dellete(Usuario usuario) {
		Session session=HibernateSessionFactory.getSession();
		session.beginTransaction(); 
		session.delete(usuario);
		Transaction t=session.getTransaction();
		t.commit();
		session.close();
	}

	public void save(Usuario usuario) {
		Session session=HibernateSessionFactory.getSession();
		session.save(usuario);
		session.beginTransaction(); 
		Transaction t=session.getTransaction();
		t.commit();
		session.close();
	}
	
	public Usuario findByid(Integer idusario){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("idUsuario", idusario));
		return (Usuario) criteria.uniqueResult();
	}

	public void Update(Usuario usuario) {
		try {
			Session session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			session.update(usuario);
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
