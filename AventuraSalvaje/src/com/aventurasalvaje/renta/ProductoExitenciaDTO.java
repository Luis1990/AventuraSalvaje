package com.aventurasalvaje.renta;

import java.util.HashSet;
import java.util.Set;

import com.aventurasalvaje.pojos.Catalogo;
import com.aventurasalvaje.pojos.Inventario;
import com.aventurasalvaje.pojos.ProductoExistencia;
import com.aventurasalvaje.pojos.Renta;

public class ProductoExitenciaDTO {

	private Integer idProductoExistencia;
	private Catalogo catalogo;
	private String descripcionGral;
	private Set<Renta> rentas = new HashSet<Renta>(0);
	private Set<Inventario> inventarios = new HashSet<Inventario>(0);
	
	public ProductoExitenciaDTO(){
		
	}

	
	public ProductoExitenciaDTO(ProductoExistencia producto) {
		super();
		this.idProductoExistencia = producto.getIdProductoExistencia();
		this.catalogo = producto.getCatalogo();
		this.descripcionGral = producto.getDescripcionGral();
		this.rentas = producto.getRentas();
	}
	
	public Integer getIdProductoExistencia() {
		return idProductoExistencia;
	}
	public void setIdProductoExistencia(Integer idProductoExistencia) {
		this.idProductoExistencia = idProductoExistencia;
	}
	public Catalogo getCatalogo() {
		return catalogo;
	}
	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}
	public String getDescripcionGral() {
		return descripcionGral;
	}
	public void setDescripcionGral(String descripcionGral) {
		this.descripcionGral = descripcionGral;
	}
	public Set<Renta> getRentas() {
		return rentas;
	}
	public void setRentas(Set<Renta> rentas) {
		this.rentas = rentas;
	}
	public Set<Inventario> getInventarios() {
		return inventarios;
	}
	public void setInventarios(Set<Inventario> inventarios) {
		this.inventarios = inventarios;
	}
	
	
}
