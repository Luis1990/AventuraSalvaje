package com.aventurasalvaje.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractSucursal entity provides the base persistence definition of the
 * Sucursal entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSucursal implements java.io.Serializable {

	// Fields

	private Integer idSucursal;
	private String direccion;
	private String nombre;
	private Long telefono;
	private String contacto;
	private Set usuarios = new HashSet(0);
	private Set inventarios = new HashSet(0);
	private Set inventarios_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSucursal() {
	}

	/** minimal constructor */
	public AbstractSucursal(String direccion, Long telefono, String contacto) {
		this.direccion = direccion;
		this.telefono = telefono;
		this.contacto = contacto;
	}

	/** full constructor */
	public AbstractSucursal(String direccion, String nombre, Long telefono,
			String contacto, Set usuarios, Set inventarios, Set inventarios_1) {
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
		this.contacto = contacto;
		this.usuarios = usuarios;
		this.inventarios = inventarios;
		this.inventarios_1 = inventarios_1;
	}

	// Property accessors

	public Integer getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public Set getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set usuarios) {
		this.usuarios = usuarios;
	}

	public Set getInventarios() {
		return this.inventarios;
	}

	public void setInventarios(Set inventarios) {
		this.inventarios = inventarios;
	}

	public Set getInventarios_1() {
		return this.inventarios_1;
	}

	public void setInventarios_1(Set inventarios_1) {
		this.inventarios_1 = inventarios_1;
	}

}