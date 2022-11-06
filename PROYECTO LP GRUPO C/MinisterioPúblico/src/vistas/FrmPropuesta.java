package vistas;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class FrmPropuesta extends JInternalFrame {

	private JPanel contentPane;
	private JLabel lblPostor;
	private JLabel lblCompa�ia;
	private JLabel lblRuc;
	private JLabel lblDistrito;
	private JTextField txtPostor;
	private JTextField txtCompa�ia;
	private JTextField txtRuc;
	private JComboBox <Object>cboDistrito;
	private JButton btnGuardar;
	private JButton btnBuscar;
	private JLabel lblPropuestaTecnica;
	private JLabel lblPropuestaEconomica;
	private JTextArea txtPropuestaTecnica;
	private JScrollPane scrollPane;
	private JTextArea txtPropuestaEconomica;
	private JScrollPane scrollPane_1;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPropuesta frame = new FrmPropuesta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPropuesta() {
		setTitle("Propuesta");
		setBounds(100, 100, 690, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPostor = new JLabel("Nombre del Postor:");
		lblPostor.setBounds(10, 11, 140, 14);
		contentPane.add(lblPostor);
		
		lblCompa�ia = new JLabel("Compa��a:");
		lblCompa�ia.setBounds(10, 39, 87, 14);
		contentPane.add(lblCompa�ia);
		
		lblRuc = new JLabel("RUC:");
		lblRuc.setBounds(312, 39, 66, 14);
		contentPane.add(lblRuc);
		
		lblDistrito = new JLabel("Distrito:");
		lblDistrito.setBounds(312, 11, 87, 14);
		contentPane.add(lblDistrito);
		
		txtPostor = new JTextField();
		txtPostor.setBounds(135, 8, 123, 20);
		contentPane.add(txtPostor);
		txtPostor.setColumns(10);
		
		txtCompa�ia = new JTextField();
		txtCompa�ia.setColumns(10);
		txtCompa�ia.setBounds(135, 36, 123, 20);
		contentPane.add(txtCompa�ia);
		
		txtRuc = new JTextField();
		txtRuc.setBounds(432, 36, 123, 20);
		contentPane.add(txtRuc);
		
		cboDistrito = new JComboBox<Object>();
		cboDistrito.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccionar", "Ancón", "Ate Vitarte", "Barranco", "Breña", "Carabayllo", "Chaclacayo", "Chorrillos", "Cieneguilla", "Comas", "El Agustino", "Independencia", "Jesús María", "La Molina", "La Victoria", "Lima", "Lince", "Los Olivos", "Lurigancho", "Lurín", "Magdalena del Mar", "Miraflores", "Pachacamac", "Pucusana", "Pueblo Libre", "Puente Piedra", "Punta Hermosa", "Punta Negra", "Rímac", "San Bartolo", "San Borja", "San Isidro", "San Juan de Lurigancho", "San Juan de Miraflores", "San Luis", "San Martín de Porres", "San Miguel", "Santa Anita", "Santa María del Mar", "Santa Rosa", "Santiago de Surco", "Surquillo", "Villa El Salvador", "Villa María del Triunfo"}));
		cboDistrito.setBounds(432, 7, 123, 22);
		contentPane.add(cboDistrito);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(575, 22, 89, 49);
		contentPane.add(btnGuardar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(575, 82, 89, 49);
		contentPane.add(btnBuscar);
		
		lblPropuestaTecnica = new JLabel("Propuesta T�cnica:");
		lblPropuestaTecnica.setBounds(10, 72, 128, 14);
		contentPane.add(lblPropuestaTecnica);
		
		lblPropuestaEconomica = new JLabel("Propuesta Econ�mica:");
		lblPropuestaEconomica.setBounds(312, 72, 128, 14);
		contentPane.add(lblPropuestaEconomica);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 245, 49);
		contentPane.add(scrollPane);
		
		txtPropuestaTecnica = new JTextArea();
		scrollPane.setViewportView(txtPropuestaTecnica);
		txtPropuestaTecnica.setLineWrap(true);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(312, 98, 243, 47);
		contentPane.add(scrollPane_1);
		
		txtPropuestaEconomica = new JTextArea();
		scrollPane_1.setViewportView(txtPropuestaEconomica);
		txtPropuestaEconomica.setLineWrap(true);
		
		model = new DefaultTableModel();
		// crear columnas de la tabla
		model.addColumn("Nombre Postor");
		model.addColumn("Compa�ia");
		model.addColumn("Distrito");
		model.addColumn("RUC");
		model.addColumn("Prop. T�cnica");
		model.addColumn("Prop. Econ�mica");
		model.addColumn("Estado");
	}
}
