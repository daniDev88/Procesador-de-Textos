package com.procesadorTextos;

import java.awt.FlowLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.text.DefaultEditorKit;

public class LaminaMenuDerecha extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public LaminaMenuDerecha(){
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JMenu editar = new JMenu("Editar");
		
		JMenuBar menu = new JMenuBar();
		
		JMenuItem copiar = new JMenuItem("Copiar");
		JMenuItem cortar = new JMenuItem("Cortar");
		JMenuItem  pegar = new JMenuItem("Pegar");
		
		//utilizaremos las distintas clases internas de la clase DefaultEditorKit para las distintas acciones
		copiar.addActionListener(new DefaultEditorKit.CopyAction());
		cortar.addActionListener(new DefaultEditorKit.CutAction());
		pegar.addActionListener(new DefaultEditorKit.PasteAction());
		
		//añadimos los submenus
		editar.add(copiar);
		editar.add(cortar);
		editar.add(pegar);

		menu.add(editar);

		add(menu);
	}
	

}
