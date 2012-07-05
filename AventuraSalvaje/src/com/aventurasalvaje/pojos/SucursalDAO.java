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
 * Sucursal entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.aventurasalvaje.pojos.Sucursal
 * @author MyEclipse Persistence Tools
 */

public class SucursalDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SucursalDAO.class);
	// property constants
	public static final String DIRECCION = "direccion";
	public static final String NOMBRE = "nombre";
	public static final String TELEFONO = "telefono";
	public static final String CONTACTO = "contacto";

	public void save(Sucursal transientInstance) {
		log.debug("saving Sucursal instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sucursal persistentInstance) {
		log.debug("deleting Sucursal instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sucursal findById(java.lang.Integer id) {
		log.debug("getting Sucursal instance with id: " + id);
		try {
			Sucursal instance = (Sucursal) getSession().get(
					"com.aventurasalvaje.pojos.Sucursal", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sucursal instance) {
		log.debug("finding Sucursal instance by example");
		try {
			List results = getSession()
					.createCriteria("com.aventurasalvaje.pojos.Sucursal")
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
		log.debug("finding Sucursal instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sucursal as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDireccion(Object direccion) {
		return findByProperty(DIRECCION, direccion);
	}

	public List findByNombre(Object nombre) {
		return findByProperty(NOMBRE, nombre);
	}

	public List findByTelefono(Object telefono) {
		return findByProperty(TELEFONO, telefono);
	}

	public List findByContacto(Object contacto) {
		return findByProperty(CONTACTO, contacto);
	}

	public List findAll() {
		log.debug("finding all Sucursal instances");
		try {
			String queryString = "from Sucursal";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sucursal merge(Sucursal detachedInstance) {
		log.debug("merging Sucursal instance");
		try {
			Sucursal result = (Sucursal) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sucursal instance) {
		log.debug("attaching dirty Sucursal instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sucursal instance) {
		log.debug("attaching clean Sucursal instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}