package ar.edu.untref.aydoo;

import java.util.Collections;
import java.util.List;

public class Formato {
	
	
	public String aplicarFormato(String formato, List<Integer> factoresPrimos, int numero){
		String formatoAplicado;
		String formatoMiniscula = formato.toLowerCase();
		if(formatoMiniscula.equals("--format=pretty") || formatoMiniscula.equals("")){
			formatoAplicado = this.formatoPretty(formatoMiniscula, factoresPrimos, numero);
		}else if(formatoMiniscula.equals("--format=quiet")){
			formatoAplicado = this.formatoQuiet(formatoMiniscula, factoresPrimos, numero);
		}else{
			formatoAplicado = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
		}
		return formatoAplicado;
	}
	
	/***************************************************
	* Pre: 
	* -List<Integer> factoresPrimos no debe ser null ni 0.
	* -int numero debe ser un numero natural(numero > 0).
	* 
	* Post: 
	* Devuelve un String con los factores primos ingresados del numero seleccionado.
	* 
	* @Param 
	* -String formato: String que indica formato que se desea aplicar.
	* -List<Integer> factoresPrimos: lista que contiene los factores primos a los que se aplicar el formato.
	* -int numero: numero que se factoriza.
	***************************************************/
	public String formatoPretty(String formato, List<Integer> factoresPrimos, int numero){
		Collections.sort(factoresPrimos);
		String stringFP = "";
		for(int i = 0; i <= factoresPrimos.size()-1; i++ ) {
			stringFP = stringFP + factoresPrimos.get(i).toString() + " ";
		}
		String cadenaFormatoPretty = "Factores primos de " + numero + " : " + stringFP;
		return cadenaFormatoPretty;
	}
	
	private String formatoQuiet(String formato, List<Integer> factoresPrimos, int numero){
		Collections.sort(factoresPrimos, Collections.reverseOrder());
		String stringFP = "";
		for(int i = 0; i <= factoresPrimos.size()-1; i++ ) {
			stringFP = stringFP + factoresPrimos.get(i).toString() + "\n";
		}
		return stringFP;
	}
	

}
