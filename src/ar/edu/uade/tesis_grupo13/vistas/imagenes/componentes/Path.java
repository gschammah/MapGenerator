package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import ar.edu.uade.tesis_grupo13.grafos.Coordenada;

public class Path {

	public static BufferedImage generar(int w, int h, ArrayList<Coordenada> camino) {				
		
		BufferedImage imagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imagen.createGraphics();
		
		g.setColor(Color.GREEN);
		g.setStroke(new BasicStroke(2));
		
		for (int i = 0; i < camino.size()-1; i++) {
			g.drawLine((camino.get(i).getMatrizX() * 10) + 4, (camino.get(i).getMatrizY() * 10) + 4, 
					   (camino.get(i+1).getMatrizX() * 10) + 4, (camino.get(i+1).getMatrizY() * 10) + 4);
		}
		
		return imagen;
	}

	
}
