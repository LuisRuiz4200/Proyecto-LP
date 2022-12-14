package vistas;


import javax.swing.*;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class FrmActaPropuesta extends JInternalFrame {
	private JLabel lblCodigo;
	private JComboBox <Object>cboPropuesta;
	private JLabel lblPropuesta;
	private JTextField txtCodigo;
	private JDateChooser dcFecha;
	private JLabel lblFecha;
	private JLabel lblCircunstancia;
	private JEditorPane txtDocumento;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JComboBox <Object>cboEstado;
	private JLabel lblEstado;
	
	
	
	public static void main (String [] args) {
		
		FrmActaPropuesta form = new FrmActaPropuesta();
		form.setVisible(true);
		
	}
	
	public FrmActaPropuesta () {
		
		setTitle("Acta de propuesta");
		setBounds (100,100,640,426);
		this.getContentPane().setLayout(null);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(280,50,119,20);
		getContentPane().add(dcFecha);
		
		lblCodigo = new JLabel("ID Acta");
		lblCodigo.setBounds(22, 23, 46, 14);
		getContentPane().add(lblCodigo);
		
		cboPropuesta = new JComboBox<Object>();
		cboPropuesta.setBounds(151, 48, 102, 22);
		getContentPane().add(cboPropuesta);
		
		lblPropuesta = new JLabel("ID Propuesta");
		lblPropuesta.setBounds(151, 23, 85, 14);
		getContentPane().add(lblPropuesta);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(22, 49, 102, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(280, 25, 46, 14);
		getContentPane().add(lblFecha);
		
		lblCircunstancia = new JLabel("Motivo / Circunstancia");
		lblCircunstancia.setBounds(22, 102, 137, 14);
		getContentPane().add(lblCircunstancia);
		
		txtDocumento = new JEditorPane();
		txtDocumento.setBounds(17, 130, 591, 209);
		getContentPane().add(txtDocumento);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(327, 350, 115, 23);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(452, 350, 115, 23);
		getContentPane().add(btnModificar);
		
		cboEstado = new JComboBox<Object>();
		cboEstado.setBounds(478, 43, 115, 32);
		getContentPane().add(cboEstado);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(479, 23, 65, 14);
		getContentPane().add(lblEstado);
		
	}
}
