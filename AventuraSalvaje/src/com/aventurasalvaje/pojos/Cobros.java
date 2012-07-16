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
 * Cobros entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cobros", catalog = "aventurasalvaje")
public class Cobros implements java.io.Serializable {

	// Fields

	private Integer idCobros;
	private Usuario usuario;
	private Date fecha;

	// Constructors

	/** default constructor */
	public Cobros() {
	}

	/** full constructor */
	public Cobros(Usuario usuario, Date fecha) {
		this.usuario = usuario;
		this.fecha = fecha;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCobros", unique = true, nullable = false)
	public Integer getIdCobros() {
		return this.idCobros;
	}

	public void setIdCobros(Integer idCobros) {
		this.idCobros = idCobros;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "fecha", length = 19)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}