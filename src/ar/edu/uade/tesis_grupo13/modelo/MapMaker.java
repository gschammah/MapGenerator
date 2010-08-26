package ar.edu.uade.tesis_grupo13.modelo;

import java.awt.Color;

import ar.edu.uade.tesis_grupo13.modelo.grafo.Grafo;
import ar.edu.uade.tesis_grupo13.vistas.framework.modelo.Modelo;

public class MapMaker extends Modelo{
	
	private Imagen imagen;
	private boolean[][] matrizParedes;
	private Grafo grafo;
	
	public MapMaker() {}

	public Grafo getGrafo() {
		return grafo;
	}	
	
	private void generarMatrizParedes() {
		
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
	
	public boolean isBorder(int x, int y) {			
		
		if (x >= matrizParedes[0].length || y >= matrizParedes.length) {
			return false;
		}
		
		if (matrizParedes[y][x]) {
			return false;
		}		 
		
		int startx = x-1;
		int endx = x+1;
		int starty = y-1;
		int endy = y+1;
		
		if (startx < 0) {startx = 0;}
		if (starty < 0) {starty = 0;}
		if (endx == matrizParedes[0].length) {endx = x;}
		if (endy == matrizParedes.length) {endy = y;}					
		
		for (int j = starty; j <= endy; j++) {
			for (int i = startx; i <= endx; i++) {				
				if (matrizParedes[j][i]) {
					return true;
				}
			}
		}		
		
		return false;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
		this.generarMatrizParedes();
		this.grafo = new Grafo(this);
	}	
	
	public boolean[][] getMatrizParedes() {
		return matrizParedes;
	}

	
}
