package com.aventurasalvaje.pojos;

import java.util.Set;

/**
 * Catalogo entity. @author MyEclipse Persistence Tools
 */
public class Catalogo extends AbstractCatalogo implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Catalogo() {
	}

	/** minimal constructor */
	public Catalogo(String nombreProducto) {
		super(nombreProducto);
	}

	/** full constructor */
	public Catalogo(String nombreProducto, Set productoExistencias) {
		super(nombreProducto, productoExistencias);
	}

}
