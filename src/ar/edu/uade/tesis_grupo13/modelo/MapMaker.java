package ar.edu.uade.tesis_grupo13.modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ar.edu.uade.tesis_grupo13.vistas.framework.modelo.Modelo;

public class MapMaker extends Modelo{
	
	private BufferedImage imagen;
	private boolean[][] matriz;

	public MapMaker() {		
	}
	
	public void loadImage(String archivo) {
		try {
			imagen = ImageIO.read(new File(archivo));
			generarMatriz();
		} catch (IOException e) {			
			System.err.println(e.getMessage());
		}
	}
	
	private void generarMatriz() {
		int w = imagen.getWidth();
		int h = imagen.getHeight();
		
		matriz = new boolean[(int)Math.ceil(h/10)+1][(int)Math.ceil(w/10)+1];		 				

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				
				int pixel = imagen.getRGB(j, i);
								
				if (!matriz[(int)Math.floor(i/10)][(int)Math.floor(j/10)] && pixel == Color.BLACK.getRGB()) {
					matriz[(int)Math.floor(i/10)][(int)Math.floor(j/10)] = true;
				}
				
			}
		}			
	}
	
	public BufferedImage generarGrilla() {			
        int w = imagen.getWidth();
        int h = imagen.getHeight();
        
        BufferedImage grilla = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = grilla.createGraphics();
		g.setColor(Color.RED);
               
        for (int x=0; x<w; x+=10) {g.drawLine(x, 0, x, h);}
        for (int y=0; y<h; y+=10) {g.drawLine(0, y, w, y);}
		
		return grilla;
	}
	
	public BufferedImage generarMapaGrafo(){
		
		int w = imagen.getWidth();
        int h = imagen.getHeight();
        
        BufferedImage mapaGrafo = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = mapaGrafo.createGraphics();
						
		for (int y = 0; y < matriz.length; y++) {
			for (int x = 0; x < matriz[0].length; x++) {																		
				//Me fijo si no soy parte de una pared
				if (matriz[y][x]) {	
					g.setColor(Color.BLACK);					
				} else {
					g.setColor(Color.WHITE);
				}
					g.fillRect((x*10), (y*10), 10, 10);
			}
		}
		
		return mapaGrafo;
	}


	public BufferedImage getImagen() {
		return imagen;
	}

	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}
	
}
