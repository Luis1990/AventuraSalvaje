package com.aventurasalvaje.pojos;

import java.sql.Time;
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
 * Renta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "renta", catalog = "aventurasalvaje")
public class Renta implements java.io.Serializable {

	// Fields

	private Integer idRenta;
	private ProductoExistencia productoExistencia;
	private Time horaEntrada;
	private Time horaSalida;

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
	@GeneratedValue(strategy = IDENTITY)
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
	public Time getHoraEntrada() {
		return this.horaEntrada;
	}

	public void setHoraEntrada(Time horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	@Column(name = "hora_salida", nullable = false, length = 8)
	public Time getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

}