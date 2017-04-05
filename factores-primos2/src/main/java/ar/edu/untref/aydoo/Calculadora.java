package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Collections;

public class Calculadora {
	
	ArrayList<Integer> factoresPrimos = new ArrayList<Integer>();

	//agregar formato
	public ArrayList<Integer> calcularFactoresPrimos(int numero){
		if(numero == 1){
			System.out.println("Factores Primos de " + numero + ": " + numero);
			this.factoresPrimos.add(0, 1);
			return this.factoresPrimos;
		}else if(numero>=2){
			for(int divisor = 2; divisor<= numero; divisor++){
				while(numero%divisor == 0){
					this.factoresPrimos.add(divisor-2, divisor);
					numero = numero/divisor;
				}
			}
			//Collections.sort(this.factoresPrimos);
			return this.factoresPrimos;
		}else{
			System.out.println("El valor ingresado es invalido. Por favor inserte un numero natural mayor a 0");
			this.factoresPrimos.add(-1);
			return this.factoresPrimos;
		}
	}
	
	public ArrayList<Integer> obtenerFactoresPrimos(){
		System.out.println(this.factoresPrimos);

		return this.factoresPrimos;
	}
	
	

}

