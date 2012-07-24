package com.aventurasalvaje.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Inventario entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "inventario", catalog = "aventurasalvaje")
public class Inventario implements java.io.Serializable {

	// Fields

	private Integer idInventario;
	private Integer idSucursal;
	private Integer idExistencia;

	// Constructors

	/** default constructor */
	public Inventario() {
	}

	/** full constructor */
	public Inventario(Integer idSucursal, Integer idExistencia) {
		this.idSucursal = idSucursal;
		this.idExistencia = idExistencia;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idInventario", unique = true, nullable = false)
	public Integer getIdInventario() {
		return this.idInventario;
	}

	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}

	@Column(name = "idSucursal", nullable = false)
	public Integer getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	@Column(name = "idExistencia", nullable = false)
	public Integer getIdExistencia() {
		return this.idExistencia;
	}

	public void setIdExistencia(Integer idExistencia) {
		this.idExistencia = idExistencia;
	}

}