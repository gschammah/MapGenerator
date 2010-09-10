package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.image.BufferedImage;

public interface MapaComponent {	
			
	public void generar();
	public void regenerar();
	public BufferedImage getFromBuffer();
	public int getWidth();
	public int getHeight();
	
}
