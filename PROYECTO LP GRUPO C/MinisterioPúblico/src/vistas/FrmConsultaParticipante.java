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

@SuppressWarnings({ "serial", "unused" })
public class FrmConsultaParticipante extends JInternalFrame {

	private JPanel contentPane;
	private JButton btnExportar;
	private JButton btnBuscar;
	private DefaultTableModel model; 
	private JLabel lblNumeroPedido;
	private JComboBox<Object> cboPedido;
	private JTextArea txtS;

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
		
		btnExportar = new JButton("Exportar");
		btnExportar.setBounds(518, 24, 89, 31);
		contentPane.add(btnExportar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(381, 24, 89, 31);
		contentPane.add(btnBuscar);
		
		// crear columnas de la tabla
		model = new DefaultTableModel();
		model.addColumn("Nombre Postor");
		model.addColumn("Compañia");
		model.addColumn("Distrito");
		model.addColumn("RUC");
		model.addColumn("Prop. Técnica");
		model.addColumn("Prop. Económica");
		model.addColumn("Estado");
		
		lblNumeroPedido = new JLabel("Numero de Pedido:");
		lblNumeroPedido.setBounds(10, 32, 138, 14);
		contentPane.add(lblNumeroPedido);
		
		cboPedido = new JComboBox<Object>();
		cboPedido.setModel(new DefaultComboBoxModel<Object>(new String[] {"Selecciona ..."}));
		cboPedido.setBounds(141, 28, 138, 22);
		contentPane.add(cboPedido);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setBounds(10, 103, 654, 256);
		contentPane.add(txtS);
	}
}
