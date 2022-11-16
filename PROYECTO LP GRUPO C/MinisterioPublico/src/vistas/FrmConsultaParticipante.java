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

@SuppressWarnings({ "serial", "unused" })
public class FrmConsultaParticipante extends JInternalFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JButton btnBuscar;
	private DefaultTableModel model; 
	private JLabel lblNumeroPedido;
	private JComboBox<Object> cboPedido;
	private JScrollPane scrollPane;
	
	private PedidoDAO pedDao;
	private ParticipanteDAO partDao;
	private PropuestaDAO propDao;
	private ApelacionDAO apelDao;
	private JLabel lblIdParticipante;
	private JTextArea txtS;
	private JComboBox<Object> cboParticipante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaParticipante frame = new FrmConsultaParticipante();
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
	public FrmConsultaParticipante() {
		setTitle("Consulta de participantes");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(326, 24, 89, 31);
		contentPane.add(btnBuscar);
		
		model = new DefaultTableModel();
		model.addColumn("ID PEDIDO");
		model.addColumn("ID PARTICIPANTE");
		model.addColumn("ENTIDAD");
		model.addColumn("RUC");
		model.addColumn("CORREO");
		model.addColumn("TELEFONO");
		model.addColumn("ESTADO");
		
		lblNumeroPedido = new JLabel("Numero de Pedido:");
		lblNumeroPedido.setBounds(10, 32, 138, 14);
		contentPane.add(lblNumeroPedido);
		
		cboPedido = new JComboBox<Object>();
		cboPedido.addMouseListener(this);
		cboPedido.setBounds(141, 28, 138, 22);
		contentPane.add(cboPedido);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 654, 249);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		lblIdParticipante = new JLabel("ID Participante");
		lblIdParticipante.setBounds(10, 67, 101, 14);
		contentPane.add(lblIdParticipante);
		
		cboParticipante = new JComboBox<Object>();
		cboParticipante.setBounds(141, 63, 138, 22);
		contentPane.add(cboParticipante);
		
		
		partDao= new ParticipanteDAO();
		pedDao = new PedidoDAO();
		propDao = new PropuestaDAO();
		apelDao = new ApelacionDAO();
		
		
		arranque();
		
	}
	private void arranque() {
		
		cargarCboPedido();
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == cboPedido) {
			mouseClickedCboPedido(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedCboPedido(MouseEvent e) {
		cargarCboParticipante();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultaParticipante();
	}
	
	private void cargarCboPedido() {
		
		ArrayList<Pedido> list = pedDao.listarPedido();
		
		cboPedido.removeAllItems();
		cboPedido.addItem("SELECCIONE..");
		
		for (Pedido ped: list) {
			
			cboPedido.addItem(ped.getCodigo());
			
		}
	}
	private void cargarCboParticipante() {
		
		String idPedido = cboPedido.getSelectedItem().toString();
		
		ArrayList<Participante> list = partDao.buscarXPedido(idPedido);
		
		cboParticipante.removeAllItems();
		cboParticipante.addItem("SELECCIONE..");
		
		for (Participante part: list) {
			
			cboParticipante.addItem(part.getCodParticipante());
			
		}
	}
	
	private void consultaParticipante() {
		
		String idParticipante = cboParticipante.getSelectedItem().toString();
		
		ArrayList<Participante> listPart = partDao.buscarXIdParticipante(idParticipante);
		
		ArrayList<Pedido> listPed = pedDao.listarPedido();
		
		ArrayList<Propuesta> listProp = propDao.listarPropuestas();
		
		for (Participante part : listPart) {
			for (Propuesta prop : listProp) {
				
				if(part.getCodParticipante().equals(prop.getCodParticipante())) {
					Tool.imprimir(txtS,"PARTICIPANTE: " +  part.getEntidad() );
					Tool.imprimir(txtS,"ID PARTICIPANTE: " +  part.getCodParticipante() );
					Tool.imprimir(txtS,"RUC: " +  part.getRuc());
					Tool.imprimir(txtS,"TELEFONO: " +  part.getTelefono() );
					Tool.imprimir(txtS,"============================================");
					Tool.imprimir(txtS,"PEDIDO AL QUE PARTICIPA: " +  part.getCodPedido() );
					Tool.imprimir(txtS,"PARTICIPANTE: " +  part.getEntidad() );
					Tool.imprimir(txtS,"PARTICIPANTE: " +  part.getEntidad() );
				}
				
			}
		}

	}	
	
	
}
