package ar.edu.uade.tesis_grupo13.vistas.imagenes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import ar.edu.uade.tesis_grupo13.grafos.Coordenada;
import ar.edu.uade.tesis_grupo13.grafos.Mapa;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Bordes;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Grafo;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Grilla;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.MapaGrillado;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Path;

public class GeneradorImagenes {
	
	private int width;
	private int height;	
	private HashMap<String, BufferedImage> layers;
	private Mapa map;
	
	public GeneradorImagenes(int w, int h, Mapa map) {
		this.width = w;
		this.height = h;
		this.map = map;
		this.layers = new HashMap<String, BufferedImage>();
	}

	public GeneradorImagenes(BufferedImage imagen, Mapa map) {
		this.width = imagen.getWidth();
		this.height = imagen.getHeight();
		this.map = map;
		this.layers = new HashMap<String, BufferedImage>();
		this.layers.put("imagen", imagen);
	}

	public BufferedImage getGrid() {
		if (layers.get("grid") == null) {
			layers.put("grid", Grilla.generar(width, height));
		}
		return layers.get("grid");
	}
	
	public BufferedImage getBordes() {
		if (layers.get("bordes") == null) {
			layers.put("bordes", Bordes.generar(width, height, map));
		}
		return layers.get("bordes");
	}
	
	public BufferedImage getMapaGrillado() {
		if (layers.get("mapaGrillado") == null) {
			layers.put("mapaGrillado", MapaGrillado.generar(width, height, map));
		}
		return layers.get("mapaGrillado");
	}

	public BufferedImage getGrafo() {
		if (layers.get("grafo") == null) {
			layers.put("grafo", Grafo.generar(width, height, map));
		}
		return layers.get("grafo");
	}

	public BufferedImage getPath(ArrayList<Coordenada> camino) {
		if (layers.get("path") == null) {
			layers.put("path", Path.generar(width, height, camino));
		}
		return layers.get("path");
	}
	
	public BufferedImage getPath() {
		return layers.get("path");
	}

	public BufferedImage getImagen() {		
		return layers.get("imagen");
	}

}
