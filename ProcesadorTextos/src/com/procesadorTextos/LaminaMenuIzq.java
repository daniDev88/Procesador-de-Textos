package com.procesadorTextos;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit;

public class LaminaMenuIzq extends JPanel {

	private static final long serialVersionUID = 1L;
	
	//JTextPane area; //area de texto
	
	JMenu fuente,estilo,tamagno;//menus

	public LaminaMenuIzq() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT,10,6));
		
		//añadimos la lamina del menu central
		LaminaMenuCentro centro = new LaminaMenuCentro();
		
		// barra de Menu
				JMenuBar menu = new JMenuBar();
				
				fuente =new JMenu("Fuente");
				estilo =new JMenu("Estilo");
				tamagno =new JMenu("Tamaño");
				
				menu.add(fuente);
				menu.add(estilo);
				menu.add(tamagno);

				
				//--------------------------------------
				//añadimos subelementos
				
				configurarMenu("Arial","fuente","Arial",9,12);
				configurarMenu("Verdana","fuente","Verdana",9,12);
				configurarMenu("Courier","fuente","Courier",9,12);
				
				configurarMenu("Negrita","estilo","",Font.BOLD,12);
				configurarMenu("Cursiva","estilo","",Font.ITALIC,12);
				
				configurarMenu("12","tamaño","",9,12);
				configurarMenu("16","tamaño","",9,16);
				configurarMenu("20","tamaño","",9,20);
				configurarMenu("24","tamaño","",9,24);
				
				add(menu);
				add(centro);

	}
	
	/*metodo encargado de configurar el menu
	 * 1º arg titulo del submenu
	 * 2º arg menu el cual contendra el submenu
	 * 3º arg tipo de letra
	 * 4º arg estilo, constante de clase de tipo entero 
	 * 5º tamaño de fuente
	 * utilizaremos las  clase editorKit y sus distintas clases internas para  modificar el texto que selecionemos */
	
	public void configurarMenu(String rotulo, String menu, String tipoLetra, int est, int tam){
		
		
		JMenuItem subMenu = new JMenuItem(rotulo); 
		
		//determinamos a que menu va
		if(menu == "fuente"){
			
			fuente.add(subMenu);
			
			//modificamos tipo de letra
			if(tipoLetra == "Arial"){
				
				subMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiarLetra","Arial"));
				
			}else if(tipoLetra == "Verdana"){
				
				subMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiarLetra","Verdana"));
				
			}else if(tipoLetra == "Courier"){
				
				subMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiarLetra","Courier"));
				
			};
			
		}else if(menu == "estilo"){
			
			estilo.add(subMenu);
			
			//modificamos el estilo
			if(est==Font.BOLD){
				
				subMenu.addActionListener(new StyledEditorKit.BoldAction());
				
			}else if(est==Font.ITALIC){
				
				subMenu.addActionListener(new StyledEditorKit.ItalicAction());
			};
			
		}else if (menu == "tamaño"){
			
			tamagno.add(subMenu);
			
			//modificamos tamaño
			subMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambioTam",tam) );
		}
		
		/*   ESTO SERIA EN EL MODO MODIFICAR TEXTO COMPLETO
		
		//ponemos a la escucha los subMenus y le pasamos las variables
		//el rotulo sera el menu que hemos pulsado
		subMenu.addActionListener(new gestionaEventos(rotulo, tipoLetra, est, tam));
		
		*/
		
	};
	
	/*   ESTO SERIA EN EL MODO MODIFICAR TEXTO COMPLETO
	
	//clase interna que se encargara de los eventos
	private class gestionaEventos implements ActionListener{
		
		String letra;//tipo de letra
		String menu;//que menu pulsemos
		int stilo;//etilo letra
		int tamano;//tamaño letra
		
		//constructor que recogera las variables del metodo configuramenu
		gestionaEventos(String elemento, String letra, int stilo, int tamano){
			
			this.menu=elemento;
			this.letra=letra;
			this.stilo=stilo;
			this.tamano=tamano;
		};

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//variable donde almacenarems la fuente actual del area de texto
			Font fuente=area.getFont();
			
			//evaluamos que submenu se pulsa solo modificar lo necesario
			if(menu == "Arial" || menu == "Verdana" || menu == "Courier"){
				
				//dejamos el tamaño y el estilo como este en el area
				stilo=fuente.getStyle();
				tamano=fuente.getSize();
				
			}else if(menu == "Negrita" || menu == "Cursiva"){
				
				//comprobamos si ya hay negrita o cursiva para que no cambie el estilo si estan los dos aplicados y cambiamos 
				//de letra o tamaño
				
				if(fuente.getStyle() == 1 || fuente.getStyle() == 2){
					
					stilo=3;//suma de las constantes bold e italic
				};
				
				letra=fuente.getFontName();
				tamano=fuente.getSize();
				
			}else{
				
				letra=fuente.getFontName();
				stilo=fuente.getStyle();
			};
			
			area.setFont(new Font(letra,stilo,tamano));
			
		}
		
		
		
	};
*/

}
