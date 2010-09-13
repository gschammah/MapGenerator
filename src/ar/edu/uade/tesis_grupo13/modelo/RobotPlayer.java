package ar.edu.uade.tesis_grupo13.modelo;

import ar.edu.uade.tesis_grupo13.autodriver.Autodriver;
import ar.edu.uade.tesis_grupo13.exceptions.RobotConnectionException;
import ar.edu.uade.tesis_grupo13.grafos.Coordenada;
import ar.edu.uade.tesis_grupo13.robot.Robot;


public class RobotPlayer {
	
	private Settings settings;
	private Autodriver ad;
	
	public RobotPlayer(Settings settings) {
		this.settings = settings;		
	}
	
	public Coordenada connect() throws RobotConnectionException {
		Robot robot = new Robot(settings.getServer(), settings.getPort());
		robot.initialize();		
		ad = new Autodriver(robot);
		return ad.getLoc().getCoord();
	}
	
	public void disconnect() {
		ad.close();
	}

	public void start() {				    	        		
    					
		//ad.posicionarRobot(-2f, -1f, (float)Math.toRadians(155));
		//ad.getRobot().sleep(2000);
		
		//ad.inicializar();
		
		
		
		//ad.irA(-2, 3);		
		//ad.irA(-4, 2);		
				
		//ad.posicionarDireccion(180);
				
		//ad.close();
		
	}

}
