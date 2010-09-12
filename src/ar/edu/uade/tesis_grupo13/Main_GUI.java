package ar.edu.uade.tesis_grupo13;

import ar.edu.uade.tesis_grupo13.controller.Controller_MainMenu;
import ar.edu.uade.tesis_grupo13.modelo.MapMaker;
import ar.edu.uade.tesis_grupo13.vistas.ventanas.VistaMainMenu;

public class Main_GUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MapMaker mapa = MapMaker.getInstance();		
		Controller_MainMenu main = new Controller_MainMenu(mapa, new VistaMainMenu());		
		main.cargarImagen("mapas/autolab.png");

	}

}
