package com.aventurasalvaje.pojos;

import java.sql.Time;

/**
 * Renta entity. @author MyEclipse Persistence Tools
 */
public class Renta extends AbstractRenta implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Renta() {
	}

	/** full constructor */
	public Renta(ProductoExistencia productoExistencia, Time horaEntrada,
			Time horaSalida) {
		super(productoExistencia, horaEntrada, horaSalida);
	}

}
