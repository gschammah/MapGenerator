package ar.edu.uade.tesis_grupo13.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ar.edu.uade.tesis_grupo13.vistas.framework.controlador.Controlador;
import ar.edu.uade.tesis_grupo13.vistas.ventanas.VistaMainMenu;

public class Controller_MainMenu extends Controlador{
	
	VistaMainMenu vista;
	
	public Controller_MainMenu(VistaMainMenu vista) {
		super(vista);
		this.vista = vista;
	}
	
	public void salir(){
		vista.salir();
	}

	public void cargarImagen(String file) {
		try {
			BufferedImage image = ImageIO.read(new File(file));
			vista.setImage(image);
		} catch (IOException ex) {
			// handle exception...
		}
		
	}

}
