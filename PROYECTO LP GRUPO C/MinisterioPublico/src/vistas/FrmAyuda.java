package vistas;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;

@SuppressWarnings("serial")
public class FrmAyuda extends JDialog{
	private JSeparator separator;
	private JLabel lblPanel;
	private JLabel lblIntegrantes;
	private JLabel lblJeanPierreMaguia;
	private JLabel lblRicardo;
	private JLabel lblKristellTrujillo;
	
	
	
	
	public static void main (String[]args) {
		FrmAyuda ayuda = new FrmAyuda();
		ayuda.setVisible(true);
	}
	
	public FrmAyuda () {
		
		setTitle("Ayuda");
		setBounds(100,100,500,300);
		this.getContentPane().setLayout(null);
		
		getContentPane().setBackground(Color.lightGray);
		
		separator = new JSeparator();
		separator.setBounds(10, 56, 464, 194);
		getContentPane().add(separator);
		
		lblPanel = new JLabel("PROYECTO LP1");
		lblPanel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel.setBounds(22, 11, 440, 37);
		getContentPane().add(lblPanel);
		
		lblIntegrantes = new JLabel("LUIS MACHACA RUIZ");
		lblIntegrantes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIntegrantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrantes.setBounds(100, 74, 282, 26);
		getContentPane().add(lblIntegrantes);
		
		lblJeanPierreMaguia = new JLabel("JEAN PIERRE MAGUI\u00D1A");
		lblJeanPierreMaguia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJeanPierreMaguia.setHorizontalAlignment(SwingConstants.CENTER);
		lblJeanPierreMaguia.setBounds(100, 111, 282, 26);
		getContentPane().add(lblJeanPierreMaguia);
		
		lblRicardo = new JLabel("RICARDO RAMIREZ MALLQUI");
		lblRicardo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRicardo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicardo.setBounds(100, 148, 282, 26);
		getContentPane().add(lblRicardo);
		
		lblKristellTrujillo = new JLabel("KRISTELL TRUJILLO");
		lblKristellTrujillo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKristellTrujillo.setHorizontalAlignment(SwingConstants.CENTER);
		lblKristellTrujillo.setBounds(100, 182, 282, 26);
		getContentPane().add(lblKristellTrujillo);
		
		
	}
}
