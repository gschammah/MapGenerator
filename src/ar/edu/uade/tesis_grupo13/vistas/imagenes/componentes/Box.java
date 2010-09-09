package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Box {

	public static BufferedImage generar(int w, int h, int x, int y, Color color) {

		BufferedImage imagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imagen.createGraphics();
		
		g.setColor(color);
		
		g.fillRect((x * 10), (y * 10), 10, 10);		

		return imagen;
	}

}
