package com.aventurasalvaje.pojos;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usuario", catalog = "aventurasalvaje")
public class Usuario implements java.io.Serializable {

	// Fields

	private Integer idUsuario;
	private Sucursal sucursal;
	private String usuario;
	private String password;
	private Integer idPerfil;
	private Set<Cobros> cobroses = new HashSet<Cobros>(0);

	// Constructors

	/** default constructor */
	public Usuario() {
	}

	/** minimal constructor */
	public Usuario(Sucursal sucursal, String usuario, String password,
			Integer idPerfil) {
		this.sucursal = sucursal;
		this.usuario = usuario;
		this.password = password;
		this.idPerfil = idPerfil;
	}

	/** full constructor */
	public Usuario(Sucursal sucursal, String usuario, String password,
			Integer idPerfil, Set<Cobros> cobroses) {
		this.sucursal = sucursal;
		this.usuario = usuario;
		this.password = password;
		this.idPerfil = idPerfil;
		this.cobroses = cobroses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUsuario", unique = true, nullable = false)
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSucursal", nullable = false)
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@Column(name = "usuario", nullable = false, length = 10)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "idPerfil", nullable = false)
	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Cobros> getCobroses() {
		return this.cobroses;
	}

	public void setCobroses(Set<Cobros> cobroses) {
		this.cobroses = cobroses;
	}

}