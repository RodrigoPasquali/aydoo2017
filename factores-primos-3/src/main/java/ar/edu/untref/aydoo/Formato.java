package ar.edu.untref.aydoo;

import java.util.List;

public abstract class Formato {
	
	private String formatoAFactorizarEnMiniscula;
	private int numeroAFactorizar;
	private List<Integer> listaDeFactoresPrimos;
	
	public Formato(String formato, List<Integer> factoresPrimos, int numero){
		this.formatoAFactorizarEnMiniscula = formato.toLowerCase();
		this.numeroAFactorizar = numero;
		this.listaDeFactoresPrimos = factoresPrimos;
	}
	
	public abstract String aplicarFormato(String formato, List<Integer> factoresPrimos, int numero);
	
	/*	
	   if (formatoMiniscula.equals("--format=pretty") || formatoMiniscula.equals("")) {
			formatoAplicado = this.formatoPretty(factoresPrimos, numero);
		} else if (formatoMiniscula.equals("--format=quiet")) {
			formatoAplicado = this.formatoQuiet(factoresPrimos, numero);
		} else {
			formatoAplicado = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
		}
		return formatoAplicado;
	*/
	
	/*
	* Pre: 
	* -List<Integer> factoresPrimos no debe ser null ni 0.
	* -int numero debe ser un numero natural(numero > 0).
	* 
	* Post: 
	* Devuelve un String aplicando el formato pretty con los factores primos ingresados del numero seleccionado.
	* 
	* @Param 
	* -String formato: String que indica formato que se desea aplicar.
	* -List<Integer> factoresPrimos: lista que contiene los factores primos a los que se aplicar el formato.
	* -int numero: numero que se factoriza.
	*/
	public String formatoPretty(List<Integer> factoresPrimos, int numero) {
		String stringFP = "";
		for (int i = 0; i <= factoresPrimos.size() - 1; i++) {
			stringFP = stringFP + factoresPrimos.get(i).toString() + " ";
		}
		String cadenaFormatoPretty = "Factores primos de " + numero + " : " + stringFP;
		return cadenaFormatoPretty;
	}
	
	/*
	* Pre: 
	* -List<Integer> factoresPrimos no debe ser null ni 0.
	* -int numero debe ser un numero natural(numero > 0).
	* 
	* Post: 
	* Devuelve un String aplicando el formato quiet con los factores primos ingresados del numero seleccionado.
	* 
	* @Param 
	* -String formato: String que indica formato que se desea aplicar.
	* -List<Integer> factoresPrimos: lista que contiene los factores primos a los que se aplicar el formato.
	* -int numero: numero que se factoriza.
	*/
	private String formatoQuiet(List<Integer> factoresPrimos, int numero) {
		String stringFP = "";
		for (int i = 0; i <= factoresPrimos.size() - 1; i++) {
			stringFP = stringFP + factoresPrimos.get(i).toString() + "\r\n";
		}
		return stringFP;
	}
}
