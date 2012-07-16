/**
 * 
 */
package com.aventurasalvaje.productolista;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Window;

import com.aventurasalvaje.pojos.Catalogo;

/**
 * @author Lilita
 *
 */
public class NuevowindowCtrl extends GenericForwardComposer {

	private Window nuevowindow;
	private Button Alta;
	private Button cancelar;
	private Combobox producto_nom;
	private ListaBo listabo;

	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		listabo =new ListaBo();
		List<Catalogo> catalogo=listabo.getCatalogo();
		for (Catalogo cat : catalogo) {
			Comboitem combo= new Comboitem();
			combo.setValue(cat);
			combo.setLabel(cat.getNombreProducto());
			combo.setParent(producto_nom);
		}


	}
	public void onClick$cancelar(){
		nuevowindow.detach();
	}
	public void onClick$aceptar(){
		
	}
}
