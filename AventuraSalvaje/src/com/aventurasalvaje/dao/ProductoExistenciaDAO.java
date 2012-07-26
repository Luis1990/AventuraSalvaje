package com.aventurasalvaje.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.aventurasalvaje.hibernate.HibernateSessionFactory;
import com.aventurasalvaje.pojos.Catalogo;
import com.aventurasalvaje.pojos.ProductoExistencia;
import com.aventurasalvaje.pojos.Usuario;

public class ProductoExistenciaDAO {

	@SuppressWarnings("unchecked")
	public List<ProductoExistencia> findAll(){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(ProductoExistencia.class);
		List<ProductoExistencia> pro=criteria.list();		
		return criteria.list();
	}

	public ProductoExistencia findByid(int idproducto) {
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(ProductoExistencia.class);
		criteria.add(Restrictions.eq("idProductoExistencia", idproducto));
		return (ProductoExistencia) criteria.uniqueResult();
	}

	public void save(ProductoExistencia prod_cat) {
		Session session =HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(prod_cat);
		
		
	}
	public void dellete(ProductoExistencia producto) {
		Session session=HibernateSessionFactory.getSession();
		session.beginTransaction(); 
		session.delete(producto);
		Transaction t=session.getTransaction();
		t.commit();
		session.close();
	}
}
