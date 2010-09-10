package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ar.edu.uade.tesis_grupo13.config.Config;
import ar.edu.uade.tesis_grupo13.modelo.CoordenadaSoftware;

public class Box extends ImagenRenderizable {
	
	private CoordenadaSoftware coord;
	private Color color;
	private static Box instance;	

	public Box(int w, int h, CoordenadaSoftware coord, Color color) {
		super(w, h);
		this.coord = coord;		
		this.color = color;
		generar();
	}
	
	public static Box getInstance(int w, int h, CoordenadaSoftware coord, Color color) {	
		instance = new Box(w, h, coord, color);		
		return instance;
	}

	public void generar() {
				
		BufferedImage imagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imagen.createGraphics();
		
		g.setColor(color);		
		g.fillRect((coord.getMatrizX() * Config.gridSize), (coord.getMatrizY() * Config.gridSize), Config.gridSize, Config.gridSize);
		
		buffer = imagen;	
	}
		
}
