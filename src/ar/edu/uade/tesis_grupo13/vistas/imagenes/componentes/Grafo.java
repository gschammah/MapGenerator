package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ar.edu.uade.tesis_grupo13.grafos.Coordenada;
import ar.edu.uade.tesis_grupo13.grafos.Mapa;

public class Grafo {
	
	public static BufferedImage generar(int w, int h, Mapa map) {
						
			BufferedImage imagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = imagen.createGraphics();
			
			boolean[][] matriz = map.getMatrizParedes();
						
			for (int y = 0; y < matriz.length; y++) {
				for (int x = 0; x < matriz[0].length; x++) {				
					
					//Grafico vertice
					g.setColor(Color.BLUE);
					g.fillRect((x*10) + 3, (y*10) + 3, 5, 5);								
					
					for (Coordenada coord : map.getGrafo().getVertices(x, y)) {						
						int x2 = coord.getMatrizX();
						int y2 = coord.getMatrizY();
						double weight = map.getGrafo().getEdgeWeight(x, y, x2, y2);
						
						if (weight > 1 && weight < 5) {
							g.setColor(Color.GREEN);
						} else if (weight >= 5 && weight < 7.5) {
							g.setColor(Color.YELLOW);
						} else if (weight >= 7.5){
							g.setColor(Color.RED);
						}
						
						g.drawLine((x*10) + 5, (y*10) + 5, (((x2)*10) + 5), ((y2)*10) + 5);
					}																			
				}
			}
			
			return imagen;
		}

}
