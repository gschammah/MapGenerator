package ar.edu.uade.tesis_grupo13.modelo;

import ar.edu.uade.tesis_grupo13.config.Config;
import ar.edu.uade.tesis_grupo13.grafos.Coordenada;

public class CoordenadaSoftware extends Coordenada {	

	public CoordenadaSoftware(double x, double y) {
		super(x, y);		
		procesarCoordReales();
	}

	private void procesarCoordReales() {
		this.setMatrizX((int) Math.floor(this.getX()/Config.gridSize));
		this.setMatrizY((int) Math.floor(this.getY()/Config.gridSize));		
	}
	
	@Override
	public int getMatrizX() {
		this.setMatrizX((int) Math.floor(this.getX()/Config.gridSize));
		return super.getMatrizX();
	}
	
	@Override
	public int getMatrizY() {
		this.setMatrizY((int) Math.floor(this.getY()/Config.gridSize));
		return super.getMatrizY();
	}
	
}
