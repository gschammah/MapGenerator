package ar.edu.uade.tesis_grupo13.modelo;

import java.awt.Color;

import ar.edu.uade.tesis_grupo13.vistas.framework.modelo.Modelo;

public class MapMaker extends Modelo{
	
	private Imagen imagen;
	private boolean[][] matrizParedes;

	public boolean[][] getMatrizParedes() {
		return matrizParedes;
	}

	public MapMaker() {		
	}		
	
	public void generarMatriz() {
		
		int w = imagen.getWidth();
		int h = imagen.getHeight();
		
		matrizParedes = new boolean[(int)Math.ceil(h/10)+1][(int)Math.ceil(w/10)+1];		 				

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				
				int pixel = imagen.getRgbMatrix()[j][i];
								
				if (!matrizParedes[(int)Math.floor(i/10)][(int)Math.floor(j/10)] && pixel == Color.BLACK.getRGB()) {
					matrizParedes[(int)Math.floor(i/10)][(int)Math.floor(j/10)] = true;
				}
				
			}
		}			
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}		

	
}
