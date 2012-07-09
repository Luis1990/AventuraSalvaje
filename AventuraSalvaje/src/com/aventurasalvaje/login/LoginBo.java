package com.aventurasalvaje.login;

import java.util.List;

import com.aventurasalvaje.pojos.Usuario;
import com.aventurasalvaje.dao.UsuarioDAO;


public class LoginBo {
	
	/**
	 * Instancia de la Clase de UsuarioDAO por la cual se tiene acceso a la Base de Datos
	 * Se declara Global Para ser usada a lo largo de su instancia 
	 */
	public UsuarioDAO usuarioDao;

	
	/**
	 * Constructor Principal de la clase
	 * el contructor se ejecuta al instanciar la clase
	 */
	public LoginBo() {
		//se inicializa la clase UsuarioDAO para su uso a lo largo de su instancia
		usuarioDao=new UsuarioDAO();
	}
	/**
	 * @param nombreUsuario
	 * @return Boleano para saber si el usuario existe
	 * Este metodo regresa un booleano dependiendo del contenido de la base de datos
	 * 
	 */
	public boolean usurioExiste(String nombreUsuario){
//		//Se hace el llamado de un metodo que existe dentro del UsuarioDAO
//		//Regresa un objeto del tipo Pojo de Usuario 
//		Usuario usuario=usuarioDao.findByUsuario(nombreUsuario);
//		//Se revisa que el usuario no este nulo
//		if(usuario==null){
//			// si es nulo ser retorna un falso
//			return false;
//		}else{
//			// si no es nulo se retorna un verdadero
//			return true;
//		}
		return false;
	}
	/**
	 * Metodo que regresa todos los usuarios existentes en la base de datos
	 */
	public List<Usuario> getUsuarios() {
		//Solo uso el metodo del Dao que regresa ya todos los usuarios y asi como se recuperan se mandan al Controller
		return usuarioDao.findAll();
	} 
}
