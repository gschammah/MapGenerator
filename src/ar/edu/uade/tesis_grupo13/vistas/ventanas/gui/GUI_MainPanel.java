package ar.edu.uade.tesis_grupo13.vistas.ventanas.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GUI_MainPanel extends JPanel {
		
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;

	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		repaintImage(g);		
	}		

	private void repaintImage(Graphics g) {		
		try {
			if (this.getWidth() > image.getWidth()) {
				g.drawImage(this.image, 0, 0, this.getHeight() * image.getWidth() / image.getHeight(), this.getHeight(), null);
			} else {
				g.drawImage(this.image, 0, 0, this.getWidth(), this.getWidth() * image.getHeight() / image.getWidth(), null);
			}
		} catch (NullPointerException e) {
			
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
		repaint();
	}
		
	
}
