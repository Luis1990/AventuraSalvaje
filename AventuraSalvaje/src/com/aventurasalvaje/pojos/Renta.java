package com.aventurasalvaje.pojos;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Renta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "renta", catalog = "aventurasalvaje")
public class Renta implements java.io.Serializable {

	// Fields

	private Integer idRenta;
	private ProductoExistencia productoExistencia;
	private Date horaEntrada;
	private Date horaSalida;

	// Constructors

	/** default constructor */
	public Renta() {
	}

	/** full constructor */
	public Renta(ProductoExistencia productoExistencia, Time horaEntrada,
			Time horaSalida) {
		this.productoExistencia = productoExistencia;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idRenta", unique = true, nullable = false)
	public Integer getIdRenta() {
		return this.idRenta;
	}

	public void setIdRenta(Integer idRenta) {
		this.idRenta = idRenta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProducto_existencia", nullable = false)
	public ProductoExistencia getProductoExistencia() {
		return this.productoExistencia;
	}

	public void setProductoExistencia(ProductoExistencia productoExistencia) {
		this.productoExistencia = productoExistencia;
	}

	@Column(name = "hora_entrada", nullable = false, length = 8)
	public Date getHoraEntrada() {
		return this.horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	@Column(name = "hora_salida", nullable=true)
	public Date getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

}