package ar.edu.uade.tesis_grupo13.vistas.ventanas.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JPanel;

public class GUI_MainPanel extends JPanel {
		
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, BufferedImage> layers = new HashMap<String, BufferedImage>();
	private String[] layerOrder = {"mapaGrafo", "base", "grid"};

	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		repaintImage(g);		
	}		

	private void repaintImage(Graphics g) {	
		
		for (String layer: layerOrder) {						
			
			try {
				if (layers.containsKey(layer)) {
					g.drawImage(layers.get(layer), 0, 0, null);
				}
			} catch (NullPointerException e) {
				
			}		
		}		
		
	}

	public BufferedImage getLayer(String layerName) {
		return layers.get(layerName);
	}

	
	public void addLayer(String layerName, BufferedImage image) {		
		layers.put(layerName, image);
		repaint();
	}

	public void removeLayer(String layerName) {		
		layers.remove(layerName);
		repaint();
	}
		
	
}
