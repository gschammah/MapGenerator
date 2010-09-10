package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Grilla extends ImagenRenderizable {
	
	private static Grilla instance;	
		
	public Grilla(){
		super();
		render();
	}
	
	public static Grilla getInstance() {
		if (instance == null) {
			instance = new Grilla();
		}
		return instance;
	}

	public void render() {					
	        
	        BufferedImage imagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = imagen.createGraphics();
			g.setColor(Color.RED);
	               
	        for (int x=0; x<width; x += config.gridSize) {g.drawLine(x, 0, x, height);}
	        for (int y=0; y<height; y += config.gridSize) {g.drawLine(0, y, width, y);}
			
	        buffer = imagen;	        			
	}		
	
}
