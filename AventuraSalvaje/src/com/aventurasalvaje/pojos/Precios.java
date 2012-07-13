package com.aventurasalvaje.pojos;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Precios entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "precios", catalog = "aventurasalvaje")
public class Precios implements java.io.Serializable {

	// Fields

	private Integer idPrecios;
	private Sucursal sucursal;
	private String costoTotal;
	private Long costoExtra;
	private Date fechaVigencia;

	// Constructors

	/** default constructor */
	public Precios() {
	}

	/** minimal constructor */
	public Precios(Sucursal sucursal, Date fechaVigencia) {
		this.sucursal = sucursal;
		this.fechaVigencia = fechaVigencia;
	}

	/** full constructor */
	public Precios(Sucursal sucursal, String costoTotal, Long costoExtra,
			Date fechaVigencia) {
		this.sucursal = sucursal;
		this.costoTotal = costoTotal;
		this.costoExtra = costoExtra;
		this.fechaVigencia = fechaVigencia;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSucursal", nullable = false)
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@Column(name = "costo_total", length = 50)
	public String getCostoTotal() {
		return this.costoTotal;
	}

	public void setCostoTotal(String costoTotal) {
		this.costoTotal = costoTotal;
	}

	@Column(name = "costo_extra", precision = 10, scale = 0)
	public Long getCostoExtra() {
		return this.costoExtra;
	}

	public void setCostoExtra(Long costoExtra) {
		this.costoExtra = costoExtra;
	}

	@Column(name = "fecha_vigencia", nullable = false, length = 19)
	public Date getFechaVigencia() {
		return this.fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

}