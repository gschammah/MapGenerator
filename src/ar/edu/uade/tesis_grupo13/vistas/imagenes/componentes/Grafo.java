package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ar.edu.uade.tesis_grupo13.config.Config;
import ar.edu.uade.tesis_grupo13.grafos.Coordenada;
import ar.edu.uade.tesis_grupo13.grafos.Mapa;

public class Grafo extends ImagenRenderizable {
	
	private Mapa map;
	private static Grafo instance;	
	
	public Grafo(int w, int h, Mapa mapa) {
		super(w, h);
		map = mapa;	
		generar();
	}
	
	public static Grafo getInstance(int w, int h, Mapa map) {
		if (instance ==  null) {
			instance = new Grafo(w, h, map);			
		}
		return instance;
	}

	public void generar() {
							
			BufferedImage imagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = imagen.createGraphics();
			
			boolean[][] matriz = map.getMatrizParedes();
						
			for (int y = 0; y < matriz.length; y++) {
				for (int x = 0; x < matriz[0].length; x++) {				
					
					//Grafico vertice
					g.setColor(Color.BLUE);
					g.fillRect((x*Config.gridSize) + Config.gridSize / 2, (y*Config.gridSize) + Config.gridSize / 2, 2, 2);								
					
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
						
						g.drawLine((x*Config.gridSize) + Config.gridSize / 2, (y*Config.gridSize) + Config.gridSize / 2, (((x2)*Config.gridSize) + Config.gridSize / 2), ((y2)*Config.gridSize) + Config.gridSize / 2);
					}																			
				}
			}
			
			buffer = imagen;				
		}

	public void setMap(Mapa mapa) {
		this.map = mapa;
	}

}
