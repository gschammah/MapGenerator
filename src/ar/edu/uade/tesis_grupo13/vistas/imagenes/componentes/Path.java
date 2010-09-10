package ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import ar.edu.uade.tesis_grupo13.config.Config;
import ar.edu.uade.tesis_grupo13.grafos.Coordenada;

public class Path extends ImagenRenderizable{
	
	private ArrayList<Coordenada> camino;
	private static Path instance;	

	public Path(int w, int h, ArrayList<Coordenada> path) {
		super(w, h);
		camino = path;
		generar();
	}
	
	public static Path getInstance(int w, int h, ArrayList<Coordenada> path) {		
		instance = new Path(w, h, path);		
		return instance;
	}

	public void generar() {			
		
		BufferedImage imagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imagen.createGraphics();
		
		g.setColor(Color.GREEN);
		g.setStroke(new BasicStroke(2));
		
		for (int i = 0; i < camino.size()-1; i++) {
			g.drawLine((camino.get(i).getMatrizX() * Config.gridSize) + (Config.gridSize)/2, (camino.get(i).getMatrizY() * Config.gridSize) + (Config.gridSize)/2, 
					   (camino.get(i+1).getMatrizX() * Config.gridSize) + (Config.gridSize)/2, (camino.get(i+1).getMatrizY() * Config.gridSize) + (Config.gridSize)/2);
			
			System.out.println(camino.get(i).getMatrizX() + ", " + camino.get(i).getMatrizY());
		}
		
		buffer = imagen;		
	}
			
	
}
