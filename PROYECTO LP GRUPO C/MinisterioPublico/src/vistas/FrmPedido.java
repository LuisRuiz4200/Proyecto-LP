package vistas;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import mantenimiento.*;
import utils.Tool;
import clases.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmPedido extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtIdPedido;
	private JTextField txtEntidad;
	private JLabel lblNroPedido;
	private JLabel lblEntidad;
	private JLabel lblTipo;
	private JLabel lblObjeto;
	private JComboBox<Object> cboTipo;
	private JEditorPane txtDescripcion;
	private JLabel lblDescripcion;
	private JLabel lblFecha;
	private JTable tbContratacion;
	private JScrollPane scrollPane;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JDateChooser dcFecha; 
	private DefaultTableModel model;
	private JComboBox <Object>cboEstado;
	private JComboBox <Object>cboObjeto;
	
	private TipoPedidoDAO tipPedDao;
	private ObjetoPedidoDAO objPedDao;
	private PedidoDAO pedDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPedido frame = new FrmPedido();
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
	public FrmPedido() {
		setTitle("Pedido");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		
		txtIdPedido = new JTextField();
		txtIdPedido.setEditable(false);
		txtIdPedido.setBounds(167, 11, 117, 20);
		contentPane.add(txtIdPedido);
		txtIdPedido.setColumns(10);
		
		txtEntidad = new JTextField();
		txtEntidad.setBounds(167, 42, 117, 20);
		contentPane.add(txtEntidad);
		txtEntidad.setColumns(10);
		
		lblNroPedido = new JLabel("ID Pedido:");
		lblNroPedido.setBounds(10, 14, 147, 14);
		contentPane.add(lblNroPedido);
		
		lblEntidad = new JLabel("Entidad Solicitante:");
		lblEntidad.setBounds(10, 44, 147, 14);
		contentPane.add(lblEntidad);
		
		lblTipo = new JLabel("Tipo de Contratacion:");
		lblTipo.setBounds(10, 76, 147, 14);
		contentPane.add(lblTipo);
		
		lblObjeto = new JLabel("Objeto de Contratacion:");
		lblObjeto.setBounds(10, 111, 147, 14);
		contentPane.add(lblObjeto);
		
		cboTipo = new JComboBox<Object>();
		cboTipo.setBounds(167, 72, 117, 22);
		contentPane.add(cboTipo);
		
		txtDescripcion = new JEditorPane();
		txtDescripcion.setBounds(318, 64, 279, 49);
		contentPane.add(txtDescripcion);
		
		lblDescripcion = new JLabel("Descripcion de \r\nRequrimiento:");
		lblDescripcion.setBounds(318, 42, 254, 20);
		contentPane.add(lblDescripcion);
		
		lblFecha = new JLabel("Fecha Inicio: ");
		lblFecha.setBounds(318, 14, 75, 14);
		contentPane.add(lblFecha);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 727, 198);
		contentPane.add(scrollPane);
		
		tbContratacion = new JTable();
		scrollPane.setViewportView(tbContratacion);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(480, 120, 117, 23);
		contentPane.add(btnGuardar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(610, 120, 108, 23);
		contentPane.add(btnModificar);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(403, 11, 108, 20);
		contentPane.add(dcFecha);
		
		model = new DefaultTableModel();
		model.addColumn("ID PEDIDO");
		model.addColumn("ENTIDAD");
		model.addColumn("TIPO");
		model.addColumn("OBJETO");
		model.addColumn("DESCRIPCION");
		model.addColumn("FECHA");
	
		tbContratacion.setModel(model);
		
		cboEstado = new JComboBox<Object>();
		cboEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"REGISTRADO", "EN PROCESO ", "DESIERTO", "CONCLUIDO"}));
		cboEstado.setBounds(601, 11, 102, 20);
		contentPane.add(cboEstado);
		
		cboObjeto = new JComboBox<Object>();
		cboObjeto.setBounds(167, 107, 117, 22);
		contentPane.add(cboObjeto);
		
		tipPedDao = new TipoPedidoDAO();
		objPedDao = new ObjetoPedidoDAO();
		pedDao = new PedidoDAO();
		
		arranque();
		
	}
	
	
	
	private void arranque() {
		
		cargarTipoPedido();
		cargarObjetoPedido();
		correlativo();
		cargarTabla();
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		
		String idPedido = leerIdPedido();
		String entidad = leerEntidad();
		int idTipoPedido = leerTipo();
		int idObjetoPedido = leerObjeto();
		String descripcion  = leerDescripcion();
		String fecha = leerFecha();
		String estado = leerEstado();
		
		if (idPedido==null ||entidad==null ||idTipoPedido==-1 ||
				idObjetoPedido==-1 ||descripcion==null 
				||fecha==null || estado ==null) {
			return;
		}else {
			
			Pedido ped = new Pedido(idPedido,entidad,
					idTipoPedido,idObjetoPedido,descripcion,
					fecha,estado);
			
			int ok = pedDao.registrarPedido(ped);
		
			if(ok == 0){
				Tool.mensajeError(this, "Error de registro");
			}else {
				Tool.mensajeExito(this, "Pedido registrado!");
			}
		}
		
	}
	
	

	protected void actionPerformedBtnModificar(ActionEvent e) {
		
	}
	
	
	//METODOS DE ENTRADA 
	
	private String leerIdPedido() {
		String res=null;
		
		res = txtIdPedido.getText().trim();
		
		return res;
	}

	private String leerEntidad() {
		String res=null;
		
		res = txtEntidad.getText().trim();
		
		return res;
	}

	private int leerTipo() {
		int res=-1;
		
		res = cboTipo.getSelectedIndex();
		
		return res;
	}

	private int leerObjeto() {
		int res=-1;
		
		res = cboObjeto.getSelectedIndex();
		
		return res;
	}

	private String leerDescripcion() {
		String res=null;
		
		res = txtDescripcion.getText().trim();
		
		return res;
	}

	private String leerFecha() {
		String res=null;
		
		res = Tool.sdf.format(dcFecha.getDate()).toString();
		
		
		
		return res;
	}

	private String leerEstado() {
		String res=null;
		
		res = cboEstado.getSelectedItem().toString();
		
		return res;
	}
	
	//METODOS ADICIONALES
	
	private void cargarTipoPedido() {
		
		ArrayList<TipoPedido> list = tipPedDao.listarTipoPedido();
		
		cboTipo.removeAllItems();
		cboTipo.addItem("SELECCIONE..");
		
		for (TipoPedido tipPed : list) {
			
			cboTipo.addItem(tipPed.getIdTipoPedido() + ". " + tipPed.getDesTipoPedido());
			
		}
		
	}
	private void cargarObjetoPedido() {
		
		ArrayList<ObjetoPedido> list = objPedDao.listarObjetoPedido();
		
		cboObjeto.removeAllItems();
		cboObjeto.addItem("SELECCIONE..");
		
		for (ObjetoPedido objPed : list) {
			
			cboObjeto.addItem(objPed.getIdObjetoPedido() + ". " + objPed.getDesObjetoPedido());
			
		}
		
	}
	
	private void correlativo () {
		
		ArrayList<Pedido> list = pedDao.listarPedido();
		
		if (list.size() == 0) {
			txtIdPedido.setText("1");
		}else {
			String idPedido=list.get(list.size()-1).getCodigo();
			
			int correlativo = Integer.parseInt(idPedido)+1;
			
			txtIdPedido.setText("" + correlativo);
			
		}
		
	}
	
	private void cargarTabla() {
		
		ArrayList<Pedido>list =pedDao.listarPedido();
		
		model.setRowCount(0);
		
		for (Pedido p : list) {

			Object [] ped = {
				p.getCodigo(),
				p.getEntidad(),
				p.getTipo(),
				p.getObjeto(),
				p.getDescripcion(),
				p.getFecha()
			};
			
			model.addRow(ped);
			
		}
		
		
		
	}
	
}
