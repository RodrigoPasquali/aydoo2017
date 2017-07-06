package ar.edu.untref.aydoo;

import java.io.IOException;

public class Programa {	
	public static final void main(String arg[]) throws IOException {
		GeneradorDeRespuesta generador = new GeneradorDeRespuesta();
		generador.generarRespuesta(arg);
		generador.getRespuesta();
    }	
}
