package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Collections;

public class Formato {
	
	public String aplicarFormato(String formato, ArrayList<Integer> factoresPrimos, int numero){
		String formatoAplicado;
		String formatoMinuscula = formato.toLowerCase();
		System.out.println(formatoMinuscula);
		if(formatoMinuscula == "--format=pretty"){
			formatoAplicado = this.formatoPretty(formatoMinuscula, factoresPrimos, numero);
			System.out.println("Entro en aplicarFormato pretty");
		}else if(formatoMinuscula == "--format=quiet"){
			formatoAplicado = this.formatoQuiet(formatoMinuscula, factoresPrimos, numero);
			System.out.println("Entro en aplicarFormato quiet");
		}else{
			formatoAplicado = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
		}
		return formatoAplicado;
	}
	
	
	
	private String formatoPretty(String formato, ArrayList<Integer> factoresPrimos, int numero){
		System.out.println("Entro a Pretty");
		Collections.sort(factoresPrimos);
		String stringFP = factoresPrimos.toString();
		String cadenaFormatoPretty = "Factores primos de " + numero + " :" + stringFP;
		System.out.println(cadenaFormatoPretty);
		return cadenaFormatoPretty;
	}
	
	private String formatoQuiet(String formato, ArrayList<Integer> factoresPrimos, int numero){
		System.out.println("Entro a Quiet");
		Collections.sort(factoresPrimos, Collections.reverseOrder());
		String stringFP = factoresPrimos.toString();
		for(int i = 0; i < factoresPrimos.size(); i++ ){
			System.out.println(factoresPrimos.get(i));
		}
		return stringFP;
	}
	

}
