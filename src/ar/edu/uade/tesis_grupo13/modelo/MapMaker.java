package ar.edu.uade.tesis_grupo13.modelo;

import java.awt.Color;

import ar.edu.uade.tesis_grupo13.MVCframework.modelo.Modelo;
import ar.edu.uade.tesis_grupo13.config.Config;
import ar.edu.uade.tesis_grupo13.grafos.Grafo;

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
		
		matrizParedes = new boolean[(int)Math.ceil(h/Config.gridSize)+1][(int)Math.ceil(w/Config.gridSize)+1];		 				

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				
				int pixel = imagen.getRgbMatrix()[j][i];
								
				if (!matrizParedes[(int)Math.floor(i/Config.gridSize)][(int)Math.floor(j/Config.gridSize)] && pixel == Color.BLACK.getRGB()) {
					matrizParedes[(int)Math.floor(i/Config.gridSize)][(int)Math.floor(j/Config.gridSize)] = true;
				}
				
			}
		}			
	}
	
	public boolean[][] getMatrizParedes() {
		return matrizParedes;
	}

	public Imagen getImagen() {
		return imagen;
	}
	
	public void regenerarMatrizParedes() {
		this.generarMatrizParedes();		
		Grafo nuevoGrafo = new Grafo(matrizParedes);
		if (grafo != null) {
			nuevoGrafo.setStartPoint(grafo.getStartPoint());
			nuevoGrafo.setEndPoint(grafo.getEndPoint());
		}
		grafo = nuevoGrafo;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
		regenerarMatrizParedes();
	}	
	

	
}
