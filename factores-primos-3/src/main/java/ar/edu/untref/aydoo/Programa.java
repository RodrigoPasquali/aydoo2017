package ar.edu.untref.aydoo;

import java.io.IOException;

public class Programa {	
	public static final void main(String arg[]) throws IOException {
		ManejadorDePeticion manejador = new ManejadorDePeticion();
		manejador.ejecutarPeticion(arg);
		manejador.getSalida();
    }	
}
