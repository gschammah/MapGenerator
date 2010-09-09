package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Grilla {

	public static BufferedImage generar(int w, int h) {			
	        
	        BufferedImage imagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = imagen.createGraphics();
			g.setColor(Color.RED);
	               
	        for (int x=0; x<w; x+=10) {g.drawLine(x, 0, x, h);}
	        for (int y=0; y<h; y+=10) {g.drawLine(0, y, w, y);}
			
			return imagen;
		}
		
	}
