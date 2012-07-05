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
 * Precios entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.aventurasalvaje.pojos.Precios
 * @author MyEclipse Persistence Tools
 */

public class PreciosDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PreciosDAO.class);
	// property constants
	public static final String ID_SUCURSAL = "idSucursal";
	public static final String COSTO_TOTAL = "costoTotal";
	public static final String COSTO_EXTRA = "costoExtra";

	public void save(Precios transientInstance) {
		log.debug("saving Precios instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Precios persistentInstance) {
		log.debug("deleting Precios instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Precios findById(java.lang.Integer id) {
		log.debug("getting Precios instance with id: " + id);
		try {
			Precios instance = (Precios) getSession().get(
					"com.aventurasalvaje.pojos.Precios", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Precios instance) {
		log.debug("finding Precios instance by example");
		try {
			List results = getSession()
					.createCriteria("com.aventurasalvaje.pojos.Precios")
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
		log.debug("finding Precios instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Precios as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIdSucursal(Object idSucursal) {
		return findByProperty(ID_SUCURSAL, idSucursal);
	}

	public List findByCostoTotal(Object costoTotal) {
		return findByProperty(COSTO_TOTAL, costoTotal);
	}

	public List findByCostoExtra(Object costoExtra) {
		return findByProperty(COSTO_EXTRA, costoExtra);
	}

	public List findAll() {
		log.debug("finding all Precios instances");
		try {
			String queryString = "from Precios";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Precios merge(Precios detachedInstance) {
		log.debug("merging Precios instance");
		try {
			Precios result = (Precios) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Precios instance) {
		log.debug("attaching dirty Precios instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Precios instance) {
		log.debug("attaching clean Precios instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}