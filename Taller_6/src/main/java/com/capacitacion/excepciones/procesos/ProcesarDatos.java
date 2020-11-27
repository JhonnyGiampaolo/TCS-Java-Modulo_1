package com.capacitacion.excepciones.procesos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcesarDatos {
	
	public int division(String numero1,String numero2) {
		int resultado = 0;
		
		resultado=Integer.valueOf(numero1)/Integer.valueOf(numero2);
		return resultado;
		
	}
	
	
	public void arreglo(String[] lista) {
		

			for(int i=0;i<=5;i++) {
				System.out.println(lista[i]);
			}

	}
	
	public void fecha(String input) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date   date  = format.parse (input );
			date.toString();
		} catch (ParseException e) {

		}
	}
	

}
