package utils;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Formatter;

import javax.swing.*;

public class Tool {
	public static void mensajeError(Component pos,String msj) {
		JOptionPane.showMessageDialog(pos, msj, "ERROR!",0);
	}

	
	public static void mensajeExito(Component pos, String msj) {
		JOptionPane.showMessageDialog(pos, msj, "EXITO!",1);
	}

	
	public static void imprimir(JTextArea txtS, String cad) {
		txtS.append( cad + "\n");	
	}
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdfChooser = new SimpleDateFormat("dd-MM-yyyy");
	
	public static Formatter ft = new Formatter();
	
	
}
