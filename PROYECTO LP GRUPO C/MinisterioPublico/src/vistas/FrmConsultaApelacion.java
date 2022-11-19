package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import clases.*;

import mantenimiento.*;
import utils.Tool;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings({ "serial", "unused" })
public class FrmConsultaApelacion extends JInternalFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JButton btnConsultar;
	private DefaultTableModel model; 
	
	private PedidoDAO pedDao;
	private ParticipanteDAO partDao;
	private PropuestaDAO propDao;
	private ApelacionDAO apelDao;
	private JLabel lblIdParticipante;
	private JComboBox<Object> cboApelacion;
	private JTextArea txtCuadro1;
	private JTextArea txtCuadro2;
	private JLabel lblPedido;
	private JLabel lblApelacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaApelacion frame = new FrmConsultaApelacion();
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
	public FrmConsultaApelacion() {
		setTitle("Consulta de participantes");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(345, 22, 89, 22);
		contentPane.add(btnConsultar);
		
		lblIdParticipante = new JLabel("ID Apelacion :");
		lblIdParticipante.setBounds(49, 26, 89, 14);
		contentPane.add(lblIdParticipante);
		
		cboApelacion = new JComboBox<Object>();
		cboApelacion.setBounds(143, 22, 138, 22);
		contentPane.add(cboApelacion);
		
		txtCuadro2 = new JTextArea();
		txtCuadro2.setBounds(20, 294, 595, 138);
		contentPane.add(txtCuadro2);
		
		txtCuadro1 = new JTextArea();
		txtCuadro1.setBounds(20, 94, 595, 164);
		contentPane.add(txtCuadro1);
		
		lblPedido = new JLabel("DESCRIPCION DE LA APELACION:");
		lblPedido.setBounds(20, 269, 233, 14);
		contentPane.add(lblPedido);
		
		lblApelacion = new JLabel("DATOS GENERALES: ");
		lblApelacion.setBounds(20, 69, 233, 14);
		contentPane.add(lblApelacion);
		
		
		partDao= new ParticipanteDAO();
		pedDao = new PedidoDAO();
		propDao = new PropuestaDAO();
		apelDao = new ApelacionDAO();
		
		
		arranque();
		
	}
	private void arranque() {
		
		cargarCboApelacion();
		cboApelacion.setEditable(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultaApelacion();
	}
	
	
	//METODOS DE ENTRADA
	
	private String leerCboApelacion() {
		String res = null;
		res = (String) cboApelacion.getSelectedItem();
		return res;
		
	}
	
	
	//METODOS ADICIONALES
	
	private void cargarCboApelacion() {
				
ArrayList<Apelacion> list = apelDao.listarApelacion();
		
		cboApelacion.removeAllItems();
		cboApelacion.addItem("SELECCIONE...");
		
		for (Apelacion apel : list) {
			
			cboApelacion.addItem(apel.getCodApelacion());
			
		}
	}
	
	private void consultaApelacion() {
		
		String idApelacion = leerCboApelacion();
		Apelacion ape = apelDao.buscarXIdApelacion(idApelacion);
		
		cargarApelacion(ape);
		
		String idPropuesta = ape.getCodPropuesta();
		Propuesta prop = propDao.buscarXIdPropuesta(idPropuesta);
		
		cargarPropuesta(prop);  
		
		//Pedido ped = pedDao.buscarXIdPropuesta(id);
		
		//cargarPedido(ped);
		

	}	

	
	private void cargarParticipante(Participante part) {
		
		//txtCuadro1.setText("");
		
		if (part == null){
			return;
		}else {
			
			Tool.imprimir(txtCuadro1,"PARTICIPANTE	: " +  part.getEntidad() );
			Tool.imprimir(txtCuadro1,"ID	: " +  part.getCodParticipante() );
			Tool.imprimir(txtCuadro1,"RUC	: " +  part.getRuc());
			Tool.imprimir(txtCuadro1,"TELEFONO	: " +  part.getTelefono() );
			Tool.imprimir(txtCuadro1,"ESTADO	: " + part.getEstado());
		}
		
	}
	
	private void cargarPedido(Pedido ped) {

		//txtCuadro1.setText("");
		
		if(ped == null) {
			return;
		}else {
			
			Tool.imprimir(txtCuadro1,"PEDIDO	  :" +  ped.getEntidad() );
			Tool.imprimir(txtCuadro1,"DESCRIPCION :" +  ped.getDescripcion() );
			Tool.imprimir(txtCuadro1,"ID	 :" +  ped.getCodigo());
			Tool.imprimir(txtCuadro1,"RUC	:" +  ped.getRuc());
			Tool.imprimir(txtCuadro1,"ESTADO	:" + ped.getEstado());
		}
		
	}
	
	private void cargarApelacion(Apelacion apel) {
		
		txtCuadro1.setText("");
		txtCuadro2.setText("");
		if (apel == null) {
			return;
		} else {
			
			Tool.imprimir(txtCuadro1,"ID APELACION : " +  apel.getCodApelacion() );
			Tool.imprimir(txtCuadro1,"FECHA : " +  apel.getFecha() );
			Tool.imprimir(txtCuadro1,"ESTADO : " +  apel.getEstado());
			Tool.imprimir(txtCuadro2,"DESCRIPCION : " +  apel.getDescripcion());
			Tool.imprimir(txtCuadro1," ");
		}
		
	}

	private void cargarPropuesta(Propuesta prop) {
		

		//txtCuadro1.setText("");
		
		if (prop == null) {
			return;
		}else {
			
			Tool.imprimir(txtCuadro1,"ID PROPUESTA : " +  prop.getCodPropuesta() );
			Tool.imprimir(txtCuadro1,"FECHA : " +  prop.getFecha() );
			Tool.imprimir(txtCuadro1,"ESTADO : " +  prop.getEstado());
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}