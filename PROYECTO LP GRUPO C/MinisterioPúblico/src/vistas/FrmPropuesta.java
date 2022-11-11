package vistas;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class FrmPropuesta extends JInternalFrame {

	private JPanel contentPane;
	private JLabel lblParticipante;
	private JComboBox <Object> cboParticipante;
	private JButton btnGuardar;
	private JLabel lblPropuestaTecnica;
	private JLabel lblPropuestaEcono;
	private JLabel lblPedido;
	private JComboBox<Object> cboPedido;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JLabel lblNumeroPostulacion;
	private JTextField textField;
	private JLabel lblEstado;
	private JComboBox<Object> cboEstado;
	private DefaultTableModel model;
	private JEditorPane txtPropTecnica;
	private JEditorPane txtPropEconomica;
	private JButton btnBuscarParticipante;
	private JDateChooser dateChooser;
	private JLabel lblFechaProp;
	
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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		lblParticipante = new JLabel("ID participante:");
		lblParticipante.setBounds(10, 39, 125, 14);
		contentPane.add(lblParticipante);
		
		cboParticipante = new JComboBox <Object>();
		cboParticipante.setBounds(145, 35, 115, 22);
		contentPane.add(cboParticipante);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(575, 70, 89, 22);
		contentPane.add(btnGuardar);
		
		lblPropuestaTecnica = new JLabel("Propuesta Tecnica:");
		lblPropuestaTecnica.setBounds(10, 105, 125, 14);
		contentPane.add(lblPropuestaTecnica);
		
		lblPropuestaEcono = new JLabel("Propuesta Economica:");
		lblPropuestaEcono.setBounds(358, 103, 128, 14);
		contentPane.add(lblPropuestaEcono);
		
		// crear columnas de la tabla
		// Instanciar un objeto para la estructura de la tabla
		model = new DefaultTableModel();
		model.addColumn("Nombre Postor");
		model.addColumn("Compañia");
		model.addColumn("Distrito");
		model.addColumn("RUC");
		model.addColumn("Prop. Técnica");
		model.addColumn("Prop. Económica");
		model.addColumn("Estado");
		
		lblPedido = new JLabel("Nro de Pedido");
		lblPedido.setBounds(10, 11, 119, 14);
		contentPane.add(lblPedido);
		
		cboPedido = new JComboBox<Object>();
		cboPedido.setBounds(145, 7, 115, 22);
		contentPane.add(cboPedido);
		
		rdbtnNewRadioButton = new JRadioButton("SI");
		rdbtnNewRadioButton.setBounds(155, 99, 46, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("NO");
		rdbtnNewRadioButton_1.setBounds(214, 99, 46, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("SI");
		rdbtnNewRadioButton_2.setBounds(503, 99, 46, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("NO");
		rdbtnNewRadioButton_3.setBounds(562, 99, 46, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		lblNumeroPostulacion = new JLabel("Numero de postulacion:");
		lblNumeroPostulacion.setBounds(10, 67, 135, 14);
		contentPane.add(lblNumeroPostulacion);
		
		textField = new JTextField();
		textField.setBounds(145, 64, 105, 20);
		contentPane.add(textField);
		
		lblEstado = new JLabel("ESTADO:");
		lblEstado.setBounds(388, 11, 80, 14);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox<Object>();
		cboEstado.setBounds(482, 7, 105, 22);
		contentPane.add(cboEstado);
		
		txtPropTecnica = new JEditorPane();
		txtPropTecnica.setBounds(10, 130, 306, 221);
		contentPane.add(txtPropTecnica);
		
		txtPropEconomica = new JEditorPane();
		txtPropEconomica.setBounds(358, 128, 306, 221);
		contentPane.add(txtPropEconomica);
		
		btnBuscarParticipante = new JButton("Buscar ");
		btnBuscarParticipante.setBounds(280, 37, 80, 22);
		contentPane.add(btnBuscarParticipante);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(482, 37, 126, 20);
		contentPane.add(dateChooser);
		
		lblFechaProp = new JLabel("FECHA:");
		lblFechaProp.setBounds(388, 39, 53, 14);
		contentPane.add(lblFechaProp);
	}
}
