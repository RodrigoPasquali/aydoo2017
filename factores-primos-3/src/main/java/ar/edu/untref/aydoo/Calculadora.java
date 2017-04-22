package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculadora {
	
	List<Integer> factoresPrimos = new ArrayList<Integer>();

	
	/***************************************************
	* Pre: Se ingresa como parametro un numero natural (numero > 0).
	* 
	* Post: Se devuelve una lista de Integuer con los factores primos del numero solicitado.
	* 
	* @Param numero: Numero del que se quiere obtener sus factores primos.
	*
	***************************************************/
	public List<Integer> calcularFactoresPrimos(int numero){
		if(numero == 1){
			this.factoresPrimos.add(0, 1);
			return this.factoresPrimos;
		}else if(numero>=2){
			for(int divisor = 2; divisor<= numero; divisor++){
				while(numero%divisor == 0){
					this.factoresPrimos.add(divisor);
					numero = numero/divisor;
				}
			}
			Collections.sort(this.factoresPrimos);
			return this.factoresPrimos;
		}else{
			this.factoresPrimos.add(-1);
			return this.factoresPrimos;
		}
	}
	
	public List<Integer> obtenerFactoresPrimos(){
		return this.factoresPrimos;
	}
	
}

