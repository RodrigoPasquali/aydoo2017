package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {
	private List<Integer> factoresPrimos = new ArrayList<Integer>();
	
	/*
	* Pre: Se ingresa como parametro un numero natural (numero > 0).
	* 
	* Post: Se devuelve una lista de Integuer con los factores primos del numero 
	* 		solicitado.
	* 
	* @Param numero: Numero del que se quiere obtener sus factores primos.
	*
	*/
	public void calcularFactoresPrimos(int numero) {
		if (numero == 1) {
			this.factoresPrimos.add(0, 1);
		} else if (numero >= 2) {
			for (int divisor = 2; divisor <= numero; divisor++) { 
				while (numero % divisor == 0) {
					this.factoresPrimos.add(divisor);
					numero = numero / divisor;
				}
			}
		} else {
			this.factoresPrimos.add(-1);
		}
	}
	
	public List<Integer> obtenerFactoresPrimos() {
		return this.factoresPrimos;
	}
}

