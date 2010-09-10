package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ar.edu.uade.tesis_grupo13.config.Config;
import ar.edu.uade.tesis_grupo13.grafos.Mapa;

public class Bordes extends ImagenRenderizable {
	
	private Mapa map;
	private static Bordes instance;

	public Bordes(int w, int h, Mapa mapa) {
		super(w, h);
		setMap(mapa);		
	}

	public static Bordes getInstance(int w, int h, Mapa map) {
		if (instance ==  null) {
			instance = new Bordes(w, h, map);			
		}
		return instance;
	}
	
	public void generar() {
		
		BufferedImage imagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imagen.createGraphics();
		
		g.setColor(Color.ORANGE);

		for (int y = 0; y < map.getMatrizParedes().length; y++) {
			for (int x = 0; x < map.getMatrizParedes()[0].length; x++) {
				// Me fijo si no soy parte de una pared
				if (map.isBorder(x, y)) {
					g.fillRect((x * Config.gridSize), (y * Config.gridSize), Config.gridSize, Config.gridSize);
				} 				
			}
		}				
		
		buffer = imagen;	
	}

	public void setMap(Mapa mapa) {
		this.map = mapa;
		generar();
	}		

}
