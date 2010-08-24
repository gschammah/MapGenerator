package ar.edu.uade.tesis_grupo13.vistas.ventanas;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import ar.edu.uade.tesis_grupo13.vistas.framework.vista.Vista;
import ar.edu.uade.tesis_grupo13.vistas.ventanas.gui.GUI_MainMenu;

public class VistaMainMenu extends Vista {

	private GUI_MainMenu vistaGrafica;	

	public VistaMainMenu() {

		vistaGrafica = new GUI_MainMenu(this);
		vistaGrafica.setSize(800, 600);
		this.centrarVista(vistaGrafica);		
		vistaGrafica.setVisible(true);
	}
	
	public void setImage(BufferedImage img) {
		vistaGrafica.addLayer("base", img);
	}		

	public void salir() {		
		vistaGrafica.dispose();
	}

	public void setGrilla(BufferedImage grilla, boolean muestraGrilla) {
		if (muestraGrilla) {
			addLayer("grid", grilla);
		} else {
			removeLayer("grid");
		}
	}

	public void removeLayer(String layer) {
		vistaGrafica.removeLayer(layer);	
	}
	
	public void addLayer(String layer, BufferedImage img) {
		vistaGrafica.addLayer(layer, img);	
	}

}
