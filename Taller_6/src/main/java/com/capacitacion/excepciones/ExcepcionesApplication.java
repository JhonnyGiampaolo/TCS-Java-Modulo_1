package com.capacitacion.excepciones;


import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.capacitacion.excepciones.procesos.ProcesarDatos;

@SpringBootApplication
public class ExcepcionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcepcionesApplication.class, args);
		
		//caso1();
		//caso2();
		//caso3();
		//caso4();
		//caso5();
		
			
	}
	
	
	public static void caso1() {
		
		// cree una instancia de la clase ProcesarDatos y use el metodo division.
		//envie   los valores ("48", "0") - division por cero
		//en el metodo division capture e identifique la excepcion que se genera (no la excepcion general de java Exception) e imprima en consola  desde  el catch StackTrace,Cause,Message; 
		// haga lo mismo para los valores ("15.8", "30") 
		
	}
	public static void caso2() {
		
		//cree una instancia de la clase ProcesarDatos y use el metodo division. y use metodo arreglo
		//envie al metodo arry de string  de 3 valores para que se genere una excepcion.
		//capture e identifique la excepcion que se genera (no la excepcion general de java Exception) e imprima en consola   StackTrace,Cause,Message del error; 
		
	}
	
	public static void caso3() {
		
		//// cree una instancia de la clase ProcesarDatos y use el metodo fecha.
		//envie al metodo una fecha con el formato "yyyy/mm/dd".
		//capture e identifique la excepcion que se genera (no la excepcion general de java Exception) 
	    // Re-lance la excepcion y capturela aqui en el metodo case3 e imprima en consola StackTrace,Cause,Message del error; 


	}

	public static void caso4() {
		//manejo de excepciones personalizadas
		
	}
	
	public static void caso5() {
		//manejo de cierre de  objetos en lectura y escritura de arhivos

	}
	

}
