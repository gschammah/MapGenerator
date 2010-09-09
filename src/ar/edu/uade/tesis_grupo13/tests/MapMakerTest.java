package ar.edu.uade.tesis_grupo13.tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import ar.edu.uade.tesis_grupo13.modelo.MapMaker;
import ar.edu.uade.tesis_grupo13.tools.ProcesamientoImagenes;

public class MapMakerTest {
	
	private MapMaker mapa;
	
	@Before
	public void setUp() {
		mapa = new MapMaker();
		BufferedImage img;
		try {
			img = ImageIO.read(new File("/home/gabriel/Documentos/tesis/examples/SpaceWandererExample/bitmaps/autolab.png"));
			mapa.setImagen(ProcesamientoImagenes.jpg2Imagen(img));			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testIsBorder() {		
		/*assertFalse("Border 60,0", mapa.isBorder(0, 60));
		assertTrue("Borde 1,1", mapa.isBorder(1, 1));				
		assertTrue("Borde 8,1", mapa.isBorder(1, 8));
		assertFalse("Borde 8,2", mapa.isBorder(8, 2));
		assertTrue("Borde 2,11", mapa.isBorder(2, 11));*/
	}

}
