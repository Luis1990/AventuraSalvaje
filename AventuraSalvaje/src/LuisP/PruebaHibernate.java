package LuisP;

import java.util.List;

import com.aventurasalvaje.pojos.Usuario;
import com.aventurasalvaje.pojos.UsuarioDAO;

public class PruebaHibernate {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UsuarioDAO dao= new UsuarioDAO();
		List<Usuario> ltUsuarios=dao.findAll();
		for (Usuario usuario : ltUsuarios) {
			System.out.println(usuario.getUsuario());
		}

	}

}
