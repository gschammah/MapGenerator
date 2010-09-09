/*
 * Created by JFormDesigner on Mon Aug 23 19:11:01 ART 2010
 */

package ar.edu.uade.tesis_grupo13.vistas.ventanas.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.SoftBevelBorder;

import ar.edu.uade.tesis_grupo13.controller.Controller_MainMenu;
import ar.edu.uade.tesis_grupo13.grafos.CoordenadaSoftware;
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
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		File selFile = fc.getSelectedFile();
		if (selFile != null) {
			((Controller_MainMenu)vistaPadre.getControlador()).cargarImagen(selFile.getAbsolutePath());
		}
	}

	private void menuGrillaActionPerformed(ActionEvent e) {
		((Controller_MainMenu)vistaPadre.getControlador()).toggleGrilla(menuGrilla.getState());
	}

	private void menuMapaOriginalActionPerformed(ActionEvent e) {
		((Controller_MainMenu)vistaPadre.getControlador()).toggleOriginal(menuMapaOriginal.getState());
	}

	private void menuMostrarGrafoActionPerformed(ActionEvent e) {
		((Controller_MainMenu)vistaPadre.getControlador()).toggleGrafo(menuMostrarGrafo.getState());
	}
	
	private void menuMostrarBordesActionPerformed(ActionEvent e) {
		((Controller_MainMenu)vistaPadre.getControlador()).toggleBordes(menuMostrarBordes.getState());
	}

	private void imagePanelMouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			((Controller_MainMenu)vistaPadre.getControlador()).setStartPoint(e.getX(), e.getY());
		} else {
			((Controller_MainMenu)vistaPadre.getControlador()).setEndPoint(e.getX(), e.getY());
		}
	}

	private void imagePanelMouseMoved(MouseEvent e) {
		try {
			CoordenadaSoftware coord = ((Controller_MainMenu)vistaPadre.getControlador()).getGridCoord(e.getX(), e.getY());		
			setCoord(coord);
		} catch (NullPointerException exc) {}
	}

	private void btnCalcularRutaActionPerformed(ActionEvent e) {
		((Controller_MainMenu)vistaPadre.getControlador()).calcularRuta();
	}

	private void menuMostrarCaminoActionPerformed(ActionEvent e) {
		((Controller_MainMenu)vistaPadre.getControlador()).togglePath(menuMostrarCamino.getState());
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
		menuMostrarGrafo = new JCheckBoxMenuItem();
		menuMostrarBordes = new JCheckBoxMenuItem();
		menuMostrarCamino = new JCheckBoxMenuItem();
		statusBar = new JPanel();
		lblCoord = new JLabel();
		scrollBarImage = new JScrollPane();
		imagePanel = new GUI_MainPanel();
		toolBar = new JToolBar();
		btnCalcularRuta = new JButton();

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
					abrirMapa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
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
					menuGrilla.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK));
					menuGrilla.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							menuGrillaActionPerformed(e);
						}
					});
					menu2.add(menuGrilla);

					//---- menuMapaOriginal ----
					menuMapaOriginal.setText("Ver Mapa Original");
					menuMapaOriginal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
					menuMapaOriginal.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							menuMapaOriginalActionPerformed(e);
						}
					});
					menu2.add(menuMapaOriginal);

					//---- menuMostrarGrafo ----
					menuMostrarGrafo.setText("Mostrar grafo");
					menuMostrarGrafo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_MASK));
					menuMostrarGrafo.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							menuMostrarGrafoActionPerformed(e);
						}
					});
					menu2.add(menuMostrarGrafo);

					//---- menuMostrarBordes ----
					menuMostrarBordes.setText("Mostrar bordes");
					menuMostrarBordes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK));
					menuMostrarBordes.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							menuMostrarBordesActionPerformed(e);
						}
					});
					menu2.add(menuMostrarBordes);

					//---- menuMostrarCamino ----
					menuMostrarCamino.setText("Mostrar Camino");
					menuMostrarCamino.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
					menuMostrarCamino.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							menuMostrarCaminoActionPerformed(e);
						}
					});
					menu2.add(menuMostrarCamino);
				}
				menuBar1.add(menu2);
			}

			//======== statusBar ========
			{
				statusBar.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

				//---- lblCoord ----
				lblCoord.setText("x:0 y:0");

				GroupLayout statusBarLayout = new GroupLayout(statusBar);
				statusBar.setLayout(statusBarLayout);
				statusBarLayout.setHorizontalGroup(
					statusBarLayout.createParallelGroup()
						.addGroup(statusBarLayout.createSequentialGroup()
							.addComponent(lblCoord, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(677, Short.MAX_VALUE))
				);
				statusBarLayout.setVerticalGroup(
					statusBarLayout.createParallelGroup()
						.addComponent(lblCoord, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
				);
			}

			//======== scrollBarImage ========
			{
				
				//---- imagePanel ----
				imagePanel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						imagePanelMouseClicked(e);
					}
				});
				imagePanel.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseMoved(MouseEvent e) {
						imagePanelMouseMoved(e);
					}
				});
				scrollBarImage.setViewportView(imagePanel);
			}

			//======== toolBar ========
			{
				toolBar.setFloatable(false);

				//---- btnCalcularRuta ----
				btnCalcularRuta.setText("Calcular Ruta");
				btnCalcularRuta.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btnCalcularRutaActionPerformed(e);
					}
				});
				toolBar.add(btnCalcularRuta);
			}

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addGap(0, 0, 0)
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(toolBar, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
							.addComponent(scrollBarImage, GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
							.addComponent(menuBar1, GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
							.addComponent(statusBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
			);
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGap(3, 3, 3)
						.addComponent(scrollBarImage, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
						.addGap(0, 0, 0)
						.addComponent(statusBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
	private JCheckBoxMenuItem menuMostrarGrafo;
	private JCheckBoxMenuItem menuMostrarBordes;
	private JCheckBoxMenuItem menuMostrarCamino;
	private JPanel statusBar;
	private JLabel lblCoord;
	private JScrollPane scrollBarImage;
	private GUI_MainPanel imagePanel;
	private JToolBar toolBar;
	private JButton btnCalcularRuta;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	public GUI_MainPanel getImagePanel() {
		return imagePanel;
	}
				
	public void addLayer(String layerName, BufferedImage image) {
		imagePanel.addLayer(layerName, image);				
	}

	public void removeLayer(String layerName) {
		imagePanel.removeLayer(layerName);
	}
	
	public void setCoord(CoordenadaSoftware coord) {
		lblCoord.setText("X: " + coord.getMatrizX() + "; Y: " + coord.getMatrizY());		
	}


	public void clearLayers() {		
		imagePanel.clearLayers();
	}
		
	
}
