package com.aventurasalvaje.pojos;

/**
 * AbstractInventario entity provides the base persistence definition of the
 * Inventario entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractInventario implements java.io.Serializable {

	// Fields

	private Integer idInventario;
	private Sucursal sucursal;
	private ProductoExistencia productoExistencia;

	// Constructors

	/** default constructor */
	public AbstractInventario() {
	}

	/** full constructor */
	public AbstractInventario(Sucursal sucursal,
			ProductoExistencia productoExistencia) {
		this.sucursal = sucursal;
		this.productoExistencia = productoExistencia;
	}

	// Property accessors

	public Integer getIdInventario() {
		return this.idInventario;
	}

	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public ProductoExistencia getProductoExistencia() {
		return this.productoExistencia;
	}

	public void setProductoExistencia(ProductoExistencia productoExistencia) {
		this.productoExistencia = productoExistencia;
	}

}