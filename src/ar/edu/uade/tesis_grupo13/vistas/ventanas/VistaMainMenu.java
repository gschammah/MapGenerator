package ar.edu.uade.tesis_grupo13.vistas.ventanas;

import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import ar.edu.uade.tesis_grupo13.vistas.framework.vista.Vista;
import ar.edu.uade.tesis_grupo13.vistas.ventanas.gui.GUI_MainMenu;

public class VistaMainMenu extends Vista {

	private GUI_MainMenu vistaGrafica;	

	public VistaMainMenu() {

		vistaGrafica = new GUI_MainMenu(this);
		vistaGrafica.setTitle("AutoDriver");
		vistaGrafica.setSize(1024, 768);
		this.centrarVista(vistaGrafica);		
		vistaGrafica.setVisible(true);
	}
	
	public void setImage(BufferedImage img) {
		vistaGrafica.addLayer("base", img);
	}		

	public void salir() {		
		vistaGrafica.dispose();
	}

	public void removeLayer(String layer) {
		vistaGrafica.removeLayer(layer);	
	}
	
	public void addLayer(String layer, BufferedImage img) {
		vistaGrafica.addLayer(layer, img);	
	}

	public void clearLayers() {
		vistaGrafica.clearLayers();
	}

	public void setInfoText(String txt) {		
		vistaGrafica.setInfoText(txt);
	}

	public void showErrorPopup(String msg) {
		JOptionPane.showMessageDialog(vistaGrafica, msg, "Error", JOptionPane.ERROR_MESSAGE);		
	}	

}
