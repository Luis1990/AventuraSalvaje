package com.aventurasalvaje.pojos;

/**
 * Inventario entity. @author MyEclipse Persistence Tools
 */
public class Inventario extends AbstractInventario implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Inventario() {
	}

	/** full constructor */
	public Inventario(Sucursal sucursal, ProductoExistencia productoExistencia) {
		super(sucursal, productoExistencia);
	}

}
