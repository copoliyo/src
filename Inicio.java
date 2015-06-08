import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class Inicio {
	
	JFrame pantallaInicial;
	
	
	public void creaGui(){
		
		pantallaInicial = new JFrame();
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pantallaInicial.setTitle( "Mantenimientos Sistem" );
		pantallaInicial.setSize( 800, 600);
		// pantallaInicial.setBackground( Color.gray );
		
		/*
		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );
		*/
		pantallaInicial.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		pantallaInicial.setVisible(true);	
		
		DatosInicio di = new DatosInicio();
		//Calendario cal = new Calendario();
		//System.out.println(cal.getFecha());
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater (
				new Runnable() {
					public void run() {
						Inicio pi = new Inicio();
						pi.creaGui();						
					}
				}
		);
		
	}

}
