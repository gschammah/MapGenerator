/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */
package ar.edu.uade.tesis_grupo13.vistas.framework.controlador;

import ar.edu.uade.tesis_grupo13.vistas.framework.modelo.Modelo;
import ar.edu.uade.tesis_grupo13.vistas.framework.vista.Vista;


public abstract class Controlador {
	Vista vista;
	Modelo modelo;	
	
	protected Controlador(Modelo mod, Vista vis) {
		vista = vis;
		modelo = mod;
		mod.setVista(vis);
		vista.addControlador(this);
	}	
	
	public Vista getVista() {
		return vista;
	}
	
	public Modelo getModelo() {
		return modelo;
	}
	
}
