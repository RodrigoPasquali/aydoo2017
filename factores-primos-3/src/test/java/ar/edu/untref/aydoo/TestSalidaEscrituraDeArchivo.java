package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import excepciones.ExcepcionSalidaInvalida;

public class TestSalidaEscrituraDeArchivo {
	@Test
	public void aplicarSalidaSolicitadaDeberiaDevolver335() throws IOException {
		String salida = "--output-file=salida3.txt";
		String cadena = "3 3 5";
		SalidaEscrituraDeArchivo generadorDeSalida = new SalidaEscrituraDeArchivo(salida, cadena);
		String valorEsperado = "3 3 5";
		
		generadorDeSalida.aplicarSalidaSolicitada();
		
		FileReader f = new FileReader("salida3.txt");
	    BufferedReader b = new BufferedReader(f);
	    String valorActual = b.readLine();
	    
	    b.close();
		
		assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void aplicarSalidaSolicitadaDeberiaDevolverExcepcionSalidaInvalida() throws IOException {
		String salida = "jose";
		String cadena = "3 3 5";
		SalidaEscrituraDeArchivo generadorDeSalida = new SalidaEscrituraDeArchivo(salida, cadena);
				
		try {
			generadorDeSalida.aplicarSalidaSolicitada();
		}catch (ExcepcionSalidaInvalida e){
	    	
	    }
	}
}
