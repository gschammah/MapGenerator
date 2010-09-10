package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ar.edu.uade.tesis_grupo13.config.Config;
import ar.edu.uade.tesis_grupo13.grafos.Mapa;

public class MapaGrillado extends ImagenRenderizable {		

	private Mapa map;
	private static MapaGrillado instance;	
	
	public MapaGrillado(int w, int h, Mapa mapa) {
		super(w, h);
		map = mapa;		
		generar();
	}
	
	public void setMap(Mapa map) {
		this.map = map;		
	}
	
	public static MapaGrillado getInstance(int w, int h, Mapa map) {
		if (instance ==  null) {
			instance = new MapaGrillado(w, h, map);
		}
		return instance;
	}

	public void generar() {
				
		BufferedImage imagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imagen.createGraphics();

		for (int y = 0; y < map.getMatrizParedes().length; y++) {
			for (int x = 0; x < map.getMatrizParedes()[0].length; x++) {
				// Me fijo si no soy parte de una pared
				if (map.getMatrizParedes()[y][x]) {
					g.setColor(Color.BLACK);
				} else {
					g.setColor(Color.WHITE);
				}
				g.fillRect((x * Config.gridSize), (y * Config.gridSize), Config.gridSize, Config.gridSize);
			}
		}
		
		buffer = imagen; 			
	}
	
	
}
