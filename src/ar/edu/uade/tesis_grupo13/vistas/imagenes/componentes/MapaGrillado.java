package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ar.edu.uade.tesis_grupo13.grafos.Mapa;

public class MapaGrillado {
	
	public static BufferedImage generar(int w, int h, Mapa map) {
		
		BufferedImage imagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imagen.createGraphics();

		for (int y = 0; y < map.getMatrizParedes().length; y++) {
			for (int x = 0; x < map.getMatrizParedes()[0].length; x++) {
				// Me fijo si no soy parte de una pared
				if (map.getMatrizParedes()[y][x]) {
					g.setColor(Color.BLACK);
				} else {
					g.setColor(Color.WHITE);
				}
				g.fillRect((x * 10), (y * 10), 10, 10);
			}
		}

		return imagen;
	}

}
