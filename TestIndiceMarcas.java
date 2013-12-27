import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class TestIndiceMarcas {
	/**
	 * Utilizado para probar el lanzamiento del �ndice de marcas
	 * Se encargar� de abrir la base de datos para poder mandarle como par�metro una 'Conexion'
	 * El �ndice de marcas deber� devolver una cadena con las tres letras de la marca
	 */
	
	static final int INDICE_CENTROS = 1;
	static final int INDICE_MARCAS = 2;
	static final int INDICE_GAMAS = 3;
	static final int INDICE_FAMILIAS = 4;
	
	public static void main(String[] args) {
		// 'marca' contendr� las letras la marca elegida o un NULL si no se elije nada	
		String marca = "";

		
		DatosComunes dc = new DatosComunes("MV");
		
		dc.eEmpresa = "PV";
		
		System.out.println("eEmpresa : '" + dc.eEmpresa + "'");
		
		IndiceCemagf im = new IndiceCemagf(INDICE_FAMILIAS);
		// Como ya estar� establecido el valor de la marca, tendremos que 'pedirlo'.
		marca = im.getMarca();
		System.out.println("Marca en Test: " + marca);
		
		

	}

}
