package com.aventurasalvaje.pojos;

import java.util.Set;

/**
 * Usuario entity. @author MyEclipse Persistence Tools
 */
public class Usuario extends AbstractUsuario implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Usuario() {
	}

	/** minimal constructor */
	public Usuario(Sucursal sucursal, String usuario, String password,
			Integer idPerfil) {
		super(sucursal, usuario, password, idPerfil);
	}

	/** full constructor */
	public Usuario(Sucursal sucursal, String usuario, String password,
			Integer idPerfil, Set cobroses) {
		super(sucursal, usuario, password, idPerfil, cobroses);
	}

}
