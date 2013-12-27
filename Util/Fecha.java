package Util;


import java.util.Calendar;

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
}
