package vistas;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import clases.Participante;
import clases.Pedido;
import clases.Propuesta;
import mantenimiento.ParticipanteDAO;
import mantenimiento.PedidoDAO;
import mantenimiento.PropuestaDAO;
import utils.Tool;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class FrmPropuesta extends JInternalFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JButton btnActualizar;
	private JLabel lblPropuestaTecnica;
	private JLabel lblPropuestaEcono;
	private JLabel lblPedido;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JLabel lblNumeroPostulacion;
	private JTextField txtPropuesta;
	private DefaultTableModel model;
	private JEditorPane txtPropTecnica;
	private JEditorPane txtPropEconomica;
	private JButton btnBuscar;
	private JDateChooser fechaProp;
	private JLabel lblFechaProp;
	private final ButtonGroup buttonGroupPT = new ButtonGroup();
	private final ButtonGroup buttonGroupPE = new ButtonGroup();

	private PropuestaDAO gProp = new PropuestaDAO();
	private PedidoDAO gPed = new PedidoDAO();
	private ParticipanteDAO gPart = new ParticipanteDAO();

	private JComboBox <Object>cboPedido;
	private JComboBox <Object>cboParticipante;
	private JButton btnRegistrar;
	private JPanel panelParticipante;
	private JTextField txtEntidadParti;
	private JLabel lblEntidad;
	private JLabel lblRuc;
	private JTextField txtTelefonoParti;
	private JLabel lblTelefono;
	private JTextField txtCorreoParti;
	private JLabel lblCorreo;
	private JTextField txtRucParti;
	private JLabel lblIdPedido;
	private JTextField txtEstado;
	private JLabel lblEstado_1;
	private JPanel panel;
	private JTextField txtRucPedido;
	private JLabel lblRucPedido;
	private JPanel panelPropuesta;
	private JButton btnNuevo;

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
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(604, 172, 102, 22);
		contentPane.add(btnActualizar);

		lblPropuestaTecnica = new JLabel("Propuesta Tecnica:");
		lblPropuestaTecnica.setBounds(10, 231, 125, 14);
		contentPane.add(lblPropuestaTecnica);

		lblPropuestaEcono = new JLabel("Propuesta Economica:");
		lblPropuestaEcono.setBounds(358, 229, 128, 14);
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

		rdbtnNewRadioButton = new JRadioButton("SI");
		buttonGroupPT.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(155, 225, 46, 23);
		contentPane.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("NO");
		buttonGroupPT.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(214, 225, 46, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("SI");
		buttonGroupPE.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(503, 225, 46, 23);
		contentPane.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_3 = new JRadioButton("NO");
		buttonGroupPE.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(562, 225, 46, 23);
		contentPane.add(rdbtnNewRadioButton_3);

		txtPropTecnica = new JEditorPane();
		txtPropTecnica.setBounds(10, 256, 306, 221);
		contentPane.add(txtPropTecnica);

		txtPropEconomica = new JEditorPane();
		txtPropEconomica.setBounds(358, 254, 306, 221);
		contentPane.add(txtPropEconomica);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(492, 172, 102, 22);
		contentPane.add(btnRegistrar);
		
		panelParticipante = new JPanel();
		panelParticipante.setLayout(null);
		panelParticipante.setOpaque(false);
		panelParticipante.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PARTICIPANTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParticipante.setBackground(SystemColor.menu);
		panelParticipante.setBounds(329, 0, 402, 158);
		contentPane.add(panelParticipante);
		
		txtEntidadParti = new JTextField();
		txtEntidadParti.setText("");
		txtEntidadParti.setColumns(10);
		txtEntidadParti.setBounds(10, 81, 177, 20);
		panelParticipante.add(txtEntidadParti);
		
		lblEntidad = new JLabel("Entidad");
		lblEntidad.setBounds(11, 66, 67, 14);
		panelParticipante.add(lblEntidad);
		
		lblRuc = new JLabel("RUC");
		lblRuc.setBounds(213, 66, 92, 14);
		panelParticipante.add(lblRuc);
		
		txtTelefonoParti = new JTextField();
		txtTelefonoParti.setText("");
		txtTelefonoParti.setColumns(10);
		txtTelefonoParti.setBounds(10, 127, 114, 20);
		panelParticipante.add(txtTelefonoParti);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 112, 92, 14);
		panelParticipante.add(lblTelefono);
		
		txtCorreoParti = new JTextField();
		txtCorreoParti.setText("");
		txtCorreoParti.setColumns(10);
		txtCorreoParti.setBounds(170, 127, 204, 20);
		panelParticipante.add(txtCorreoParti);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(171, 112, 92, 14);
		panelParticipante.add(lblCorreo);
		
		txtRucParti = new JTextField();
		txtRucParti.setText("");
		txtRucParti.setColumns(10);
		txtRucParti.setBounds(213, 81, 154, 20);
		panelParticipante.add(txtRucParti);
		
		cboParticipante = new JComboBox<Object>();
		cboParticipante.setBounds(8, 39, 115, 22);
		panelParticipante.add(cboParticipante);
				
		lblIdPedido = new JLabel("ID. Participante");
		lblIdPedido.setBounds(8, 21, 116, 14);
		panelParticipante.add(lblIdPedido);
				
		btnBuscar = new JButton("Buscar ");
		btnBuscar.setBounds(133, 29, 80, 29);
		panelParticipante.add(btnBuscar);
						
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "PEDIDO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setOpaque(false);
		panel.setBounds(10, 0, 306, 99);
		contentPane.add(panel);
		panel.setLayout(null);
								
		lblPedido = new JLabel("Nro de Pedido");
		lblPedido.setBounds(10, 21, 119, 14);
		panel.add(lblPedido);
								
		cboPedido = new JComboBox<Object>();
		cboPedido.setBounds(85, 17, 115, 22);
		panel.add(cboPedido);
										
		txtRucPedido = new JTextField();
		txtRucPedido.setColumns(10);
		txtRucPedido.setBounds(10, 64, 146, 20);
		panel.add(txtRucPedido);
										
		lblRucPedido = new JLabel("RUC pedido");
		lblRucPedido.setBounds(10, 46, 119, 14);
		panel.add(lblRucPedido);
																		
		panelPropuesta = new JPanel();
		panelPropuesta.setBounds(10, 108, 279, 110);
		contentPane.add(panelPropuesta);
		panelPropuesta.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PROPUESTA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPropuesta.setLayout(null);
																		
		lblNumeroPostulacion = new JLabel("ID Propuesta:");
		lblNumeroPostulacion.setBounds(10, 22, 67, 14);
		panelPropuesta.add(lblNumeroPostulacion);
																				
		txtPropuesta = new JTextField();
		txtPropuesta.setBounds(10, 36, 115, 20);
		panelPropuesta.add(txtPropuesta);
																						
		lblFechaProp = new JLabel("FECHA:");
		lblFechaProp.setBounds(10, 65, 53, 14);
		panelPropuesta.add(lblFechaProp);
																								
		fechaProp = new JDateChooser();
		fechaProp.setBounds(10, 79, 124, 20);
		panelPropuesta.add(fechaProp);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(157, 27, 106, 29);
		panelPropuesta.add(txtEstado);
		txtEstado.setText("REGISTRADO");
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		
		lblEstado_1 = new JLabel("ESTADO");
		lblEstado_1.setBounds(157, 13, 67, 14);
		panelPropuesta.add(lblEstado_1);
																										
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(339, 169, 89, 23);
		contentPane.add(btnNuevo);
		cboPedido.addItemListener(this);
		btnBuscar.addActionListener(this);

		cargarcboPedidos();
		correlativo();
	}

	private void correlativo() {

		ArrayList<Propuesta> list = gProp.listarPropuestas();


		@SuppressWarnings("resource")
		Formatter ft = new Formatter();
		
		if (list.size() == 0) {
			txtPropuesta.setText("PR001");
		} else {
			String idProp = list.get(list.size() - 1).getCodPropuesta();

			int correlativo = Integer.parseInt(idProp.substring(2)) + 1;
			
			txtPropuesta.setText("PR" + ft.format("%03d", correlativo));

		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}

	private void cargarcboPedidos() {
		// 1. Obtener el resultado del proceso -- listar
		ArrayList<Pedido> list = gPed.listarPedido();
		// 2. Validar el resultado del proceso
		if (list.size() == 0) {
			Tool.mensajeError(this, "Lista vac�a");
		} else {
			cboPedido.addItem("Seleccione ... ");
			for (Pedido ped : list) {
				cboPedido.addItem(ped.getCodigo());
			}
		}

	}

	private void cargarcboParticipantes() {
		// 1. Obtener el resultado del proceso -- listar
		ArrayList<Participante> list = gPart.buscarXPedido(getCodigoPedido());
		// 2. Validar el resultado del proceso
		cboParticipante.removeAllItems();
		if (list.size() == 0) {
			// Tool.mensajeError(null, "Lista vac�a");
		} else {
			cboParticipante.addItem("Seleccione ... ");
			for (Participante par : list) {
				cboParticipante.addItem(par.getCodParticipante());
			}
		}

	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarPropuesta();
	}

	private String getCodigo() {
		return txtPropuesta.getText();
	}

	private String getCodigoParticipante() {
		return cboParticipante.getSelectedItem().toString();
	}

	private String getCodigoPedido() {
		return cboPedido.getSelectedItem().toString();
	}

	private String getEstado() {
		return txtEstado.getText().toString();
	}

	private String getFechaProp() {
		String fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fecha = sdf.format(fechaProp.getDate());
		return fecha;
	}

	private String getDescTec() {
		return txtPropTecnica.getText();
	}

	private String getDescEco() {
		return txtPropEconomica.getText();
	}

	// Busca propuesta por su c�digo
	private void buscarPropuesta() {
		String codigo;
		// 1 obtener el codigo ingresado
		codigo = getCodigoParticipante();
		// Validar
		if (codigo == null) {
			return;
		} else {
			// llamar al proceso
			Propuesta prop = gProp.buscarPropuesta(codigo);
			// Validar el resultado del proceso
			if (prop == null) {
				Tool.mensajeError(this, "Propuesta no existe");
			} else {
				cboPedido.setSelectedItem(prop.getCodPedido());
				cboParticipante.setSelectedItem(prop.getCodParticipante());
				txtPropTecnica.setText(prop.getPropTecnica());
				txtPropEconomica.setText(prop.getPropEconomica());
				txtEstado.setText(prop.getEstado());

				try {
					fechaProp.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(prop.getFecha()));
				} catch (ParseException e) {
					System.out.println("Error en el formato de la fecha");
				}
			}
		}

	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarPropuesta();
	}

	// Actualiza la propuesta
	private void actualizarPropuesta() {
		// variables
		String estado, codigo;
		// entradas
		codigo = getCodigo();
		estado = getEstado();

		// validar
		if (estado == null || codigo == null) {
			return;
		} else {
			// Crear un objeto de la clse Usuario
			Propuesta prop = new Propuesta();
			// setear --> asignar los valores obtenidos de la GUI a los atributos privados
			prop.setCodPropuesta(codigo);
			prop.setEstado(estado);

			// LLamar al proceso de actualizar
			int res = gProp.actualizarPropuesta(prop);
			// validar el resultado del proceso de actualizar
			if (res == 0) {
				Tool.mensajeError(this, "Error en la actualizaci�n");
			} else {
				Tool.mensajeExito(this, "Usuario actualizado");
			}
		}

	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarPropuesta();
	}

	private void registrarPropuesta() {
		// variables
		String codPed, codProp, codParti, fechaProp, descTec, descEco, estado;

		codPed = getCodigoPedido();
		codProp = getCodigo();
		codParti = getCodigoParticipante();
		fechaProp = getFechaProp();
		descTec = getDescTec();
		descEco = getDescEco();
		estado = getEstado();

		if (codPed == null || codProp == null || codParti == null || fechaProp == null || descTec == null
				|| descEco == null || estado == null) {
			return;
		} else {
			// Crear un objeto de la clse Usuario
			Propuesta prop = new Propuesta();
			// setear --> asignar los valores obtenidos de la GUI a los atributos privados
			prop.setCodPedido(codPed);
			prop.setCodPropuesta(codProp);
			prop.setCodParticipante(codParti);
			prop.setFecha(fechaProp);
			prop.setPropTecnica(descTec);
			prop.setPropEconomica(descEco);
			prop.setEstado(estado);

			// LLamar al proceso de registro
			int res = gProp.registrarPropuesta(prop);
			// validar el resultado del proceso de registro
			if (res == 0) {
				Tool.mensajeError(this, "Error en el registro");
			} else {
				Tool.mensajeExito(this, "Propuesta registrada");
				correlativo();
			}
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboPedido) {
			itemStateChangedCboPedido(e);
		}
	}

	protected void itemStateChangedCboPedido(ItemEvent e) {
		cargarcboParticipantes();
	}
}
