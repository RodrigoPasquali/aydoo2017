package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import excepciones.ExcepcionSalidaInvalida;

public class TestSalidaConsola {
	@Test
	public void aplicarSalidaSolicitadaDeberiaDevolver335() {
		String salida = "";
		String cadena = "3 3 5";
		SalidaConsola generadorDeSalida = new SalidaConsola(salida, cadena);
		String valorEsperado = "3 3 5";
		
		String valorActual = generadorDeSalida.imprimirEnConsola(cadena);
		
		assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void aplicarSalidaSolicitadaDeberiaDevolverExpecion() {
		String salida = "yayo";
		String cadena = "4 4 4";
		SalidaConsola generadorDeSalida = new SalidaConsola(salida, cadena);
		
		try {
			generadorDeSalida.imprimirEnConsola(cadena);
		}catch (ExcepcionSalidaInvalida e){
	    	
	    }
	}
}
