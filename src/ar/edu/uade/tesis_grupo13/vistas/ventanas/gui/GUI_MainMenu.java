/*
 * Created by JFormDesigner on Mon Aug 23 19:11:01 ART 2010
 */

package ar.edu.uade.tesis_grupo13.vistas.ventanas.gui;

import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.event.*;

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
	
	private void abrirMapaActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void menuGrillaActionPerformed(ActionEvent e) {
		((Controller_MainMenu)vistaPadre.getControlador()).toggleGrilla(menuGrilla.getState());
	}

	private void menuMapaOriginalActionPerformed(ActionEvent e) {
		((Controller_MainMenu)vistaPadre.getControlador()).toggleOriginal(menuMapaOriginal.getState());
	}


	
	private void initComponents() {		
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		panel1 = new JPanel();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		abrirMapa = new JMenuItem();
		menuSalir = new JMenuItem();
		menu2 = new JMenu();
		menuGrilla = new JCheckBoxMenuItem();
		menuMapaOriginal = new JCheckBoxMenuItem();
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
					menu1.setMnemonic('A');

					//---- abrirMapa ----
					abrirMapa.setText("Abrir mapa...");
					abrirMapa.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							abrirMapaActionPerformed(e);
						}
					});
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
					menu2.setMnemonic('O');

					//---- menuGrilla ----
					menuGrilla.setText("Mostrar grilla");
					menuGrilla.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							menuGrillaActionPerformed(e);
						}
					});
					menu2.add(menuGrilla);

					//---- menuMapaOriginal ----
					menuMapaOriginal.setText("Ver Mapa Original");
					menuMapaOriginal.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							menuMapaOriginalActionPerformed(e);
						}
					});
					menu2.add(menuMapaOriginal);
				}
				menuBar1.add(menu2);
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
	private JCheckBoxMenuItem menuGrilla;
	private JCheckBoxMenuItem menuMapaOriginal;
	private GUI_MainPanel imagePanel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
				
	public void addLayer(String layerName, BufferedImage image) {
		imagePanel.addLayer(layerName, image);		
	}

	public void removeLayer(String layerName) {
		imagePanel.removeLayer(layerName);
	}
		
	
}
