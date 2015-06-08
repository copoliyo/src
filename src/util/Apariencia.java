package util;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Apariencia {

	public static void cambiaLook(){
		
		try
        {
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.Substance"+"CremeCoffee"+"LookAndFeel");
			UIManager.setLookAndFeel("org.jvnet.substance.skin.Substance"+"OfficeBlue2007"+"LookAndFeel");
        } catch(Exception e)
        {
            System.out.println("Fall� la carga del tema");
        } 
         
	}
	
	public static Font cambiaFuente(){
		return new Font("MS Reference Sans Serif", Font.BOLD, 14);
		//return new Font("MS Reference Sans Serif", Font.PLAIN, 10);		
	}
	
	public static Font cambiaFuente(int atributo, int tama�o){
		return new Font("MS Reference Sans Serif", atributo, tama�o);
		//return new Font("MS Reference Sans Serif", Font.PLAIN, 10);
	}
	
	public static void mensajeInformativo(int tama�oFuente, String strMensaje){
		JOptionPane.showMessageDialog(null, "<html><font face='Courier New'><font size='" + tama�oFuente + "'><strong>" + 
				strMensaje + "</strong></font></html>");	
	}
}
