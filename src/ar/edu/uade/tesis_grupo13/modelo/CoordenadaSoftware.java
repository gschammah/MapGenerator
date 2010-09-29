package ar.edu.uade.tesis_grupo13.modelo;

import java.awt.Dimension;

import ar.edu.uade.tesis_grupo13.grafos.Coordenada;

public class CoordenadaSoftware extends Coordenada {
	
	private Dimension mapSize;
	
	
	public CoordenadaSoftware(double x, double y, Dimension mapSize) {
		super(x, y);		
		this.mapSize = mapSize;
	}
	
	public void setMapSize(Dimension mapSize) {
		this.mapSize = mapSize;
	}

	@Override
	public void setX(double x) {		
		this.x = x / mapSize.width * 10;		
	}
	
	@Override
	public void setY(double y) {		
		this.y = y / mapSize.height * 10;	
	}
		
	/*@Override
	public int getMatrizX() {
		int imageWidth = MapMaker.getInstance().getMapSize().width;
		int w = (int) (config.gridSize * Math.ceil((double)imageWidth/ (double)config.gridSize));
		
		int offsetLeft = (w - imageWidth) / 2;
				
		int val = (int) Math.floor((this.getX() + offsetLeft)/config.gridSize/config.zoom) - config.startLat / 2;
		this.setMatrizX(val);
		return super.getMatrizX();
	}
	
	@Override
	public int getMatrizY() {

		int imageHeight = MapMaker.getInstance().getMapSize().height;
		int h = (int) (config.gridSize * Math.ceil((double)imageHeight / (double)config.gridSize)) - config.startLong / 2;
		
		int offsetTop = (h - imageHeight) / 2;
		int val = (int) Math.floor((this.getY() + offsetTop)/config.gridSize/config.zoom);
		
		this.setMatrizY(val);
		return super.getMatrizY();
	}
*/	
}
