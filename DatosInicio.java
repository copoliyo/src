import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import Util.Cadena;
import Util.Fecha;

public class DatosInicio {
	JDialog pantallaDi;
	JLabel lEmpresa, lFecha, lUsuario, lNombreEmpresa;
	JTextField tfEmpresa, tfFecha, tfUsuario;
	JButton bCorrecto, bFinPrograma, bCalendario;
	MysqlConnect m = null;
	

	
	DatosInicio(){
		m = MysqlConnect.getDbCon();
			
		Fecha fec = new Fecha();
		
		pantallaDi = new JDialog();
		pantallaDi.setModal(true);
		pantallaDi.setSize(300, 200);
		pantallaDi.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		pantallaDi.setLayout(null);
		
		lEmpresa = new JLabel("Empresa");
		lEmpresa.setBounds(10, 10, 80, 20);
		
		tfEmpresa = new JTextField();
		tfEmpresa.setBounds(100, 10, 30, 20);
		tfEmpresa.addKeyListener(new EmpresaListener());
		tfEmpresa.addFocusListener(new EmpresaListener());
		
		lNombreEmpresa = new JLabel("");
		lNombreEmpresa.setBounds(150, 10, 200, 20);
						
		lFecha = new JLabel("Fecha");
		lFecha.setBounds(10, 35, 80, 20);
		
		bCalendario = new JButton();
		bCalendario.setBounds(70, 35, 20, 20);
		bCalendario.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icono_calendario.png")));
		bCalendario.addActionListener(new BotonCalendarioListener());
		
		tfFecha = new JTextField();
		tfFecha.setBounds(100, 35, 90, 20);
		tfFecha.setText(Cadena.fechaAcadena(fec.fechaDia()));
		
		lUsuario = new JLabel("Usuario");
		lUsuario.setBounds(10, 60, 80, 20);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(100, 60, 100, 20);
		
		bCorrecto = new JButton("Correcto");
		bCorrecto.setBounds(30, 135, 100, 20);
		bCorrecto.addActionListener(new BotonListener());
		
		bFinPrograma = new JButton("Fin Programa");
		bFinPrograma.setBounds(140, 135, 100, 20);
		bFinPrograma.addActionListener(new BotonListener());			
		
		
		pantallaDi.add(lEmpresa);
		pantallaDi.add(tfEmpresa);
		pantallaDi.add(lNombreEmpresa);
		pantallaDi.add(lFecha);
		pantallaDi.add(bCalendario);
		pantallaDi.add(tfFecha);
		pantallaDi.add(lUsuario);
		pantallaDi.add(tfUsuario);
		pantallaDi.add(bCorrecto);
		pantallaDi.add(bFinPrograma);
		pantallaDi.setVisible(true);
		
	}
	
	public void compruebaEmpresa(){
		ResultSet rs = null;
		boolean noError = true;
		
		String empresa = tfEmpresa.getText();
		
		// Por si acaso la empresa siempre en mayúsculas
		empresa = empresa.toUpperCase();
		// Ejecutamos la consulta
		if(empresa.length() == 2){
			try {
				rs = m.query("SELECT * FROM SISTEM WHERE EMPRESA = '" + empresa + "'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error en lectura fichero de Sistema!!!");
				noError = false;
			}

			if (noError == true){
				try {
					boolean existeReg = false;

					while(rs.next() == true){	
						existeReg = true;

						lNombreEmpresa.setText(rs.getString("SISTEM_NOMBRE"));
						DatosComunes dc = new DatosComunes(empresa);
						System.out.println(DatosComunes.nombreEmpresa);
					}
					if(existeReg == false){
						System.out.println("No existe la empresa, CREARLA!!!");
						//JOptionPane.showMessageDialog(null, "No existe la empresa, CREARLA!!!");
						//tfEmpresa.requestFocus();
					}

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error en lectura fichero de Sistema!!!");
					e.printStackTrace();
				}
			}
		}
	}
	
	
	class BotonListener implements ActionListener{		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//if(arg0.getSource() == bCorrecto)
			//	JOptionPane.showMessageDialog(null, "Correcto");
			//if(arg0.getSource() == bFinPrograma)
			//	JOptionPane.showMessageDialog(null, "Fin Programa");
				
			
			pantallaDi.dispose();
		}		
	}
	
	class BotonCalendarioListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			int fecha;
			
			Calendario cal = new Calendario();
			fecha = cal.getFecha();
			if (fecha != 0){
				tfFecha.setText(Cadena.fechaAcadena(fecha));
			}			
		}
	}
	
	class EmpresaListener implements KeyListener, FocusListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// Leemos la tecla y la pasamos a mayúscula
			char caracter = Character.toUpperCase(arg0.getKeyChar());
			
			// Las empresas sólo pueden tener dos letras para identificarse
			if (tfEmpresa.getText().length() > 1)
				arg0.consume();
			// La tenemos que volver a poner en 'arg0' porque si no seguirá trabajando con
			// el valor inicial
			arg0.setKeyChar(caracter);

			// Si es algo distinto de una letra o del caracter de borrado, lo ignoramos
			if(((caracter < 'A') || 
					(caracter > 'Z')) &&
					(caracter != KeyEvent.VK_BACK_SPACE))
			{
				arg0.consume();
			}
						
			//if (arg0.getSource() == tfEmpresa)
			//	JOptionPane.showMessageDialog(null, "Empresa");
			// Si pulsamos enter o 
			if (caracter == KeyEvent.VK_TAB || caracter == KeyEvent.VK_ENTER)
				compruebaEmpresa();
		}

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			compruebaEmpresa();
		}
		
	}
}
