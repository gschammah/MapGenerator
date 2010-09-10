package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.image.BufferedImage;

public abstract class ImagenRenderizable implements MapaComponent {
	
	public int width;
	public int height;
	public BufferedImage buffer;
	
	public ImagenRenderizable(int w, int h) {
		width = w;
		height = h;
	}	

	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
				
	public void regenerar() {
		generar();
	}
	
	public BufferedImage getFromBuffer() {			
		return buffer;
	}
		
	
}
