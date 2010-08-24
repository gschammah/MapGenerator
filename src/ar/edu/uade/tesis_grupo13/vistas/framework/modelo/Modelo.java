package ar.edu.uade.tesis_grupo13.vistas.framework.modelo;

import ar.edu.uade.tesis_grupo13.vistas.framework.vista.Vista;

public abstract class Modelo {

	protected Vista vista = null;
	
	public void setVista(Vista v) {
		vista = v;
	}

}
