package com.aventurasalvaje.pojos;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Catalogo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.aventurasalvaje.pojos.Catalogo
 * @author MyEclipse Persistence Tools
 */

public class CatalogoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CatalogoDAO.class);
	// property constants
	public static final String NOMBRE_PRODUCTO = "nombreProducto";

	public void save(Catalogo transientInstance) {
		log.debug("saving Catalogo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Catalogo persistentInstance) {
		log.debug("deleting Catalogo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Catalogo findById(java.lang.Integer id) {
		log.debug("getting Catalogo instance with id: " + id);
		try {
			Catalogo instance = (Catalogo) getSession().get(
					"com.aventurasalvaje.pojos.Catalogo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Catalogo instance) {
		log.debug("finding Catalogo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.aventurasalvaje.pojos.Catalogo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Catalogo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Catalogo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNombreProducto(Object nombreProducto) {
		return findByProperty(NOMBRE_PRODUCTO, nombreProducto);
	}

	public List findAll() {
		log.debug("finding all Catalogo instances");
		try {
			String queryString = "from Catalogo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Catalogo merge(Catalogo detachedInstance) {
		log.debug("merging Catalogo instance");
		try {
			Catalogo result = (Catalogo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Catalogo instance) {
		log.debug("attaching dirty Catalogo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Catalogo instance) {
		log.debug("attaching clean Catalogo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}