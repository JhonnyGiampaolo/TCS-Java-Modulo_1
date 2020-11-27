package com.lab;

public class Ordenamiento {

	public int[] numeros = { 50, 20, 40, 80, 30 };

	public void imprimir() {
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Arreglo posicion " + i + " valor " + numeros[i]);
		}
	}

	public void seleccion() {
		int i, j;
		int indiceMenor;

		for (i = 0; i < numeros.length - 1; i++) {

			indiceMenor = i;

			for (j = i + 1; j < numeros.length; j++) {

				if (numeros[j] < numeros[indiceMenor]) {

					indiceMenor = j;

				}

			}

			if (i != indiceMenor) {
				int aux = numeros[i];
				numeros[i] = numeros[indiceMenor];
				numeros[indiceMenor] = aux;
			}

		}
	}

	public void burbuja() {
		int pasada, i;

		for (pasada = 0; pasada < numeros.length - 1; pasada++) {

			for (i = 0; i < numeros.length - 1 - pasada; i++) {

				if (numeros[i] > numeros[i + 1]) {
					int aux = numeros[i];
					numeros[i] = numeros[i + 1];
					numeros[i + 1] = aux;
				}

			}

		}
	}

	/**
	 * El algoritmo correspondiente a la ordenación por inserción contempla los siguientes pasos:
		1. El primer elemento A[0] se considera ordenado; es decir, la lista inicial consta de un elemento.

		2. Se inserta A[1] en la posición correcta, delante o detrás de A[0], dependiendo de que sea menor o mayor.

		3. Por cada bucle o iteración i (desde i=1 hasta n-1) se explora la sublista A[i-1] . .A[0] 
			buscando la posición correcta de inserción; a la vez se mueve hacia abajo (a la derecha en la sublista) 
			una posición todos los elementos mayores que el elemento a insertar A[i], para dejar vacía esa posición.
			
		4. Insertar el elemento a la posición correcta.
	 */
	public void insercion() {
		// TODO implementar el metodo de ordenamiento
	}

	public static void main(String[] args) {

		Ordenamiento ord = new Ordenamiento();

		ord.imprimir();

		ord.insercion();

		ord.imprimir();

	}
}
