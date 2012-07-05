package com.aventurasalvaje.pojos;

import java.util.Set;

/**
 * Sucursal entity. @author MyEclipse Persistence Tools
 */
public class Sucursal extends AbstractSucursal implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Sucursal() {
	}

	/** minimal constructor */
	public Sucursal(String direccion, Long telefono, String contacto) {
		super(direccion, telefono, contacto);
	}

	/** full constructor */
	public Sucursal(String direccion, String nombre, Long telefono,
			String contacto, Set usuarios, Set inventarios, Set inventarios_1) {
		super(direccion, nombre, telefono, contacto, usuarios, inventarios,
				inventarios_1);
	}

}
