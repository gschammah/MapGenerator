package ar.edu.uade.tesis_grupo13.vistas.ventanas.gui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

public class GUI_MainPanel extends JLabel implements Scrollable {
		
	private static final long serialVersionUID = 1L;
	
	private int maxUnitIncrement = 1;
	private Dimension imageSize;
		
	private HashMap<String, BufferedImage> layers = new HashMap<String, BufferedImage>();
	private HashMap<String, ImageIcon> layerBuffer = new HashMap<String, ImageIcon>();
	private String[] layerOrder = {"mapaGrafo", "base", "bordes", "grafo", "path", "startPoint", "endPoint", "grid"};		
	private String[] noBuffer = {"startPoint", "endPoint"};
	
	private String getLayerString() {								
		
		ArrayList<String> keys = new ArrayList<String>(layers.keySet());
		
		if (keys.size() > 0) { 
		
			Collections.sort(keys);
			StringBuilder result = new StringBuilder(keys.get(0));
			
			for (int i=1; i<keys.size(); i++) {
				result.append("+").append(keys.get(i));
			}
			
			return result.toString();
		} else {
			return null;
		}
	}

	private void redibujar() {
		
		String layerString = getLayerString();
		String layerStringNoBF = getLayerStringNoBuffer();
		setAlignmentX(CENTER_ALIGNMENT);
		setAlignmentY(TOP_ALIGNMENT);
				
		if (layerBuffer.containsKey(layerString) && layerString.equals(layerStringNoBF)) {
		
			setIcon(layerBuffer.get(layerString));
			System.err.println("dibujando buffer: " + layerString);
			
		} else if (layers.size() > 0) {
			
			BufferedImage tempImg = new BufferedImage(imageSize.width, imageSize.height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D gTemp = tempImg.createGraphics();
			
			for (String layer: layerOrder) {													
				if (layers.containsKey(layer)) {		
					gTemp.drawImage(layers.get(layer), 0, 0, null);
					layerBuffer.put(layerString, new ImageIcon(layers.get(layer)));
				}					
			}						
			
			layerBuffer.put(layerStringNoBF, new ImageIcon(tempImg));
			setIcon(layerBuffer.get(layerStringNoBF));
			System.err.println("dibujando nuevo: " + layerStringNoBF);
			
		}
		
	}

	private String getLayerStringNoBuffer() {
		ArrayList<String> keys = new ArrayList<String>(layers.keySet());
		List<String> noBF = Arrays.asList(noBuffer);
		
		if (keys.size() > 0) { 
		
			Collections.sort(keys);
			StringBuilder result = new StringBuilder(keys.get(0));					
			
			for (int i=1; i<keys.size(); i++) {				
				if (!noBF.contains(keys.get(i))) {
					System.err.println(keys.get(i));
					result.append("+").append(keys.get(i));
				}
			}
			
			return result.toString();
		} else {
			return null;
		}
	}

	public BufferedImage getLayer(String layerName) {
		return layers.get(layerName);
	}

	
	public void addLayer(String layerName, BufferedImage image) {
		if (layerName.equals("mapaGrafo")) {
			imageSize = new Dimension(image.getWidth(), image.getHeight());			
		}
		layers.put(layerName, image);
		redibujar();
	}

	public void removeLayer(String layerName) {		
		layers.remove(layerName);
		redibujar();
	}

	@Override
	public Dimension getPreferredScrollableViewportSize() {
		return getPreferredSize();
	}

	@Override
	   public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        if (orientation == SwingConstants.HORIZONTAL)
            return visibleRect.width - maxUnitIncrement;
        else
            return visibleRect.height - maxUnitIncrement;
    }

	@Override
	public boolean getScrollableTracksViewportHeight() {	
		return false;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		return false;
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {

        int currentPosition = 0;
        if (orientation == SwingConstants.HORIZONTAL)
            currentPosition = visibleRect.x;
        else
            currentPosition = visibleRect.y;

        if (direction < 0) {
            int newPosition = currentPosition - (currentPosition / maxUnitIncrement) * maxUnitIncrement;
            return (newPosition == 0) ? maxUnitIncrement : newPosition;
        } else {
            return ((currentPosition / maxUnitIncrement) + 1) * maxUnitIncrement - currentPosition;
        }
    }
	
	public Dimension getImageSize() {
		return imageSize;
	}

	public void setImageSize(Dimension imageSize) {
		this.imageSize = imageSize;
	}

	public void clearLayers() {		
		layerBuffer.clear();
		layers.clear();
	}

		
	
}
