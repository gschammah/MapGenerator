package ar.edu.uade.tesis_grupo13.modelo;

import ar.edu.uade.tesis_grupo13.config.Config;
import ar.edu.uade.tesis_grupo13.grafos.Coordenada;

public class CoordenadaSoftware extends Coordenada {
	
	private Config config;

	public CoordenadaSoftware(double x, double y) {
		super(x, y);		
		config = MapMaker.getInstance().getConfig();
	}
	
	@Override
	public int getMatrizX() {
		this.setMatrizX((int) Math.floor(this.getX()/config.gridSize/config.zoom));
		return super.getMatrizX();
	}
	
	@Override
	public int getMatrizY() {
		this.setMatrizY((int) Math.floor(this.getY()/config.gridSize/config.zoom));
		return super.getMatrizY();
	}
	
}
