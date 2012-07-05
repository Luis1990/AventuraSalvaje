package com.aventurasalvaje.pojos;

import java.util.Set;

/**
 * ProductoExistencia entity. @author MyEclipse Persistence Tools
 */
public class ProductoExistencia extends AbstractProductoExistencia implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public ProductoExistencia() {
	}

	/** minimal constructor */
	public ProductoExistencia(Catalogo catalogo, String descripcionGral) {
		super(catalogo, descripcionGral);
	}

	/** full constructor */
	public ProductoExistencia(Catalogo catalogo, String descripcionGral,
			Set rentas, Set inventarios) {
		super(catalogo, descripcionGral, rentas, inventarios);
	}

}
