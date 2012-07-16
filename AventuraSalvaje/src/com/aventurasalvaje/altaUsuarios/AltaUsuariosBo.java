package com.aventurasalvaje.altaUsuarios;

import java.util.List;

import com.aventurasalvaje.dao.SucursalDAO;
import com.aventurasalvaje.dao.UsuarioDAO;
import com.aventurasalvaje.pojos.Usuario;

public class AltaUsuariosBo {
	public UsuarioDAO usuarioDao;
		
	public AltaUsuariosBo() {
		usuarioDao=new UsuarioDAO();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioDao.findAll();
	}

	public void dellete(Usuario usuario) {
		
		usuarioDao.dellete(usuarioDao.findByid(usuario.getIdUsuario()));
		
	} 
	
	public void save(String nombre,String password,Integer idsucursal){
		SucursalDAO sucursaldao = new SucursalDAO();
		
		Usuario usuario = new Usuario();
		usuario.setUsuario(nombre);
		usuario.setPassword(password);
		usuario.setSucursal(sucursaldao.findById(idsucursal));
		usuario.setIdPerfil(0);
		usuarioDao.save(usuario);
	}
	
	
	
}
