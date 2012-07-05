package com.aventurasalvaje.pojos;

import java.sql.Timestamp;

/**
 * AbstractCobros entity provides the base persistence definition of the Cobros
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCobros implements java.io.Serializable {

	// Fields

	private Integer idCobros;
	private Precios precios;
	private Usuario usuario;
	private Timestamp fecha;

	// Constructors

	/** default constructor */
	public AbstractCobros() {
	}

	/** full constructor */
	public AbstractCobros(Precios precios, Usuario usuario, Timestamp fecha) {
		this.precios = precios;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	// Property accessors

	public Integer getIdCobros() {
		return this.idCobros;
	}

	public void setIdCobros(Integer idCobros) {
		this.idCobros = idCobros;
	}

	public Precios getPrecios() {
		return this.precios;
	}

	public void setPrecios(Precios precios) {
		this.precios = precios;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

}