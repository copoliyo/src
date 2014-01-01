package Util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class JTextFieldFecha extends JTextField implements KeyListener, ActionListener, FocusListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Fecha válida");
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
			if (Fecha.fechaValida(this.getText())){
				System.out.println("Fecha válida");
				// Un pequeño lío
				this.setText(Cadena.fechaAcadena(Cadena.cadenaAfecha(this.getText())));
				this.select(0, 0);
			}else{
				System.out.println("Fecha INCORRECTA");
				this.requestFocus(true);
			}
				
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

		if (Fecha.fechaValida(this.getText())){
			System.out.println("Fecha válida");
			// Un pequeño lío
			this.setText(Cadena.fechaAcadena(Cadena.cadenaAfecha(this.getText())));
			this.select(0, 0);
		}else{
			System.out.println("Fecha INCORRECTA");
			this.requestFocus(true);
		}


	}

}
