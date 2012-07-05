package com.aventurasalvaje.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCatalogo entity provides the base persistence definition of the
 * Catalogo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCatalogo implements java.io.Serializable {

	// Fields

	private Integer idCatalogo;
	private String nombreProducto;
	private Set productoExistencias = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCatalogo() {
	}

	/** minimal constructor */
	public AbstractCatalogo(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	/** full constructor */
	public AbstractCatalogo(String nombreProducto, Set productoExistencias) {
		this.nombreProducto = nombreProducto;
		this.productoExistencias = productoExistencias;
	}

	// Property accessors

	public Integer getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Set getProductoExistencias() {
		return this.productoExistencias;
	}

	public void setProductoExistencias(Set productoExistencias) {
		this.productoExistencias = productoExistencias;
	}

}