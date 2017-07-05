package ar.edu.untref.aydoo;

import excepciones.ExcepcionNumeroInvalido;
import excepciones.ExcepcionOutPutFileInvalido;

public class ObtencionDeArgumentos {	
	private String outPutFileObtenido = null;
	
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
	
	public String getOutputFile(String[] cadena) {
		for (int i = 0; i < cadena.length; i++) {
			int resultado = cadena[i].indexOf("--output-file=");        
	        if (resultado != -1) {
	        	final int posicionDondeComienzaNombreDeArchivo = 14;
				String aux = cadena[i].substring(posicionDondeComienzaNombreDeArchivo);
	        	if (aux.endsWith(".txt")) {
					this.outPutFileObtenido = aux;
				} else {
					throw new ExcepcionOutPutFileInvalido();
				}
	        }
		}
		return this.outPutFileObtenido;
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
