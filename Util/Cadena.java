package Util;

public class Cadena {
	// fechaAcadena pasa una fecha tal como se almacenará en la base de datos
	// es decir, un número de 8 cifras en el formato AAAAMMDD a una cadena de
	// texto en formato DDMMAA
	public static String fechaAcadena(int fechaInt){
		String fechaStr = "";
		int dd, mm, aa;
		
		// Primero dividimos entre 100 para sacar el resto, que serán los días
		dd = fechaInt % 100;
		
		fechaInt /= 100;
		
		// Dividimos entre 100 para obtener los meses
		mm = fechaInt % 100;
		
		fechaInt /= 100;
		
		// Volvemos a dividir entre 100 para obtener el año
		aa = fechaInt % 100;
		
		fechaStr = String.format("%02d.%02d.%02d", dd, mm, aa);
		
		
		return fechaStr;
	}

	// cadenaAfecha 
	// Se le pasa una cadena de texto que será una fecha, que puede ser en formato
	// ddmmaa ó dd.mm.aa
	// La salida será un entero preparado para guadarse como una fecha en 
	// formato AAAAMMDD
	public static int cadenaAfecha(String fechaStr){
		int fechaInt = 0;
		int dd, mm, aa = 0;
		String auxStr = null;
		String auxStrFecha = null;
		
		// Primero quitamos los puntos o barras que se pueden usar para separar una fecha
		fechaStr = fechaStr.replaceAll("\\.", "");
		auxStr = fechaStr.replaceAll("/", "");
		
		dd = Integer.valueOf(auxStr.substring(0, 2));
		mm = Integer.valueOf(auxStr.substring(2, 4));
		aa = Integer.valueOf(auxStr.substring(4, 6));
		
		if(aa < 50)
			aa += 2000;
		else
			aa += 1900;
		
		auxStrFecha = String.format("%04d%02d%02d", aa, mm, dd);
		fechaInt = Integer.valueOf(auxStrFecha);
		
		return fechaInt;
	}
}
