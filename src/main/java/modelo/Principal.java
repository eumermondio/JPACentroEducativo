package modelo;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frmGestinDeCentros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmGestinDeCentros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestinDeCentros = new JFrame();
		frmGestinDeCentros.setTitle("Gestión de centros educativos");
		frmGestinDeCentros.setBounds(100, 100, 450, 300);
		frmGestinDeCentros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmGestinDeCentros.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Gestión");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cursos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog();
				// El usuario no puede redimensionar el diálogo
				dialogo.setResizable(true);
				// título del díalogo
				dialogo.setTitle("Cursos");
				// Introducimos el panel creado sobre el diálogo
				dialogo.setContentPane(new PanelAInsertarEnJDialog(0));
				// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que
				// deben y el lugar adecuado
				dialogo.pack();
				// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
				dialogo.setModal(true);
				// Centro el di�logo en pantalla
				dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - dialogo.getWidth() / 2,
						(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - dialogo.getHeight() / 2);
				// Muestro el di�logo en pantalla
				dialogo.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JToolBar toolBar = new JToolBar();
		frmGestinDeCentros.getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton btnCursos = new JButton("Cursos");
		btnCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog();
				// El usuario no puede redimensionar el diálogo
				dialogo.setResizable(true);
				// título del díalogo
				dialogo.setTitle("Cursos");
				// Introducimos el panel creado sobre el diálogo
				dialogo.setContentPane(new PanelAInsertarEnJDialog(0));
				// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que
				// deben y el lugar adecuado
				dialogo.pack();
				// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
				dialogo.setModal(true);
				// Centro el di�logo en pantalla
				dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - dialogo.getWidth() / 2,
						(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - dialogo.getHeight() / 2);
				// Muestro el di�logo en pantalla
				dialogo.setVisible(true);
			}
		});
		toolBar.add(btnCursos);
	}

}
