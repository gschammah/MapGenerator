package ar.edu.uade.tesis_grupo13.vistas.imagenes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import ar.edu.uade.tesis_grupo13.grafos.Coordenada;
import ar.edu.uade.tesis_grupo13.grafos.Mapa;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Bordes;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Grafo;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Grilla;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Imagen;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.MapaComponent;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.MapaGrillado;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.Path;

public class GeneradorImagenes {
	
	private int width;
	private int height;	
	private HashMap<String, MapaComponent> layers;
	private Mapa map;
	
	public GeneradorImagenes(int w, int h, Mapa map) {
		this.width = w;
		this.height = h;
		this.map = map;
		this.layers = new HashMap<String, MapaComponent>();
	}

	public GeneradorImagenes(BufferedImage imagen, Mapa map) {
		this.width = imagen.getWidth();
		this.height = imagen.getHeight();
		this.map = map;
		this.layers = new HashMap<String, MapaComponent>();
		this.layers.put("imagen", Imagen.getInstance(imagen));
	}

	public MapaComponent getGrid() {
		if (layers.get("grid") == null) {
			layers.put("grid", Grilla.getInstance(width, height));
		}
		return layers.get("grid");
	}
	
	public MapaComponent getBordes() {
		if (layers.get("bordes") == null) {
			layers.put("bordes", Bordes.getInstance(width, height, map));
		}
		return layers.get("bordes");
	}
	
	public MapaComponent getMapaGrillado() {
		if (layers.get("mapaGrillado") == null) {
			layers.put("mapaGrillado", MapaGrillado.getInstance(width, height, map));
		}
		return layers.get("mapaGrillado");
	}

	public MapaComponent getGrafo() {
		if (layers.get("grafo") == null) {
			layers.put("grafo", Grafo.getInstance(width, height, map));
		}
		return layers.get("grafo");
	}

	public MapaComponent getPath(ArrayList<Coordenada> camino) {		
		layers.put("path", Path.getInstance(width, height, camino));		
		return layers.get("path");
	}
	
	public MapaComponent getPath() {
		return layers.get("path");
	}

	public MapaComponent getImagen() {		
		return layers.get("imagen");
	}
	
	public void clearBuffer() {
		MapaComponent tmp = layers.get("imagen");
		layers.clear();
		layers.put("imagen", tmp);
	}

}
