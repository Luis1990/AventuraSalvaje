package com.aventurasalvaje.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractProductoExistencia entity provides the base persistence definition of
 * the ProductoExistencia entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractProductoExistencia implements
		java.io.Serializable {

	// Fields

	private Integer idProductoExistencia;
	private Catalogo catalogo;
	private String descripcionGral;
	private Set rentas = new HashSet(0);
	private Set inventarios = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractProductoExistencia() {
	}

	/** minimal constructor */
	public AbstractProductoExistencia(Catalogo catalogo, String descripcionGral) {
		this.catalogo = catalogo;
		this.descripcionGral = descripcionGral;
	}

	/** full constructor */
	public AbstractProductoExistencia(Catalogo catalogo,
			String descripcionGral, Set rentas, Set inventarios) {
		this.catalogo = catalogo;
		this.descripcionGral = descripcionGral;
		this.rentas = rentas;
		this.inventarios = inventarios;
	}

	// Property accessors

	public Integer getIdProductoExistencia() {
		return this.idProductoExistencia;
	}

	public void setIdProductoExistencia(Integer idProductoExistencia) {
		this.idProductoExistencia = idProductoExistencia;
	}

	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public String getDescripcionGral() {
		return this.descripcionGral;
	}

	public void setDescripcionGral(String descripcionGral) {
		this.descripcionGral = descripcionGral;
	}

	public Set getRentas() {
		return this.rentas;
	}

	public void setRentas(Set rentas) {
		this.rentas = rentas;
	}

	public Set getInventarios() {
		return this.inventarios;
	}

	public void setInventarios(Set inventarios) {
		this.inventarios = inventarios;
	}

}