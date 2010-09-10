package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.image.BufferedImage;

import ar.edu.uade.tesis_grupo13.config.Config;
import ar.edu.uade.tesis_grupo13.grafos.Mapa;
import ar.edu.uade.tesis_grupo13.modelo.MapMaker;

public abstract class ImagenRenderizable implements MapaComponent {
	
	public static int width;
	public static int height;
	public BufferedImage buffer;
	public static Mapa map;
	public static String changeType;
	public Config config;
	
	public ImagenRenderizable() {
		config = MapMaker.getInstance().getConfig();
	}	

	public int getWidth() {
		return width;
	}
		
	public int getHeight() {
		return height;
	}	
				
	public void repaint() {
		ImagenRenderizable.map = config.getModelo().getGrafo().getMapa();
		render();
	}
	
	public BufferedImage getFromBuffer() {			
		return buffer;
	}		
	
}
