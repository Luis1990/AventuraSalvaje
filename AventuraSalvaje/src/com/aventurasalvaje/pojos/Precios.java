package com.aventurasalvaje.pojos;

import java.util.Set;

/**
 * Precios entity. @author MyEclipse Persistence Tools
 */
public class Precios extends AbstractPrecios implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Precios() {
	}

	/** full constructor */
	public Precios(Integer idSucursal, Long costoTotal, Long costoExtra,
			Set cobroses) {
		super(idSucursal, costoTotal, costoExtra, cobroses);
	}

}
