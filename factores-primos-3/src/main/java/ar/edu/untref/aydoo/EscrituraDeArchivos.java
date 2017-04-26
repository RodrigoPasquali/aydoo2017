package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.IOException;

public class EscrituraDeArchivos {
	public void escribirArchivo(String directorio, String texto) throws IOException {
		FileWriter fichero = null;
        fichero = new FileWriter(directorio);
        fichero.write(texto);
	    fichero.close();
	}
}
