package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ar.edu.uade.tesis_grupo13.config.Config;

public class Grilla extends ImagenRenderizable {
	
	private static Grilla instance;	
		
	public Grilla(int w, int h){
		super(w, h);
		generar();
	}
	
	public static Grilla getInstance(int w, int h) {
		if (instance == null) {
			instance = new Grilla(w, h);
		}
		return instance;
	}

	public void generar() {					
	        
	        BufferedImage imagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = imagen.createGraphics();
			g.setColor(Color.RED);
	               
	        for (int x=0; x<width; x += Config.gridSize) {g.drawLine(x, 0, x, height);}
	        for (int y=0; y<height; y += Config.gridSize) {g.drawLine(0, y, width, y);}
			
	        buffer = imagen;	        			
	}		
	
}
