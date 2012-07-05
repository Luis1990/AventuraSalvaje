package com.aventurasalvaje.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractPrecios entity provides the base persistence definition of the
 * Precios entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPrecios implements java.io.Serializable {

	// Fields

	private Integer idPrecios;
	private Integer idSucursal;
	private Long costoTotal;
	private Long costoExtra;
	private Set cobroses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractPrecios() {
	}

	/** full constructor */
	public AbstractPrecios(Integer idSucursal, Long costoTotal,
			Long costoExtra, Set cobroses) {
		this.idSucursal = idSucursal;
		this.costoTotal = costoTotal;
		this.costoExtra = costoExtra;
		this.cobroses = cobroses;
	}

	// Property accessors

	public Integer getIdPrecios() {
		return this.idPrecios;
	}

	public void setIdPrecios(Integer idPrecios) {
		this.idPrecios = idPrecios;
	}

	public Integer getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public Long getCostoTotal() {
		return this.costoTotal;
	}

	public void setCostoTotal(Long costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Long getCostoExtra() {
		return this.costoExtra;
	}

	public void setCostoExtra(Long costoExtra) {
		this.costoExtra = costoExtra;
	}

	public Set getCobroses() {
		return this.cobroses;
	}

	public void setCobroses(Set cobroses) {
		this.cobroses = cobroses;
	}

}