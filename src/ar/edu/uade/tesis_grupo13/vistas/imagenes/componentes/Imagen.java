package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.image.BufferedImage;

public class Imagen extends ImagenRenderizable {
	
	private BufferedImage imagen;
	private static Imagen instance;	

	public Imagen(int w, int h, BufferedImage img) {
		super(w, h);
		imagen = img;
		buffer = imagen;
	}
	
	public void generar() {		
	}

	public static Imagen getInstance(BufferedImage imagen) {
		if (instance == null) {
			instance = new Imagen(imagen.getWidth(), imagen.getHeight(), imagen);
		}
		return instance;
	}
		

}
