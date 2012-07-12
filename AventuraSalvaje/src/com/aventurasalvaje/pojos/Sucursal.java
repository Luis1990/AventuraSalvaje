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
 * Sucursal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sucursal", catalog = "aventurasalvaje")
public class Sucursal implements java.io.Serializable {

	// Fields

	private Integer idSucursal;
	private Precios precios;
	private String direccion;
	private String nombre;
	private Long telefono;
	private String contacto;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	private Set<Inventario> inventarios = new HashSet<Inventario>(0);
	private Set<Inventario> inventarios_1 = new HashSet<Inventario>(0);

	// Constructors

	/** default constructor */
	public Sucursal() {
	}

	/** minimal constructor */
	public Sucursal(String direccion, Long telefono, String contacto) {
		this.direccion = direccion;
		this.telefono = telefono;
		this.contacto = contacto;
	}

	/** full constructor */
	public Sucursal(Precios precios, String direccion, String nombre,
			Long telefono, String contacto, Set<Usuario> usuarios,
			Set<Inventario> inventarios, Set<Inventario> inventarios_1) {
		this.precios = precios;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
		this.contacto = contacto;
		this.usuarios = usuarios;
		this.inventarios = inventarios;
		this.inventarios_1 = inventarios_1;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idSucursal", unique = true, nullable = false)
	public Integer getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPrecio")
	public Precios getPrecios() {
		return this.precios;
	}

	public void setPrecios(Precios precios) {
		this.precios = precios;
	}

	@Column(name = "direccion", nullable = false, length = 45)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "telefono", nullable = false, precision = 10, scale = 0)
	public Long getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	@Column(name = "contacto", nullable = false, length = 45)
	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sucursal")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sucursal")
	public Set<Inventario> getInventarios() {
		return this.inventarios;
	}

	public void setInventarios(Set<Inventario> inventarios) {
		this.inventarios = inventarios;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sucursal")
	public Set<Inventario> getInventarios_1() {
		return this.inventarios_1;
	}

	public void setInventarios_1(Set<Inventario> inventarios_1) {
		this.inventarios_1 = inventarios_1;
	}

}