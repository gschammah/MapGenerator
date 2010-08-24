/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */
package ar.edu.uade.tesis_grupo13.vistas.framework.controlador;

import ar.edu.uade.tesis_grupo13.vistas.framework.vista.Vista;


public abstract class Controlador {
	Vista vista;	
	
	protected Controlador(Vista vis) {
		vista = vis;		
		vista.addControlador(this);
	}	
	
	public Vista getVista() {
		return vista;
	}
	
}
