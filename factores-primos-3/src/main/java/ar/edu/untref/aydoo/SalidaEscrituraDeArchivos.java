package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.IOException;

import excepciones.ExcepcionOutPutFileInvalido;
import excepciones.ExcepcionSalidaInvalida;

public class SalidaEscrituraDeArchivos extends Salida {	

	private String outPutFileObtenido;

	public SalidaEscrituraDeArchivos(String salida, String cadena) {
		super(salida, cadena);
	}
	
	@Override
	public void aplicarSalidaSolicitada() throws IOException {
		if(getSalidaSolicitada().contains("--output-file")){
			getOutPutFile(getSalidaSolicitada());
			escribirArchivo(this.outPutFileObtenido, getCadenaDeSalida());
		} else {
			throw new ExcepcionSalidaInvalida();
		}
	}
	
	private String getOutPutFile(String cadena) {
		for (int i = 0; i < cadena.length(); i++) {
			int resultado = cadena.indexOf("--output-file=");        
	        if (resultado != -1) {
	        	final int posicionDondeComienzaNombreDeArchivo = 14;
				String aux = cadena.substring(posicionDondeComienzaNombreDeArchivo);
	        	if (aux.endsWith(".txt")) {
					this.outPutFileObtenido = aux;
				} else {
					throw new ExcepcionOutPutFileInvalido();
				}
	        }
		}
		return this.outPutFileObtenido;
	}

	private void escribirArchivo(String directorio, String texto) throws IOException {
		FileWriter fichero = null;
        fichero = new FileWriter(directorio);
        fichero.write(texto);
	    fichero.close();
	}
}
