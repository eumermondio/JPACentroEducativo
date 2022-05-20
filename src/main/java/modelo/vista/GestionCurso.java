package modelo.vista;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import modelo.Curso;
import modelo.PanelAInsertarEnJDialog;
import modelo.controladores.ControladorCurso;

import java.awt.Insets;

public class GestionCurso extends JPanel {

	public static JTextField jtfId;
	private JLabel lblGestionDeFabricantes;
	private JLabel lblNewLabel;
	private JLabel lblCif;
	public static JTextField jtfDesc;

	// Variable que actúa como Singleton
	private static GestionCurso instance = null;

	// Método que devuelve el singleton
	public static GestionCurso getInstance() {
		if (instance == null) {
			instance = new GestionCurso();
		}
		return instance;
	}

	public GestionCurso() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		this.setLayout(gridBagLayout);

		lblGestionDeFabricantes = new JLabel("GESTION DE CURSOS");
		GridBagConstraints gbc_lblGestionDeFabricantes = new GridBagConstraints();
		gbc_lblGestionDeFabricantes.gridwidth = 2;
		gbc_lblGestionDeFabricantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestionDeFabricantes.gridx = 0;
		gbc_lblGestionDeFabricantes.gridy = 0;
		this.add(lblGestionDeFabricantes, gbc_lblGestionDeFabricantes);

		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		this.add(lblId, gbc_lblId);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		this.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		lblNewLabel = new JLabel("      ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);

		lblCif = new JLabel("Descripción:");
		GridBagConstraints gbc_lblCif = new GridBagConstraints();
		gbc_lblCif.anchor = GridBagConstraints.EAST;
		gbc_lblCif.insets = new Insets(0, 0, 5, 5);
		gbc_lblCif.gridx = 0;
		gbc_lblCif.gridy = 2;
		this.add(lblCif, gbc_lblCif);

		jtfDesc = new JTextField();
		GridBagConstraints gbc_jtfDesc = new GridBagConstraints();
		gbc_jtfDesc.insets = new Insets(5, 0, 5, 5);
		gbc_jtfDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDesc.gridx = 1;
		gbc_jtfDesc.gridy = 2;
		this.add(jtfDesc, gbc_jtfDesc);
		jtfDesc.setColumns(10);
		mostrarCurso(ControladorCurso.devolverPrimero());
	}

	/**
	 * 
	 * @param f
	 */
	public static void mostrarCurso(Curso c) {
		if (c != null) {
			jtfId.setText("" + c.getId());
			jtfDesc.setText(c.getDescripcion());
		}
		if (ControladorCurso.devolverAnterior(Integer.parseInt(jtfId.getText())) == null) {
			PanelAInsertarEnJDialog.btnNewButton.setEnabled(false);
			PanelAInsertarEnJDialog.btnNewButton_1.setEnabled(false);
		} else {
			PanelAInsertarEnJDialog.btnNewButton.setEnabled(true);
			PanelAInsertarEnJDialog.btnNewButton_1.setEnabled(true);
		}
		if (ControladorCurso.devolverSiguiente(Integer.parseInt(jtfId.getText())) == null) {
			PanelAInsertarEnJDialog.btnNewButton_2.setEnabled(false);
			PanelAInsertarEnJDialog.btnNewButton_3.setEnabled(false);
		} else {
			PanelAInsertarEnJDialog.btnNewButton_2.setEnabled(true);
			PanelAInsertarEnJDialog.btnNewButton_3.setEnabled(true);
		}
	}
}