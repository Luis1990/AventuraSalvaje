package com.aventurasalvaje.pojos;

import java.sql.Time;

/**
 * AbstractRenta entity provides the base persistence definition of the Renta
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRenta implements java.io.Serializable {

	// Fields

	private Integer idRenta;
	private ProductoExistencia productoExistencia;
	private Time horaEntrada;
	private Time horaSalida;

	// Constructors

	/** default constructor */
	public AbstractRenta() {
	}

	/** full constructor */
	public AbstractRenta(ProductoExistencia productoExistencia,
			Time horaEntrada, Time horaSalida) {
		this.productoExistencia = productoExistencia;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
	}

	// Property accessors

	public Integer getIdRenta() {
		return this.idRenta;
	}

	public void setIdRenta(Integer idRenta) {
		this.idRenta = idRenta;
	}

	public ProductoExistencia getProductoExistencia() {
		return this.productoExistencia;
	}

	public void setProductoExistencia(ProductoExistencia productoExistencia) {
		this.productoExistencia = productoExistencia;
	}

	public Time getHoraEntrada() {
		return this.horaEntrada;
	}

	public void setHoraEntrada(Time horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Time getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

}