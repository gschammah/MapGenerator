package ar.edu.uade.tesis_grupo13;

import ar.edu.uade.tesis_grupo13.controller.Controller_MainMenu;
import ar.edu.uade.tesis_grupo13.vistas.ventanas.VistaMainMenu;

public class Main_GUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Controller_MainMenu main = new Controller_MainMenu(new VistaMainMenu());		
		main.cargarImagen("/home/gabriel/Documentos/tesis/examples/SpaceWandererExample/bitmaps/autolab.png");

	}

}
