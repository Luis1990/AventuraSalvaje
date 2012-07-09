package com.aventurasalvaje.pojos;

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
 * Inventario entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "inventario", catalog = "aventurasalvaje")
public class Inventario implements java.io.Serializable {

	// Fields

	private Integer idInventario;
	private Sucursal sucursal;
	private ProductoExistencia productoExistencia;

	// Constructors

	/** default constructor */
	public Inventario() {
	}

	/** full constructor */
	public Inventario(Sucursal sucursal, ProductoExistencia productoExistencia) {
		this.sucursal = sucursal;
		this.productoExistencia = productoExistencia;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSucursal", nullable = false)
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idExistencia", nullable = false)
	public ProductoExistencia getProductoExistencia() {
		return this.productoExistencia;
	}

	public void setProductoExistencia(ProductoExistencia productoExistencia) {
		this.productoExistencia = productoExistencia;
	}

}