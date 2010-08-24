package ar.edu.uade.tesis_grupo13.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ar.edu.uade.tesis_grupo13.modelo.MapMaker;
import ar.edu.uade.tesis_grupo13.tools.ProcesamientoImagenes;
import ar.edu.uade.tesis_grupo13.vistas.framework.controlador.Controlador;
import ar.edu.uade.tesis_grupo13.vistas.ventanas.VistaMainMenu;

public class Controller_MainMenu extends Controlador {

	private VistaMainMenu vista;
	private MapMaker modelo;
	private BufferedImage grilla;
	private BufferedImage mapaGrafo;
	private BufferedImage imagen;
	private BufferedImage grafo;

	public Controller_MainMenu(MapMaker mapa, VistaMainMenu vista) {
		super(mapa, vista);
		this.vista = vista;
		this.modelo = mapa;
	}

	public void salir() {
		vista.salir();
	}

	public void toggleGrilla(boolean mostrar) {
		if (grilla == null) {
			grilla = generarGrilla();
		}
		if (mostrar) {
			vista.addLayer("grid", grilla);
		} else {
			vista.removeLayer("grid");
		}
	}

	public void cargarImagen(String file) {		
		try {
			imagen = ImageIO.read(new File(file));
			
			modelo.setImagen(ProcesamientoImagenes.jpg2Imagen(imagen));
			modelo.generarMatriz();
			mapaGrafo = generarMapaGrafo();
			
			vista.addLayer("mapaGrafo", mapaGrafo);
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

		BufferedImage mapaGrafo = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_ARGB);
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

	public void toggleOriginal(boolean mostrar) {
		if (mostrar) {
			vista.removeLayer("mapaGrafo");
			vista.addLayer("base", imagen);
		} else {
			vista.removeLayer("base");
			vista.addLayer("mapaGrafo", mapaGrafo);
		}
	}

	public void toggleGrafo(boolean mostrar) {
		
		if (grafo == null) {
			grafo = generarGrafo();
		}
		
		if (mostrar) {
			vista.addLayer("grafo", grafo);
		} else {
			vista.removeLayer("grafo");		
		}
				
	}

	private BufferedImage generarGrafo() {
		
		int w = modelo.getImagen().getWidth();
		int h = modelo.getImagen().getHeight();

		BufferedImage mapaGrafo = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = mapaGrafo.createGraphics();
		
		boolean[][] matriz = modelo.getMatrizParedes();
		
		g.setColor(Color.BLUE);
		
		for (int y = 0; y < matriz.length; y++) {
			for (int x = 0; x < matriz[0].length; x++) {				
								
				g.fillRect((x*10) + 3, (y*10) + 3, 5, 5);						
					
				//Me fijo si no soy parte de una pared
				if (!matriz[y][x]) {																				
					
					//Me fijo si el cuadro de al lado no es parte de una pared
					if ( x < matriz[0].length - 1 && !matriz[y][x+1] ) {
						g.drawLine((x*10) + 5, (y*10) + 5, (((x+1)*10) + 5), ((y)*10) + 5);																		
					}
					
					//Me fijo si el cuadro de abajo no es parte de una pared
					if ( y < matriz.length - 1 && !matriz[y+1][x] ) {
						g.drawLine((x*10) + 5, (y*10) + 5, (((x)*10) + 5), ((y+1)*10) + 5);																		
					}
					
					//Me fijo si el cuadro diagonal derecho de abajo no es parte de una pared
					if ( x < matriz[0].length - 1 && y < matriz.length - 1 && !matriz[y+1][x+1] ) {
						g.drawLine((x*10) + 5, (y*10) + 5, (((x+1)*10) + 5), ((y+1)*10) + 5);																		
					}
					
					//Me fijo si el cuadro diagonal izquierdo de abajo no es parte de una pared
					if ( x > 0  && y < matriz.length - 1 && !matriz[y+1][x-1] ) {
						g.drawLine((x*10) + 5, (y*10) + 5, (((x-1)*10) + 5), ((y+1)*10) + 5);																		
					}					
				}											
			}
		}
		
		return mapaGrafo;
	}

}
