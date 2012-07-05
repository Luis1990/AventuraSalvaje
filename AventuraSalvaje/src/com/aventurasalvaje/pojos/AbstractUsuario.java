package com.aventurasalvaje.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractUsuario entity provides the base persistence definition of the
 * Usuario entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUsuario implements java.io.Serializable {

	// Fields

	private Integer idUsuario;
	private Sucursal sucursal;
	private String usuario;
	private String password;
	private Integer idPerfil;
	private Set cobroses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractUsuario() {
	}

	/** minimal constructor */
	public AbstractUsuario(Sucursal sucursal, String usuario, String password,
			Integer idPerfil) {
		this.sucursal = sucursal;
		this.usuario = usuario;
		this.password = password;
		this.idPerfil = idPerfil;
	}

	/** full constructor */
	public AbstractUsuario(Sucursal sucursal, String usuario, String password,
			Integer idPerfil, Set cobroses) {
		this.sucursal = sucursal;
		this.usuario = usuario;
		this.password = password;
		this.idPerfil = idPerfil;
		this.cobroses = cobroses;
	}

	// Property accessors

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Set getCobroses() {
		return this.cobroses;
	}

	public void setCobroses(Set cobroses) {
		this.cobroses = cobroses;
	}

}