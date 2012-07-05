package com.aventurasalvaje.pojos;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cobros entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.aventurasalvaje.pojos.Cobros
 * @author MyEclipse Persistence Tools
 */

public class CobrosDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CobrosDAO.class);

	// property constants

	public void save(Cobros transientInstance) {
		log.debug("saving Cobros instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cobros persistentInstance) {
		log.debug("deleting Cobros instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cobros findById(java.lang.Integer id) {
		log.debug("getting Cobros instance with id: " + id);
		try {
			Cobros instance = (Cobros) getSession().get(
					"com.aventurasalvaje.pojos.Cobros", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cobros instance) {
		log.debug("finding Cobros instance by example");
		try {
			List results = getSession()
					.createCriteria("com.aventurasalvaje.pojos.Cobros")
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
		log.debug("finding Cobros instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cobros as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Cobros instances");
		try {
			String queryString = "from Cobros";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cobros merge(Cobros detachedInstance) {
		log.debug("merging Cobros instance");
		try {
			Cobros result = (Cobros) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cobros instance) {
		log.debug("attaching dirty Cobros instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cobros instance) {
		log.debug("attaching clean Cobros instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}