package vistas;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class FrmApelacion extends JInternalFrame {

	private JPanel contentPane;
	private JLabel lblPropuesta;
	private JLabel lblFechaApelacion;
	private JLabel lblDescripcion;
	private JLabel lblEstado;
	private JComboBox <Object> cboPropuesta;
	private JDateChooser dcFechaApelacion;
	private JEditorPane txtDescripcion;
	private JComboBox <Object> cboEstado;
	private JButton btnRegistrar;
	private JButton btnGuardar;
	private JScrollPane spDescripcion;
	private JTextField txtCodigo;
	private JLabel lblCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmApelacion frame = new FrmApelacion();
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
	public FrmApelacion() {
		setTitle("Apelacion");
		setBounds(100, 100, 687, 409);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPropuesta = new JLabel("ID Propuesta:");
		lblPropuesta.setBounds(10, 11, 140, 14);
		contentPane.add(lblPropuesta);
		
		lblFechaApelacion = new JLabel("Fecha de la Apelaci�n:");
		lblFechaApelacion.setBounds(160, 63, 140, 14);
		contentPane.add(lblFechaApelacion);
		
		lblDescripcion = new JLabel("Descripci�n:");
		lblDescripcion.setBounds(309, 11, 109, 14);
		contentPane.add(lblDescripcion);
		
		lblEstado = new JLabel("Estado de Apelaci�n:");
		lblEstado.setBounds(160, 12, 123, 14);
		contentPane.add(lblEstado);
		
		cboPropuesta = new JComboBox<Object>();
		cboPropuesta.setBounds(10, 31, 123, 22);
		contentPane.add(cboPropuesta);
		
		dcFechaApelacion = new JDateChooser();
		dcFechaApelacion.setBounds(160, 83, 123, 20);
		contentPane.add(dcFechaApelacion);
		
		spDescripcion = new JScrollPane();
		spDescripcion.setBounds(310, 36, 338, 323);
		getContentPane().add(spDescripcion);
		
		
		txtDescripcion = new JEditorPane();
		spDescripcion.setViewportView(txtDescripcion);
	
		cboEstado = new JComboBox<Object>();
		cboEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccionar", "En Proceso",  "Aceptado", "Rechazado"}));
		cboEstado.setBounds(160, 30, 123, 22);
		contentPane.add(cboEstado);
		
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(10, 234, 109, 23);
		getContentPane().add(btnRegistrar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(142, 234, 109, 23);
		getContentPane().add(btnGuardar);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 83, 123, 20);
		contentPane.add(txtCodigo);
		
		lblCodigo = new JLabel("ID Apelacion:");
		lblCodigo.setBounds(10, 63, 140, 14);
		contentPane.add(lblCodigo);
	}
}
