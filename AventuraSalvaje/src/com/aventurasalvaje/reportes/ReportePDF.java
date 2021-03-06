/**
 * 
 */
package com.aventurasalvaje.reportes;

import java.math.BigDecimal;
import java.util.Date;

import com.aventurasalvaje.pojos.Catalogo;
import com.aventurasalvaje.reportes.ReporteMensualCtrl;

/**
 * @author carlos
 *
 */
public class ReportePDF {
	
	Date inic;
	Date fin;
	String nombrepro;
	BigDecimal calculo;
	long diferencia;
	
	public long getDiferencia() {
		return diferencia;
	}
	public void setDiferencia(long diferencia) {
		this.diferencia = diferencia;
	}
	public BigDecimal getCalculo() {
		return calculo;
	}
	public void setCalculo(BigDecimal calculo) {
		this.calculo = calculo;
	}
	public Date getInic(){
		return inic;
	}
	public void setInic(Date inic) {
		this.inic = inic;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public String getNombrepro() {
		return nombrepro;
	}
	public void setNombrepro(String nombrepro) {
		this.nombrepro = nombrepro;
	}
}