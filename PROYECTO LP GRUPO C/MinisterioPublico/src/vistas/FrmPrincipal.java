package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import utils.HiloReloj;

import java.awt.Font;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener  {

	public static JDesktopPane escritorio;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnConsulta;
	private JMenu mnTransaccion;
	private JMenu mnReporte;
	private JMenu mnAyuda;
	private JMenuItem mniSalir;
	private JMenuItem mniProyectoPronunciamiento;
	private JMenuItem mniResultadoPostulacion;
	private JLabel lblImgFonfo;
	private JMenuItem mniParticipante;
	private JMenuItem mniPropuesta;
	private JMenuItem mniApelacion;
	private JMenuItem mniPedido;
	private JMenuItem mniConsultaParticipante;
	private JMenuItem mniQuienesSomos;
	private JMenuItem mniActasPropuestas;
	private JMenuItem mniComite;
	private JMenuItem mniConsultaPropuesta;
	private JMenuItem mniReportePropuesta;
	private JMenuItem mniUsuario;
	private JMenuItem mniConsultaApelacion;
	private JLabel lblHora;
	
	
	public static void main (String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal prin = new FrmPrincipal();
					prin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FrmPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/imagenes/cibertecLogo.png")));
		setTitle("OTORGAMIENTO DE LA BUENA PRO " + FrmLogin.user.getNombreUsuario());
		setBounds(100,100,988,655);
		setLocationRelativeTo(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		escritorio = new JDesktopPane();
		escritorio.setBackground(Color.gray);
		getContentPane().add(escritorio, BorderLayout.CENTER);
		
		lblHora = new JLabel("hh:mm:ss");
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblHora.setBounds(862, 11, 100, 32);
		escritorio.add(lblHora);
		
		lblImgFonfo = new JLabel("");
		lblImgFonfo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/banner5.jpg")));
		lblImgFonfo.setBounds(0, 0, 972, 586);
		escritorio.add(lblImgFonfo);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/carpeta.png")));
		menuBar.add(mnArchivo);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/personal-de-mantenimiento.png")));
		menuBar.add(mnMantenimiento);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/buscando.png")));
		menuBar.add(mnConsulta);
		
		mnTransaccion = new JMenu("Transacci\u00F3n");
		mnTransaccion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/transaccion.png")));
		menuBar.add(mnTransaccion);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/reporte (1).png")));
		menuBar.add(mnReporte);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/mano-amiga.png")));
		menuBar.add(mnAyuda);
		
		mniSalir = new JMenuItem("Salir");
		mniSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/cerrar.png")));
		mniSalir.addActionListener(this);
		
		mniUsuario = new JMenuItem("Gestion de usuarios");
		mniUsuario.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/usuarios.png")));
		mniUsuario.addActionListener(this);
		mnArchivo.add(mniUsuario);
		mnArchivo.add(mniSalir);
		
		mniResultadoPostulacion = new JMenuItem("Puntaje en la Evaluacion de Propuesta");
		mniResultadoPostulacion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/puntaje.png")));
		mniResultadoPostulacion.addActionListener(this);
		mnTransaccion.add(mniResultadoPostulacion);
		
		mniActasPropuestas = new JMenuItem("Actas de Propuesta");
		mniActasPropuestas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/consulta (1).png")));
		mniActasPropuestas.addActionListener(this);
		mnTransaccion.add(mniActasPropuestas);
		
		mniProyectoPronunciamiento = new JMenuItem("Proyecto de pronunciamiento (APELACION)");
		mniProyectoPronunciamiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/ayudando.png")));
		mniProyectoPronunciamiento.addActionListener(this);
		mnTransaccion.add(mniProyectoPronunciamiento);
		
		
		mniPedido = new JMenuItem ("Pedidos");
		mniPedido.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/pedido.png")));
		mniPedido.addActionListener(this);
		mnMantenimiento.add(mniPedido);
		
		mniParticipante = new JMenuItem ("Participantes");
		mniParticipante.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/participantes.png")));
		mniParticipante.addActionListener(this);
		
		mniComite = new JMenuItem("Comite de Seleccion");
		mniComite.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/comite.png")));
		mniComite.addActionListener(this);
		mnMantenimiento.add(mniComite);
		mnMantenimiento.add(mniParticipante);
		
		mniPropuesta = new JMenuItem("Propuestas");
		mniPropuesta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/propuesta.png")));
		mniPropuesta.addActionListener(this);
		mnMantenimiento.add(mniPropuesta);
		
		mniApelacion = new JMenuItem("Apelaciones");
		mniApelacion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/apelacion.png")));
		mniApelacion.addActionListener(this);
		mnMantenimiento.add(mniApelacion);
		
		
		mniConsultaParticipante = new JMenuItem("Consulta de participantes");
		mniConsultaParticipante.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/consultaApe.png")));
		mniConsultaParticipante.addActionListener(this);
		mnConsulta.add(mniConsultaParticipante);
		
		mniConsultaPropuesta = new JMenuItem("Consulta de propuestas");
		mniConsultaPropuesta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/consultaProp.png")));
		mniConsultaPropuesta.addActionListener(this);
		mnConsulta.add(mniConsultaPropuesta);
		
		mniConsultaApelacion = new JMenuItem("Consulta de apelaciones");
		mniConsultaApelacion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/consultaApel.png")));
		mniConsultaApelacion.addActionListener(this);
		mnConsulta.add(mniConsultaApelacion);
		
		mniReportePropuesta = new JMenuItem("Reporte de Propuestas");
		mniReportePropuesta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/reporte-de-negocios.png")));
		mniReportePropuesta.addActionListener(this);
		mnReporte.add(mniReportePropuesta);
		
		mniQuienesSomos = new JMenuItem("\u00BFQuienes somos?");
		mniQuienesSomos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/5172568_add_contact_user_icon (1).png")));
		mniQuienesSomos.addActionListener(this);
		mnAyuda.add(mniQuienesSomos);
		
		permisos();
		//MOSTRAR HORA
		mostrarHora();
		
	}
	private void mostrarHora() {
		HiloReloj h = new HiloReloj(lblHora);
		h.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mniConsultaApelacion) {
			actionPerformedMntmConsultaApelacion(e);
		}
		if (e.getSource() == mniUsuario) {
			actionPerformedMniUsuario(e);
		}
		if (e.getSource() == mniReportePropuesta) {
			actionPerformedMniReportePropuesta(e);
		}
		if (e.getSource() == mniConsultaPropuesta) {
			actionPerformedMniConsultaPropusta(e);
		}
		if (e.getSource() == mniComite) {
			actionPerformedMntmComite(e);
		}
		if (e.getSource() == mniActasPropuestas) {
			actionPerformedMniActasPropuestas(e);
		}
		if (e.getSource() == mniResultadoPostulacion) {
			actionPerformedMniResultadoPostulacion(e);
		}
		if(e.getSource() == mniProyectoPronunciamiento) {
			actionPerformedMniSolucionApelacion(e);
		}
		if(e.getSource() == mniSalir) {
			actionPerformedMniSalir(e);
		}
		if(e.getSource()==mniParticipante) {
			actionPerformedMniParticipante(e);
		}
		if(e.getSource()==mniPropuesta) {
			actionPerformedMniPostulacion(e);
		}
		if(e.getSource()==mniApelacion) {
			actionPerformedMniApelacion(e);
		}
		if(e.getSource()==mniPedido) {
			actionPerformedMniPedido(e);
		}
		if(e.getSource()==mniConsultaParticipante) {
			actionPerformedMniConsultaParticipante(e);
		}
		
		if(e.getSource()==mniQuienesSomos) {
			actionPerformedMniQuienesSomos(e);
		}
	}
	
	//ARCHIVO
	
	protected void actionPerformedMniSalir(ActionEvent e) {
		
		System.exit(0);
	}
	

	protected void actionPerformedMniUsuario(ActionEvent e) {
		FrmUsuario user = new FrmUsuario();
		user.setVisible(true);
		escritorio.add(user).setLocation(0,0);
		user.toFront();
	}
	
	//MANTENIMIENTO
	
	protected void actionPerformedMniPostulacion(ActionEvent e) {
		FrmPropuesta post= new FrmPropuesta ();
		post.setVisible(true);
		escritorio.add(post).setLocation(0,0);
		post.toFront();
	}
	
	protected void actionPerformedMniParticipante(ActionEvent e) {
		FrmParticipante parti= new FrmParticipante ();
		parti.setVisible(true);
		escritorio.add(parti).setLocation(0,0);
		parti.toFront();
		
	}
	
	protected void actionPerformedMniApelacion(ActionEvent e) {
		FrmApelacion apel= new FrmApelacion ();
		apel.setVisible(true);
		escritorio.add(apel).setLocation(0,0);
		apel.toFront();
	}
	
	protected void actionPerformedMniPedido(ActionEvent e) {
		FrmPedido pedido=new FrmPedido ();
		pedido.setVisible(true);
		escritorio.add(pedido).setLocation(0,0);
		pedido.toFront();
	}

	
	//CONSULTA
	
	protected void actionPerformedMniConsultaParticipante(ActionEvent e) {
		FrmConsultaParticipante conParti= new FrmConsultaParticipante();
		conParti.setVisible(true);
		escritorio.add(conParti).setLocation(0,0);
		conParti.toFront();
	}	
	
	protected void actionPerformedMniConsultaPropusta(ActionEvent e) {
		
		FrmConsultaPropuesta conProp = new FrmConsultaPropuesta();
		conProp.setVisible(true);
		escritorio.add(conProp).setLocation(0,0);
		conProp.toFront();
		
	}
	
	protected void actionPerformedMntmConsultaApelacion(ActionEvent e) {
		FrmConsultaApelacion conApe = new FrmConsultaApelacion();
		conApe.setVisible(true);
		escritorio.add(conApe).setLocation(0,0);
		conApe.toFront();
	}
	
	//TRANSACCION
	
	
	protected void actionPerformedMniResultadoPostulacion(ActionEvent e) {	
		FrmPuntajePropuesta resPos= new FrmPuntajePropuesta();
		resPos.setVisible(true);
		escritorio.add(resPos).setLocation(0,0);
		resPos.toFront();
		
	}
	protected void actionPerformedMniSolucionApelacion(ActionEvent e) {
		FrmProyectoPronunciamientoApelacion solApel= new FrmProyectoPronunciamientoApelacion();
		solApel.setVisible(true);
		escritorio.add(solApel).setLocation(0,0);;
		solApel.toFront();
	}
	
	protected void actionPerformedMniActasPropuestas(ActionEvent e) {
		FrmActaPropuesta form = new FrmActaPropuesta();
		form.setVisible(true);
		escritorio.add(form).setLocation(0,0);
		form.toFront();
	}
	
	
	//REPORTE
	
	
	protected void actionPerformedMniReportePropuesta(ActionEvent e) {
		FrmReportePropuesta reporProp = new FrmReportePropuesta();
		reporProp.setVisible(true);
		escritorio.add(reporProp).setLocation(0,0);
		reporProp.toFront();
	}
	
	//AYUDA 
	
	protected void actionPerformedMniQuienesSomos(ActionEvent e) {
		FrmAyuda ayuda= new FrmAyuda(this,true);
		ayuda.setLocationRelativeTo(this);
		ayuda.setVisible(true);
		ayuda.setLocationRelativeTo(this);
	}
	
	//COMITE
	
	protected void actionPerformedMntmComite(ActionEvent e) {
		FrmComite reporContra = new FrmComite ();
		reporContra.setVisible(true);
		escritorio.add(reporContra).setLocation(0,0);
		reporContra.toFront();
	}
	
	//METODOS ADICIONALES
	
	private void permisos() {
		
		switch(FrmLogin.user.getTipoUsuario()) {
		
		case 1://ADMINITRADOR
			break;
		case 2://MIEMBRO DEL CEP
			mostrarOpciones(false);
			mniPropuesta.setEnabled(true);
			mniConsultaPropuesta.setEnabled(true);
			mniResultadoPostulacion.setEnabled(true);
			mniActasPropuestas.setEnabled(true);
			break;
		case 3://ASISTENTE DE LOGISTICA
			mostrarOpciones(false);
			mniPedido.setEnabled(true);
			mniComite.setEnabled(true);
			mniPedido.setEnabled(true);
			mniConsultaParticipante.setEnabled(true);
			mniApelacion.setEnabled(true);
			break;
		case 4://ASESOR JURIDICO
			mostrarOpciones(false);
			mniConsultaApelacion.setEnabled(true);
			mniProyectoPronunciamiento.setEnabled(true);
			break;
		
		}
	}
	
	private void mostrarOpciones(Boolean x) {
		//MANTENIMIENTO
		mniUsuario.setEnabled(x);
		mniPedido.setEnabled(x);
		mniComite.setEnabled(x);
		mniParticipante.setEnabled(x);
		mniPropuesta.setEnabled(x);
		mniApelacion.setEnabled(x);
		//CONSULTA
		mniConsultaParticipante.setEnabled(x);
		mniConsultaPropuesta.setEnabled(x);
		mniConsultaApelacion.setEnabled(x);
		//TRANSACCION
		mniResultadoPostulacion.setEnabled(x);
		mniActasPropuestas.setEnabled(x);
		mniProyectoPronunciamiento.setEnabled(x);
		//REPORTE
		mniReportePropuesta.setEnabled(x);
	}

}
