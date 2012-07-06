/**
 * 
 */
package com.aventurasalvaje.login;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;

import com.aventurasalvaje.pojos.Usuario;

/**
 * @author LuisPp Alien
 *Mucha azucar en mi cuerpo !!! haaaaaaaaaa!!!! 
 */
public class LoginCtrl extends GenericForwardComposer {

	/** Componente Textbox de la zul nombrado con el id de la zul*/
	private Textbox contrasena;
	/** Componente Textbooks de la zul nombrado con el id de la zul*/
	private Textbox usuario;
	/** Componente Button de la zul nombrado con el id de la zul*/
	private Button logear;
	/** 
	 * Objeto Tipo LoginBo con el que se va a acceder a la logica del negocio
	 * Es Declarado Global(que sera usado en toda la clase) 
	 */
	private LoginBo loginBo;
	
	
	/**
	 * Componente Listbox Donde se hara una carga de usuario Como ejemplo!!
	 * Se declara con el mismo id del componente dentro del zul
	 */
	private Listbox listaUsuario;
	
	/**
	 *Metodo que se corre durante la creacion de la zul 
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		//Aqui se inicializa el LoginBo para que sea utilizado mas adelante 
		//Se esta mandando llamar el contructor dentro de la misma clase
		loginBo=new LoginBo();
		
		//Aqui se hace la carga inicial durante la creacion del mismo zul
		//estupido azucar no me deja dormir
		//mmmmmm me pondre a hacer ejercicio :D
		//regrese
		//se manda a llamar un metodo dentro del bo instanciado que devuelva todos los usuarios
		// °|-------|° lo que esta abajo es el tipo de objeto que contiene nuestra lista
		List<Usuario> usuarios=loginBo.getUsuarios();
		
		// aqui se setea el contenido que llevara nuestra lista de objetos en este caso Objetos tipo Usuario
		// les explicare mas adelante como funciona el model es interesante
		// y no tengo tantas lineas aqui jejejeje
		ListModelList model=new ListModelList(usuarios);
		
		//se setea el modelo creado antes dentro del listbox
		listaUsuario.setModel(model);
		//se hace el rendero(recorrido de la lista de objetos introducida[model])
		listaUsuario.setItemRenderer(new ListitemRenderer() {
			// este metodo se ejecutara por cada uno de los objetos de la lista seteada dentro del model
			@Override
			public void render(Listitem item, Object data, int arg2)
					throws Exception {
					//se hace unca convercion del objeto data(contiene cada uno de los objetos de la lista[del model]y es el objeto iterado
					Usuario usuario=(Usuario) data;
					//se setea el valor de el item(cada objeto dentro del listBox)
					//se usa el metodo set igual q en la mayoria de los objetos pertenecientes a zk
					item.setValue(usuario);
					
					//se crean celdas donde se setearan los labels con los datos a mostrar
					Listcell cell0=new Listcell();
					Listcell cell1=new Listcell();
					Listcell cell2=new Listcell();
					
					//se crea un label al que se le setea el contenido que se desea mostrar
					//usando el objeto usuario que se recupero
					// y se le setea el padre al que pertenecen 
					new Label(usuario.getIdUsuario().toString()).setParent(cell0);// este dato se recupera Como Integer pero se combierte a String con el .toString()
					new Label(usuario.getUsuario()).setParent(cell1);
					new Label(usuario.getPassword()).setParent(cell2);
					
					//se setea los padres de cada celda
					cell0.setParent(item);
					cell1.setParent(item);
					cell2.setParent(item);
			}
			
			});
		

	}
	
	/**
	 * Metodo onClick del boton logear que esta dentro de la zul
	 * El metodo es llamado onClick$[id del Boton]
	 */
	public void onClick$logear(){
		
		//Aqui estoy recuperando el textbox de usuario de la zul 
		//y con el .getValue() estoy recuperando el valor que le ingresaron
		String nombreUsuario=usuario.getValue();
		//Se recupera la contraseña de la misma manera que el nombre del usuario
		String pass=contrasena.getValue();
		//Aqui se manda llamar un metodo del LoginBo
		//Solo puedes llamar los metodos que han sido declarados como publicos asi como variables
		//Lo que regresa el metodo se guarda dentro de una variable local del metodo(solo se ocupa y exite durante la ejecucion del metodo)
		Boolean usuarioExiste=loginBo.usurioExiste(nombreUsuario);
		
		if (usuarioExiste) {
		//si la variables es true entra aqui y se alerta de la exitencia del usuario
			alert("Usuario Existe");
		} else {
			//si la variables es true entra aqui y se alerta de la no exitencia del usuario :D
			alert("Usuario No Existe");
			//esto es inegable :D
			// lo meteria en un "for" pero no acabaria y se acabaria la memoria XD 
			alert("y Chucho es gay");
			
			//Si el usuario no existe seteo el textbox en vacio otra vez
			//esto se hace con un set 
			usuario.setValue("");
		}
		
	}
	
}
