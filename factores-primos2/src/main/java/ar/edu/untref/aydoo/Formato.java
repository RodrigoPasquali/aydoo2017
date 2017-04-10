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
