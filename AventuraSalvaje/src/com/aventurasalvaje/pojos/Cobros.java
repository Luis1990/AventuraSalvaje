package com.aventurasalvaje.pojos;

import java.sql.Timestamp;

/**
 * Cobros entity. @author MyEclipse Persistence Tools
 */
public class Cobros extends AbstractCobros implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Cobros() {
	}

	/** full constructor */
	public Cobros(Precios precios, Usuario usuario, Timestamp fecha) {
		super(precios, usuario, fecha);
	}

}
