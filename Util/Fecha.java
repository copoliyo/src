package Util;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha{
	
	private int anio, mes, dia;
	
	public Fecha(){
		anio = Calendar.getInstance().get(Calendar.YEAR);
		mes = Calendar.getInstance().get(Calendar.MONTH);		
		dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);			
	}		
	
	public int fechaDia(){
		int fecha = 0;
		
		anio = Calendar.getInstance().get(Calendar.YEAR);
		mes = Calendar.getInstance().get(Calendar.MONTH);		
		dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);	
		
		String fechaStr = String.format("%04d%02d%02d", anio, mes + 1, dia);
		fecha = Integer.valueOf(fechaStr);
		
		return fecha;
	}
	
	public static boolean fechaValida(String fecha){
		boolean fechaOk = true;
		
		int anio, mes, dia, diasMes, fechaInt;
		String fechaStr;
		
		fechaInt = Cadena.cadenaAfecha(fecha);
		fechaStr = String.valueOf(fechaInt);
		anio = Integer.valueOf(fechaStr.substring(0, 4));
		mes  = Integer.valueOf(fechaStr.substring(4, 6));
		dia  = Integer.valueOf(fechaStr.substring(6, 8));
		// Creamos un objeto calendario del año y mes deseados		 
		Calendar cal = new GregorianCalendar(anio, mes - 1, 1); 
		// Obtenemos el número de dias de ese mes en ese año
		diasMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
		
		// Si hemos puesto un día mayor que el número máximo de dias posibles en ese mes = error
		if (dia > diasMes)
			fechaOk = false;
		
		return fechaOk;
	}
}
