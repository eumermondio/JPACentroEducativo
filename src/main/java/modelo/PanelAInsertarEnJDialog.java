package modelo;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import modelo.controladores.ControladorCurso;
import modelo.vista.GestionCurso;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAInsertarEnJDialog extends JPanel {
	public static JButton btnNewButton;
	public static JButton btnNewButton_1;
	public static JButton btnNewButton_2;
	public static JButton btnNewButton_3;
	public static JButton btnNewButton_4;
	public static JButton btnNewButton_5;
	public static JButton btnNewButton_6;

	/**
	 * Create the panel.
	 */
	public PanelAInsertarEnJDialog(int ent) {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					GestionCurso.mostrarCurso(ControladorCurso.devolverPrimero());
				}
			}
		});
		toolBar.add(btnNewButton);

		btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					GestionCurso.mostrarCurso(
							ControladorCurso.devolverAnterior(Integer.parseInt(GestionCurso.jtfId.getText())));
				}
			}
		});
		// btnNewButton_1.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/previous.png")));
		toolBar.add(btnNewButton_1);

		btnNewButton_2 = new JButton(">");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					GestionCurso.mostrarCurso(
							ControladorCurso.devolverSiguiente(Integer.parseInt(GestionCurso.jtfId.getText())));
				}
			}
		});
		// btnNewButton_2.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/next.png")));
		toolBar.add(btnNewButton_2);

		btnNewButton_3 = new JButton(">>");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					GestionCurso.mostrarCurso(ControladorCurso.devolverUltimo());
				}
			}
		});
		// btnNewButton_3.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/gotoend.png")));
		toolBar.add(btnNewButton_3);

		btnNewButton_4 = new JButton("Nuevo");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					GestionCurso.jtfId.setText("0");
					GestionCurso.jtfDesc.setText("");
				}
			}
		});
		// btnNewButton_4.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/nuevo.png")));
		toolBar.add(btnNewButton_4);

		btnNewButton_5 = new JButton("Guardar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					if (GestionCurso.jtfId.getText() != "0") {
						Curso c = new Curso();
						c.setId(Integer.parseInt(GestionCurso.jtfId.getText()));
						c.setDescripcion(GestionCurso.jtfDesc.getText());
						if (ControladorCurso.modificacionEntidad(c)) {
							JOptionPane.showMessageDialog(null, "Actualización o inserción correcta",
									"Gestion de curso", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						Curso c = new Curso();
						c.setId(Integer.parseInt(GestionCurso.jtfId.getText()));
						c.setDescripcion(GestionCurso.jtfDesc.getText());
						if (ControladorCurso.creacion(c)) {
							JOptionPane.showMessageDialog(null, "Actualización o inserción correcta",
									"Gestion de curso", JOptionPane.INFORMATION_MESSAGE);
						}
					}

				}
				GestionCurso.mostrarCurso(ControladorCurso.devolverUltimo());
			}
		});
		toolBar.add(btnNewButton_5);

		btnNewButton_6 = new JButton("Eliminar");
		btnNewButton_6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// yes = 0 no = 1
				if (ent == 0) {
					if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?", "Gestión de cursos",
							JOptionPane.YES_NO_OPTION) == 0) {
						Curso c = new Curso();
						c.setId(Integer.parseInt(GestionCurso.jtfId.getText()));
						c.setDescripcion(GestionCurso.jtfDesc.getText());
						if (ControladorCurso.eliminacion(c)) {
							JOptionPane.showMessageDialog(null, "Borrado correcto", "Gestion de cursos",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

				}
				GestionCurso.mostrarCurso(ControladorCurso.devolverUltimo());
			}
		});
		toolBar.add(btnNewButton_6);

		if (ent == 0) {
			add(GestionCurso.getInstance(), BorderLayout.CENTER);
		}

	}

}
