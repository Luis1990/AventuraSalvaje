package com.aventurasalvaje.pojos;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Precios entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "precios", catalog = "aventurasalvaje")
public class Precios implements java.io.Serializable {

	// Fields

	private Integer idPrecios;
	private Integer idSucursal;
	private Long costoTotal;
	private Long costoExtra;
	private Date fechaVigencia;
	private Set<Sucursal> sucursals = new HashSet<Sucursal>(0);

	// Constructors

	/** default constructor */
	public Precios() {
	}

	/** minimal constructor */
	public Precios(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	/** full constructor */
	public Precios(Integer idSucursal, Long costoTotal, Long costoExtra,
			Date fechaVigencia, Set<Sucursal> sucursals) {
		this.idSucursal = idSucursal;
		this.costoTotal = costoTotal;
		this.costoExtra = costoExtra;
		this.fechaVigencia = fechaVigencia;
		this.sucursals = sucursals;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPrecios", unique = true, nullable = false)
	public Integer getIdPrecios() {
		return this.idPrecios;
	}

	public void setIdPrecios(Integer idPrecios) {
		this.idPrecios = idPrecios;
	}

	@Column(name = "idSucursal")
	public Integer getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	@Column(name = "costo_total", precision = 10, scale = 0)
	public Long getCostoTotal() {
		return this.costoTotal;
	}

	public void setCostoTotal(Long costoTotal) {
		this.costoTotal = costoTotal;
	}

	@Column(name = "costo_extra", precision = 10, scale = 0)
	public Long getCostoExtra() {
		return this.costoExtra;
	}

	public void setCostoExtra(Long costoExtra) {
		this.costoExtra = costoExtra;
	}

	@Column(name = "fecha_vigencia", nullable = false, length = 10)
	public Date getFechaVigencia() {
		return this.fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "precios")
	public Set<Sucursal> getSucursals() {
		return this.sucursals;
	}

	public void setSucursals(Set<Sucursal> sucursals) {
		this.sucursals = sucursals;
	}

}