package ar.edu.untref.aydoo;

import excepciones.ExcepcionNumeroInvalido;
import excepciones.ExcepcionOutPutFileInvalido;

public class ObtenedorDeArgumentos {	
	
	public String getFormato(String[] cadena) {
		String formatoObtenido = "--format=pretty";
		for (int i = 0; i < cadena.length; i++) {
			int resultado = cadena[i].indexOf("--format=");        
	        if (resultado != -1) {
	        	formatoObtenido = cadena[i].toLowerCase();
	        }
		}
		return formatoObtenido;
	}
	
	public String getOrden(String[] cadena) {
		String ordenObtenido = "--sort=asc";
		for (int i = 0; i < cadena.length; i++) {
			int resultado = cadena[i].indexOf("--sort=");        
	        if (resultado != -1) {
	        	ordenObtenido = cadena[i];
	        }
		}
		return ordenObtenido;
	}
	
	public String getSalidaSolicitada(String[] cadena) {
		String salidaObtenida = "";
		for (int i = 0; i < cadena.length; i++) {
			int resultado = cadena[i].indexOf("--output-file=");        
	        if (resultado != -1) {
	        	salidaObtenida = cadena[i];
	        }
		}
		return salidaObtenida;
	}
	
	public int getNumero(String cadena) {
		try {
   			int numeroObtenido = Integer.parseInt(cadena);
   			return numeroObtenido;
       	} catch (NumberFormatException nfe) {
       		throw new ExcepcionNumeroInvalido();
   		}
   }
	
}
