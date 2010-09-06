package ar.edu.uade.tesis_grupo13.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import ar.edu.uade.tesis_grupo13.modelo.MapMaker;
import ar.edu.uade.tesis_grupo13.modelo.grafo.Coordenada;
import ar.edu.uade.tesis_grupo13.modelo.grafo.CoordenadaSoftware;
import ar.edu.uade.tesis_grupo13.tools.ProcesamientoImagenes;
import ar.edu.uade.tesis_grupo13.vistas.framework.controlador.Controlador;
import ar.edu.uade.tesis_grupo13.vistas.ventanas.VistaMainMenu;

public class Controller_MainMenu extends Controlador {

	private VistaMainMenu vista;
	private MapMaker modelo;
	private HashMap<String, BufferedImage> layers = new HashMap<String, BufferedImage>();
	private CoordenadaSoftware currentCoord = new CoordenadaSoftware(0, 0);

	public Controller_MainMenu(MapMaker mapa, VistaMainMenu vista) {
		super(mapa, vista);
		this.vista = vista;
		this.modelo = mapa;
	}

	public void salir() {
		vista.salir();
	}

	public void toggleGrilla(boolean mostrar) {
		if (layers.get("grid") == null) {
			layers.put("grid", generarGrilla());
		}
		if (mostrar) {
			vista.addLayer("grid", layers.get("grid"));
		} else {
			vista.removeLayer("grid");
		}
	}
	
	public void toggleBordes(boolean mostrar) {
		if (layers.get("bordes")== null) {
			layers.put("bordes", generarBordesGrafo());
		}
		if (mostrar) {
			vista.addLayer("bordes", layers.get("bordes"));
		} else {
			vista.removeLayer("bordes");
		}
	}

	public void cargarImagen(String file) {		
		try {
			BufferedImage imagen = ImageIO.read(new File(file));			
			modelo.setImagen(ProcesamientoImagenes.jpg2Imagen(imagen));
			layers.clear();
			layers.put("imagen", imagen);
			layers.put("mapaGrafo", generarMapaGrafo());		
			
			vista.clearLayers();
			vista.addLayer("mapaGrafo", layers.get("mapaGrafo"));
			
		} catch (IOException e) {			
			System.err.println(e.getMessage());
		}					
	}
	
	public BufferedImage generarGrilla() {			
        
		int w = modelo.getImagen().getWidth();
		int h = modelo.getImagen().getHeight();
        
        BufferedImage grilla = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = grilla.createGraphics();
		g.setColor(Color.RED);
               
        for (int x=0; x<w; x+=10) {g.drawLine(x, 0, x, h);}
        for (int y=0; y<h; y+=10) {g.drawLine(0, y, w, y);}
		
		return grilla;
	}

	public BufferedImage generarMapaGrafo() {

		int w = modelo.getImagen().getWidth();
		int h = modelo.getImagen().getHeight();

		BufferedImage mapaGrafo = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = mapaGrafo.createGraphics();

		for (int y = 0; y < modelo.getMatrizParedes().length; y++) {
			for (int x = 0; x < modelo.getMatrizParedes()[0].length; x++) {
				// Me fijo si no soy parte de una pared
				if (modelo.getMatrizParedes()[y][x]) {
					g.setColor(Color.BLACK);
				} else {
					g.setColor(Color.WHITE);
				}
				g.fillRect((x * 10), (y * 10), 10, 10);
			}
		}

		return mapaGrafo;
	}
	
	public BufferedImage generarBordesGrafo() {

		int w = modelo.getImagen().getWidth();
		int h = modelo.getImagen().getHeight();

		BufferedImage mapaGrafo = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = mapaGrafo.createGraphics();
		
		g.setColor(Color.ORANGE);

		for (int y = 0; y < modelo.getMatrizParedes().length; y++) {
			for (int x = 0; x < modelo.getMatrizParedes()[0].length; x++) {
				// Me fijo si no soy parte de una pared
				if (modelo.isBorder(x, y)) {
					g.fillRect((x * 10), (y * 10), 10, 10);
				} 				
			}
		}

		return mapaGrafo;
	}

	public void toggleOriginal(boolean mostrar) {
		if (mostrar) {
			vista.removeLayer("mapaGrafo");
			vista.addLayer("base", layers.get("imagen"));
		} else {
			vista.removeLayer("base");
			vista.addLayer("mapaGrafo", layers.get("mapaGrafo"));
		}
	}

	public void toggleGrafo(boolean mostrar) {
		
		if (layers.get("grafo") == null) {
			layers.put("grafo", generarGrafo());
		}
		
		if (mostrar) {
			vista.addLayer("grafo", layers.get("grafo"));
		} else {
			vista.removeLayer("grafo");		
		}
				
	}
	
	public void togglePath(boolean mostrar) {						
		if (mostrar && layers.get("path") != null) {
			vista.addLayer("path", layers.get("path"));
		} else {
			vista.removeLayer("path");		
		}				
	}

	private BufferedImage generarGrafo() {
		
		int w = modelo.getImagen().getWidth();
		int h = modelo.getImagen().getHeight();

		BufferedImage mapaGrafo = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = mapaGrafo.createGraphics();
		
		boolean[][] matriz = modelo.getMatrizParedes();
					
		for (int y = 0; y < matriz.length; y++) {
			for (int x = 0; x < matriz[0].length; x++) {				
				
				//Grafico vertice
				g.setColor(Color.BLUE);
				g.fillRect((x*10) + 3, (y*10) + 3, 5, 5);								
				
				for (Coordenada coord : modelo.getGrafo().getVertices(x, y)) {
					
					int x2 = coord.getMatrizX();
					int y2 = coord.getMatrizY();
					double weight = modelo.getGrafo().getEdgeWeight(x, y, x2, y2);
					
					if (weight > 1 && weight < 5) {
						g.setColor(Color.GREEN);
					} else if (weight >= 5 && weight < 7.5) {
						g.setColor(Color.YELLOW);
					} else if (weight >= 7.5){
						g.setColor(Color.RED);
					}
					
					g.drawLine((x*10) + 5, (y*10) + 5, (((x2)*10) + 5), ((y2)*10) + 5);
				}
																		
			}
		}
		
		return mapaGrafo;
	}


	public CoordenadaSoftware getGridCoord(int x, int y) throws NullPointerException {								
		
		currentCoord.setX(x);
		currentCoord.setY(y);
				
		return currentCoord;
	}

	public void setStartPoint(int x, int y) {
		CoordenadaSoftware coord = new CoordenadaSoftware(x, y);
		modelo.getGrafo().setStartPoint(coord);
		vista.addLayer("startPoint", generarBox(coord.getMatrizX(), coord.getMatrizY(), Color.GREEN));		
	}

	public void setEndPoint(int x, int y) {
		CoordenadaSoftware coord = new CoordenadaSoftware(x, y);
		modelo.getGrafo().setEndPoint(coord);
		vista.addLayer("endPoint", generarBox(coord.getMatrizX(), coord.getMatrizY(), Color.RED));
	}

	public void calcularRuta() {
		ArrayList<Coordenada> camino = modelo.getGrafo().calcularCamino();
		BufferedImage caminoImage = generarCamino(camino);
		layers.put("path", caminoImage);
		vista.addLayer("path", caminoImage);
		
		for (Coordenada coordenada : camino) {
			System.out.println(coordenada.getMatrizX() + ", " + coordenada.getMatrizY());
		}
	}
	
	public BufferedImage generarCamino(ArrayList<Coordenada> camino) {

		int w = modelo.getImagen().getWidth();
		int h = modelo.getImagen().getHeight();

		BufferedImage imagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imagen.createGraphics();
		
		g.setColor(Color.GREEN);

		for (Coordenada coord : camino) {
			g.fillRect((coord.getMatrizX() * 10), (coord.getMatrizY() * 10), 10, 10);
		}

		return imagen;
	}
	
	public BufferedImage generarBox(int x, int y, Color color) {

		int w = modelo.getImagen().getWidth();
		int h = modelo.getImagen().getHeight();

		BufferedImage imagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imagen.createGraphics();
		
		g.setColor(color);
		
		g.fillRect((x * 10), (y * 10), 10, 10);		

		return imagen;
	}

}
