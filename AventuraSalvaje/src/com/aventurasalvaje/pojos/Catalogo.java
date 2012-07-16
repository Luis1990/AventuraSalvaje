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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Catalogo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "catalogo", catalog = "aventurasalvaje")
public class Catalogo implements java.io.Serializable {

	// Fields

	private Integer idCatalogo;
	private String nombreProducto;
	private String nombreArchivo;
	private Set<ProductoExistencia> productoExistencias = new HashSet<ProductoExistencia>(
			0);

	// Constructors

	/** default constructor */
	public Catalogo() {
	}

	/** minimal constructor */
	public Catalogo(String nombreProducto, String nombreArchivo) {
		this.nombreProducto = nombreProducto;
		this.nombreArchivo = nombreArchivo;
	}

	/** full constructor */
	public Catalogo(String nombreProducto, String nombreArchivo,
			Set<ProductoExistencia> productoExistencias) {
		this.nombreProducto = nombreProducto;
		this.nombreArchivo = nombreArchivo;
		this.productoExistencias = productoExistencias;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCatalogo", unique = true, nullable = false)
	public Integer getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	@Column(name = "nombre_producto", nullable = false, length = 45)
	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	@Column(name = "nombre_archivo", nullable = false, length = 20)
	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "catalogo")
	public Set<ProductoExistencia> getProductoExistencias() {
		return this.productoExistencias;
	}

	public void setProductoExistencias(
			Set<ProductoExistencia> productoExistencias) {
		this.productoExistencias = productoExistencias;
	}

}