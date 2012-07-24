package com.aventurasalvaje.pojos;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ProductoExistencia entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "producto_existencia", catalog = "aventurasalvaje")
public class ProductoExistencia implements java.io.Serializable {

	// Fields

	private Integer idProductoExistencia;
	private Sucursal sucursal;
	private Catalogo catalogo;
	private String descripcionGral;
	private Set<Renta> rentas = new HashSet<Renta>(0);

	// Constructors

	/** default constructor */
	public ProductoExistencia() {
	}

	/** minimal constructor */
	public ProductoExistencia(Sucursal sucursal, Catalogo catalogo) {
		this.sucursal = sucursal;
		this.catalogo = catalogo;
	}

	/** full constructor */
	public ProductoExistencia(Sucursal sucursal, Catalogo catalogo,
			String descripcionGral, Set<Renta> rentas) {
		this.sucursal = sucursal;
		this.catalogo = catalogo;
		this.descripcionGral = descripcionGral;
		this.rentas = rentas;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idProducto_existencia", unique = true, nullable = false)
	public Integer getIdProductoExistencia() {
		return this.idProductoExistencia;
	}

	public void setIdProductoExistencia(Integer idProductoExistencia) {
		this.idProductoExistencia = idProductoExistencia;
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
	@JoinColumn(name = "idCatalogo", nullable = false)
	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	@Column(name = "descripcion_gral", length = 45)
	public String getDescripcionGral() {
		return this.descripcionGral;
	}

	public void setDescripcionGral(String descripcionGral) {
		this.descripcionGral = descripcionGral;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productoExistencia")
	public Set<Renta> getRentas() {
		return this.rentas;
	}

	public void setRentas(Set<Renta> rentas) {
		this.rentas = rentas;
	}

}