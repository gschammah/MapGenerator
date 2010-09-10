package ar.edu.uade.tesis_grupo13.controller;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import ar.edu.uade.tesis_grupo13.MVCframework.controlador.Controlador;
import ar.edu.uade.tesis_grupo13.config.Config;
import ar.edu.uade.tesis_grupo13.grafos.Coordenada;
import ar.edu.uade.tesis_grupo13.modelo.CoordenadaSoftware;
import ar.edu.uade.tesis_grupo13.modelo.MapMaker;
import ar.edu.uade.tesis_grupo13.tools.ProcesamientoImagenes;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.GeneradorImagenes;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Bordes;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Box;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Grafo;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.MapaGrillado;
import ar.edu.uade.tesis_grupo13.vistas.ventanas.VistaMainMenu;

public class Controller_MainMenu extends Controlador {

	private VistaMainMenu vista;
	private MapMaker modelo;	
	private CoordenadaSoftware currentCoord;
	private GeneradorImagenes generadorImagenes;

	public Controller_MainMenu(MapMaker mapa, VistaMainMenu vista) {
		super(mapa, vista);
		this.vista = vista;
		this.modelo = mapa;
		this.currentCoord = new CoordenadaSoftware(0, 0);		
	}

	public void salir() {
		vista.salir();
	}

	public void toggleGrilla(boolean mostrar) {		
		if (mostrar) {
			vista.addLayer("grid", generadorImagenes.getGrid());
		} else {
			vista.removeLayer("grid");
		}
	}
	
	public void toggleBordes(boolean mostrar) {		
		if (mostrar) {
			vista.addLayer("bordes", generadorImagenes.getBordes());
		} else {
			vista.removeLayer("bordes");
		}
	}

	public void cargarImagen(String file) {		
		try {
			BufferedImage imagen = ImageIO.read(new File(file));			
			modelo.setImagen(ProcesamientoImagenes.jpg2Imagen(imagen));
			generadorImagenes = new GeneradorImagenes(imagen, modelo.getGrafo().getMapa());									
			
			vista.clearLayers();
			vista.addLayer("mapaGrillado", generadorImagenes.getMapaGrillado());
			
		} catch (IOException e) {			
			System.err.println(e.getMessage());
		}					
	}	
	
	public void toggleOriginal(boolean mostrar) {
		if (mostrar) {
			vista.removeLayer("mapaGrafo");
			vista.addLayer("base", generadorImagenes.getImagen());
		} else {
			vista.removeLayer("base");
			vista.addLayer("mapaGrafo", generadorImagenes.getMapaGrillado());
		}
	}

	public void toggleGrafo(boolean mostrar) {		
		if (mostrar) {
			vista.addLayer("grafo", generadorImagenes.getGrafo());
		} else {
			vista.removeLayer("grafo");		
		}			
	}
	
	public void togglePath(boolean mostrar) {	
		if (mostrar && generadorImagenes.getPath() != null) {
			vista.addLayer("path", generadorImagenes.getPath());
		} else {
			vista.removeLayer("path");		
		}				
	}
	

	public CoordenadaSoftware getGridCoord(int x, int y) throws NullPointerException {										
		currentCoord.setX(x);
		currentCoord.setY(y);				
		return currentCoord;
	}

	public void setStartPoint(int x, int y) {
		CoordenadaSoftware coord = new CoordenadaSoftware(x, y);
		modelo.getGrafo().setStartPoint(coord);
		vista.removeLayer("path");
		vista.addLayer("startPoint", Box.getInstance(modelo.getImagen().getWidth(),
												 modelo.getImagen().getHeight(),
												 coord, Color.GREEN));		
	}

	public void setEndPoint(int x, int y) {		
		CoordenadaSoftware coord = new CoordenadaSoftware(x, y);
		modelo.getGrafo().setEndPoint(coord);
		vista.removeLayer("path");
		vista.addLayer("endPoint", Box.getInstance(modelo.getImagen().getWidth(),
											   modelo.getImagen().getHeight(),
											   coord, Color.RED));
	}

	public void calcularRuta() {
		try {
			ArrayList<Coordenada> camino = modelo.getGrafo().calcularCamino();		
			vista.addLayer("path", generadorImagenes.getPath(camino));
						
		} catch (NullPointerException e) {
			vista.showErrorPopup("Seleccione primero un punto de inicio y uno de destino");
		}
	}

	public void showInfo(int x, int y) {
		CoordenadaSoftware coord = new CoordenadaSoftware(x, y);
		vista.setInfoText(coord.toString());
	}

	public void setGridSize(int size) {		
		Config.setGridSize(size);		
		modelo.regenerarMatrizParedes();
		generadorImagenes.setMap(modelo.getGrafo().getMapa());
		((MapaGrillado)generadorImagenes.getMapaGrillado()).setMap(modelo.getGrafo().getMapa());
		((Bordes)generadorImagenes.getBordes()).setMap(modelo.getGrafo().getMapa());
		((Grafo)generadorImagenes.getGrafo()).setMap(modelo.getGrafo().getMapa());
		if (vista.hasLayer("path")) {
			calcularRuta();
		}
		generadorImagenes.clearBuffer();		
		vista.clearBuffer();
	}
				
}
