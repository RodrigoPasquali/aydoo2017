package ar.edu.untref.aydoo;

import java.io.IOException;

public class Programa {	
	public static final void main(String arg[]) throws IOException {
		Ejecutador ejecutador = new Ejecutador();
		ejecutador.ejecutarPeticion(arg);
		ejecutador.getSalida();
    }	
}
