/**
 * 
 */
package com.aventurasalvaje.reportes;

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