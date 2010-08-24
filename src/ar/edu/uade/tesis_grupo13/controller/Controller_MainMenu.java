package ar.edu.uade.tesis_grupo13.controller;

import java.awt.image.BufferedImage;

import ar.edu.uade.tesis_grupo13.modelo.MapMaker;
import ar.edu.uade.tesis_grupo13.vistas.framework.controlador.Controlador;
import ar.edu.uade.tesis_grupo13.vistas.ventanas.VistaMainMenu;

public class Controller_MainMenu extends Controlador{
	
	private VistaMainMenu vista;
	private MapMaker modelo;	
	private BufferedImage grilla;
	private BufferedImage mapaGrafo;
	
	public Controller_MainMenu(MapMaker mapa, VistaMainMenu vista) {
		super(mapa, vista);
		this.vista = vista;
		this.modelo = mapa;
	}
	
	public void salir(){
		vista.salir();
	}
	
	public void toggleGrilla(boolean muestraGrilla){		
		if (grilla == null) {
			grilla = modelo.generarGrilla();			
		}
		vista.setGrilla(grilla, muestraGrilla);
	}

	public void cargarImagen(String file) {		
		modelo.loadImage(file);
		mapaGrafo = modelo.generarMapaGrafo();
		vista.addLayer("mapaGrafo", mapaGrafo);
	}

	public void toggleOriginal(boolean mostrar) {
		if (mostrar) {
			vista.removeLayer("mapaGrafo");
			vista.addLayer("base", modelo.getImagen());			
		} else {
			vista.removeLayer("base");
			vista.addLayer("mapaGrafo", mapaGrafo);
		}
	}	

}
