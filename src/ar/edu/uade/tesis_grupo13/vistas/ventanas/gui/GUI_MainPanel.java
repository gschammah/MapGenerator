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

import ar.edu.uade.tesis_grupo13.config.Config;
import ar.edu.uade.tesis_grupo13.modelo.MapMaker;
import ar.edu.uade.tesis_grupo13.vistas.imagenes.componentes.MapaComponent;
import ar.edu.uade.tesis_grupo13.vistas.ventanas.VistaMainMenu;

public class GUI_MainPanel extends JLabel implements Scrollable {
		
	private static final long serialVersionUID = 1L;
	private VistaMainMenu vistaPadre;
	
	private int maxUnitIncrement = 1;
	private Dimension imageSize;
		
	private HashMap<String, MapaComponent> layers;
	private HashMap<String, ImageIcon> layerBuffer;
	private String[] layerOrder = {"mapaGrillado", "base", "bordes", "grafo", "path", "startPoint", "endPoint", "grid"}; 		
	private String[] noBuffer = {"startPoint", "endPoint"};	
	
	public GUI_MainPanel(){
		super();
		layers = new HashMap<String, MapaComponent>();
		layerBuffer = new HashMap<String, ImageIcon>();	
	}
	
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
	
	public void clearBuffer(){
		layerBuffer.clear();		
	}

	public void redibujar() {
		
		String layerString = getLayerString();
		String layerStringNoBF = getLayerStringNoBuffer();
		setAlignmentX(CENTER_ALIGNMENT);
		setAlignmentY(TOP_ALIGNMENT);
				
		if (layerBuffer.containsKey(layerString) && layerString.equals(layerStringNoBF)) {
		
			setIcon(layerBuffer.get(layerString));
			System.err.println("dibujando buffer: " + layerString);
			
		} else if (layers.size() > 0) {
			
			Config config = ((MapMaker)(vistaPadre.getControlador().getModelo())).getConfig();
			
			int width = (int) (imageSize.width * config.zoom);
			int height = (int) (imageSize.height * config.zoom);
			
			BufferedImage tempImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D gTemp = tempImg.createGraphics();			
			
			for (String layer: layerOrder) {													
				if (layers.containsKey(layer)) {		
					gTemp.drawImage(layers.get(layer).getFromBuffer(), 0, 0, width, height, null);					
					layerBuffer.put(layerString, new ImageIcon(layers.get(layer).getFromBuffer()));					
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
					result.append("+").append(keys.get(i));
				}
			}
			
			return result.toString();
		} else {
			return null;
		}
	}
	
	public void addLayer(String layerName, MapaComponent image) {
		if (layerName.equals("mapaGrillado")) {
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
		for (String key: layers.keySet()) {
			layers.get(key).repaint();
		}		
		redibujar();		
	}

	public boolean hasLayer(String layerName) {
		return layers.containsKey(layerName);
	}
	
	public void setVistaPadre(VistaMainMenu vistaPadre) {
		this.vistaPadre = vistaPadre;
	}

		
	
}
