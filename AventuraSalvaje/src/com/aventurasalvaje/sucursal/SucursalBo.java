package com.aventurasalvaje.sucursal;

import com.aventurasalvaje.dao.SucursalDAO;
import com.aventurasalvaje.pojos.Sucursal;

public class SucursalBo {

	private SucursalDAO  sucursaldao;

	public  SucursalBo(){

		sucursaldao = new SucursalDAO();

	}

	public void save(String nombre, String correo, long telefono,
			String direccion, int idusuario) {

		Sucursal sucursal = new Sucursal();
		sucursal.setNombre(nombre);
		sucursal.setContacto(correo);
		sucursal.setTelefono(telefono);
		sucursal.setDireccion(direccion);
		sucursal.setIdSucursal(idusuario);
		sucursaldao.save(sucursal);

	}
}
