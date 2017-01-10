package com.procesadorTextos;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;


public class LaminaProcesador extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JTextPane area; //area de texto
	
	public LaminaProcesador(){
	
		setLayout(new BorderLayout());
		
		LaminaMenuIzq menu = new LaminaMenuIzq();
		
		add(menu,BorderLayout.NORTH);
		
		area = new JTextPane();
		
		add(area,BorderLayout.CENTER);
	
	}
	
	
}


