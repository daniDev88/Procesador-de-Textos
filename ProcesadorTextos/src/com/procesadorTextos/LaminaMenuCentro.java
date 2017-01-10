package com.procesadorTextos;

import java.awt.FlowLayout;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class LaminaMenuCentro extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JMenu alineacion;
	
	public LaminaMenuCentro(){
	
	setLayout(new FlowLayout());
	
	//a�adimos la lamina del menu de la derecha
	LaminaMenuDerecha derecha = new LaminaMenuDerecha();
	
	alineacion = new JMenu("Alineaci�n");
	
	try {
		
		configurarAlineacion(StyleConstants.ALIGN_LEFT);
		configurarAlineacion(StyleConstants.ALIGN_CENTER);
		configurarAlineacion(StyleConstants.ALIGN_RIGHT);
		
	} catch (MalformedURLException e) {
		
		e.printStackTrace();
	}

	JMenuBar menu = new JMenuBar();
	menu.add(alineacion);
	
	add(menu);
	add(derecha);
	
	}
	
	/*metodo que a�ade los item de alineacion 
	 * arg alin, constante de la clase StyleConstants de tipo entero
	 * utilizamos la clase StyledEditorKit.AlignmentAction que nos permite cambiar la alineacion
	 * lanza una excepcion al a�adir los iconos esde una URL*/
	public void configurarAlineacion(int alin) throws MalformedURLException{
		
		JMenuItem subMenu = new JMenuItem();
		
		alineacion.add(subMenu);
		
		if(alin==StyleConstants.ALIGN_LEFT){
			
			//a�adimos los iconos desde una URL
			subMenu.setIcon(new ImageIcon(new URL("http://apptelo.es/iconos/alineacion-izquierda.png")));
			
			subMenu.addActionListener(new StyledEditorKit.AlignmentAction("izq", alin));
			
		}else if(alin==StyleConstants.ALIGN_RIGHT){
			
			subMenu.setIcon(new ImageIcon(new URL("http://apptelo.es/iconos/texto-alineado-hacia-la-derecha.png")));
			
			subMenu.addActionListener(new StyledEditorKit.AlignmentAction("izq", alin));

			
		}else if(alin==StyleConstants.ALIGN_CENTER){
			
			subMenu.setIcon(new ImageIcon(new URL("http://apptelo.es/iconos/menu-de-lineas.png")));
			
			subMenu.addActionListener(new StyledEditorKit.AlignmentAction("izq", alin));

		}
	}
	

}
