package vistas;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class FrmParticipante extends JInternalFrame{
	private JTextField txtEmpresa;
	private JLabel lblEmpresa;
	private JTextField txtRuc;
	private JLabel lblRuc;
	private JTextField txtTelefono;
	private JLabel lblTelefono;
	private JTextField txtCorreo;
	private JLabel lblCorreo;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JComboBox <Object> cboCodContratacion;
	private JLabel lblPedido;
	private JTextField txtCodigo;
	private JLabel lblCodigo;
	private JComboBox<Object> cboEstado;
	private JLabel lblEstado;
	
	
	
	public static void main (String[] args) {
		FrmParticipante parti = new FrmParticipante();
		parti.setVisible(true);
	}
	
	public FrmParticipante() {
		
		setTitle("Participantes");
		setBounds(100,100,773,422);
		
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.lightGray);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setColumns(10);
		txtEmpresa.setBounds(21, 69, 177, 20);
		getContentPane().add(txtEmpresa);
		
		lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(22, 54, 67, 14);
		getContentPane().add(lblEmpresa);
		
		txtRuc = new JTextField();
		txtRuc.setColumns(10);
		txtRuc.setBounds(223, 69, 114, 20);
		getContentPane().add(txtRuc);
		
		lblRuc = new JLabel("RUC");
		lblRuc.setBounds(224, 54, 92, 14);
		getContentPane().add(lblRuc);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(21, 115, 114, 20);
		getContentPane().add(txtTelefono);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(21, 100, 92, 14);
		getContentPane().add(lblTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(181, 115, 204, 20);
		getContentPane().add(txtCorreo);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(182, 100, 92, 14);
		getContentPane().add(lblCorreo);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(422, 114, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(626, 114, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(527, 114, 89, 23);
		getContentPane().add(btnModificar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 726, 219);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CONTRATACION");
		modelo.addColumn("NOMBRES Y APELLIDOS");
		modelo.addColumn("DNI");
		modelo.addColumn("EMPRESA");
		modelo.addColumn("RUC");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("CORREO");
		table.setModel(modelo);
		
		cboCodContratacion = new JComboBox<Object>();
		cboCodContratacion.setModel(new DefaultComboBoxModel<Object>(new String[] {}));
		cboCodContratacion.setBounds(21, 26, 106, 22);
		getContentPane().add(cboCodContratacion);
		
		lblPedido = new JLabel("ID. Pedido");
		lblPedido.setBounds(22, 11, 139, 14);
		getContentPane().add(lblPedido);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(158, 26, 114, 20);
		getContentPane().add(txtCodigo);
		
		lblCodigo = new JLabel("Cod. Participante");
		lblCodigo.setBounds(158, 11, 116, 14);
		getContentPane().add(lblCodigo);
		
		cboEstado = new JComboBox<Object>(new Object[]{});
		cboEstado.setBounds(422, 26, 106, 20);
		getContentPane().add(cboEstado);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(423, 11, 67, 14);
		getContentPane().add(lblEstado);
	}
}
