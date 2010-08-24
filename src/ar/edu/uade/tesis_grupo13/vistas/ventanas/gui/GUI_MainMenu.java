/*
 * Created by JFormDesigner on Mon Aug 23 19:11:01 ART 2010
 */

package ar.edu.uade.tesis_grupo13.vistas.ventanas.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import ar.edu.uade.tesis_grupo13.controller.Controller_MainMenu;
import ar.edu.uade.tesis_grupo13.vistas.ventanas.VistaMainMenu;

/**
 * @author Gabriel Schammah
 */
public class GUI_MainMenu extends JFrame {
		
	private static final long serialVersionUID = 1L;
	
	private VistaMainMenu vistaPadre;	
	
	public GUI_MainMenu(VistaMainMenu vistaMainMenu) {
		vistaPadre = vistaMainMenu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}


	private void menuSalirActionPerformed(ActionEvent e) {
		((Controller_MainMenu)vistaPadre.getControlador()).salir();
	}

	
	private void initComponents() {		
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		panel1 = new JPanel();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		abrirMapa = new JMenuItem();
		menuSalir = new JMenuItem();
		menu2 = new JMenu();
		imagePanel = new GUI_MainPanel();

		//======== this ========
		setLayout(new GridLayout());

		//======== panel1 ========
		{

			//======== menuBar1 ========
			{				
				//======== menu1 ========
				{
					menu1.setText("Archivo");					
					//---- abrirMapa ----
					abrirMapa.setText("Abrir mapa...");
					
					menu1.add(abrirMapa);
					menu1.addSeparator();

					//---- menuSalir ----
					menuSalir.setText("Salir");
					menuSalir.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							menuSalirActionPerformed(e);
						}
					});
					menu1.add(menuSalir);
				}
				menuBar1.add(menu1);

				//======== menu2 ========
				{
					menu2.setText("Opciones");
				}
				menuBar1.add(menu2);
			}

			//======== imagePanel ========
			{
				imagePanel.setLayout(new GridLayout(1, 1));
			}

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addComponent(menuBar1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
					.addComponent(imagePanel, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
			);
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(imagePanel, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
			);
		}
		add(panel1);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel panel1;
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem abrirMapa;
	private JMenuItem menuSalir;
	private JMenu menu2;
	private GUI_MainPanel imagePanel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	
	public void setImage(BufferedImage img) {		
		imagePanel.setImage(img);		
	}		
		
	
}
