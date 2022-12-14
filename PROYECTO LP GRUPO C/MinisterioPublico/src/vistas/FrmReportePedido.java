package vistas;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FrmReportePedido extends JInternalFrame {

	private JPanel contentPane;
	private JButton btnExportar;
	private JButton btnBuscar;
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
					FrmReportePedido frame = new FrmReportePedido();
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
	public FrmReportePedido() {
		setTitle("Reporte de pedidos");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		btnExportar = new JButton("Exportar");
		btnExportar.setBounds(467, 24, 89, 31);
		contentPane.add(btnExportar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(330, 24, 89, 31);
		contentPane.add(btnBuscar);
		
		lblNumeroPedido = new JLabel("Numero de Pedido:");
		lblNumeroPedido.setBounds(10, 28, 142, 14);
		contentPane.add(lblNumeroPedido);
		
		cboPedido = new JComboBox<Object>();
		cboPedido.setModel(new DefaultComboBoxModel<Object>(new String[] {"Selecciona ..."}));
		cboPedido.setBounds(162, 24, 105, 22);
		contentPane.add(cboPedido);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setBounds(10, 66, 654, 293);
		contentPane.add(txtS);
	}
}
