package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestEjecutador {
	
	@Test
	public void salidaDeberiaDevolverFactoresPrimosDe360ConFormatoQuietOrdenDesc(){
		String[] entrada = {"360", "--format=quiet", "--sort=desc"};
		String valorEsperado = "5\r\n" + 
								"3\r\n" + 
								"3\r\n" + 
								"2\r\n" + 
								"2\r\n" + 
								"2\r\n";
		Ejecutador ejecutador = new Ejecutador();
		
		ejecutador.ejecutarPeticion(entrada);
		String valorActual = ejecutador.getSalida();
		
		assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void siPrimerArgumentoNoEsNumeroDeberiaDevolverMensajeDeError(){
		String[] entrada = {"kk", "--format=quiet", "--sort=desc"};
		String valorEsperado = "El primer argumento debe ser un numero";
		Ejecutador ejecutador = new Ejecutador();
		
		ejecutador.ejecutarPeticion(entrada);
		String valorActual = ejecutador.getSalida();
		
		assertEquals(valorEsperado, valorActual);
	}

	@Test
	public void salidaDeberiaDevolverFactoresPrimosDe100ConFormatoPrettyOrdenAsc(){
		String[] entrada = {"100", "--format=pretty", "--sort=asc", "--output-file=salida.txt"};
		String valorEsperado = "Factores primos de 100 : 2 2 5 5 ";
		Ejecutador ejecutador = new Ejecutador();
		
		ejecutador.ejecutarPeticion(entrada);
		String valorActual = ejecutador.getSalida();
		
		assertEquals(valorEsperado, valorActual);
	}
	
}
