package com.procesadorTextos;

import javax.swing.JFrame;

public class FramePrincipal extends JFrame{
	

	private static final long serialVersionUID = 1L;

	public FramePrincipal(){
	
	setBounds(500,300,550,400);
	
	LaminaProcesador lamina =new LaminaProcesador();
	
	add(lamina);
	
	setVisible(true);
	
	}
}
