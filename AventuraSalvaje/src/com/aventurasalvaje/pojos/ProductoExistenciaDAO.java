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
 * ProductoExistencia entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.aventurasalvaje.pojos.ProductoExistencia
 * @author MyEclipse Persistence Tools
 */

public class ProductoExistenciaDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ProductoExistenciaDAO.class);
	// property constants
	public static final String DESCRIPCION_GRAL = "descripcionGral";

	public void save(ProductoExistencia transientInstance) {
		log.debug("saving ProductoExistencia instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProductoExistencia persistentInstance) {
		log.debug("deleting ProductoExistencia instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProductoExistencia findById(java.lang.Integer id) {
		log.debug("getting ProductoExistencia instance with id: " + id);
		try {
			ProductoExistencia instance = (ProductoExistencia) getSession()
					.get("com.aventurasalvaje.pojos.ProductoExistencia", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ProductoExistencia instance) {
		log.debug("finding ProductoExistencia instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.aventurasalvaje.pojos.ProductoExistencia")
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
		log.debug("finding ProductoExistencia instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ProductoExistencia as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDescripcionGral(Object descripcionGral) {
		return findByProperty(DESCRIPCION_GRAL, descripcionGral);
	}

	public List findAll() {
		log.debug("finding all ProductoExistencia instances");
		try {
			String queryString = "from ProductoExistencia";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProductoExistencia merge(ProductoExistencia detachedInstance) {
		log.debug("merging ProductoExistencia instance");
		try {
			ProductoExistencia result = (ProductoExistencia) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ProductoExistencia instance) {
		log.debug("attaching dirty ProductoExistencia instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProductoExistencia instance) {
		log.debug("attaching clean ProductoExistencia instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}