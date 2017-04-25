package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestFormato {
	
	@Test
	public void formatoPrettyDevuelveFactorPrimosDe360EnFormatoPretty(){
		int numero = 360;
		String formato = "--format=pretty";
		List<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(2);
		factoresPrimos.add(5);
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		Collections.sort(factoresPrimos);
		Formato formatear = new Formato();
		String valorEsperado = "Factores primos de 360 : 2 2 2 3 3 5 ";
		
		String valorActual = formatear.aplicarFormato(formato, factoresPrimos, numero);
		
		Assert.assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void formatopREttyDevuelveFactorPrimosDe90EnFormatoPretty(){
		int numero = 90;
		String formato = "--format=pREtty";
		List<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		factoresPrimos.add(5);
		factoresPrimos.add(3);
		Collections.sort(factoresPrimos);
		Formato formatear = new Formato();
		String valorEsperado = "Factores primos de 90 : 2 3 3 5 ";
		
		String valorActual = formatear.aplicarFormato(formato, factoresPrimos, numero);
		
		Assert.assertEquals(valorEsperado, valorActual);
	}
	
	
	@Test
	public void formatoQuietDevuelveFactorPrimosDe360EnFormatoQuiet(){
		int numero = 360;
		String formato = "--format=quiet";
		List<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(5);
		factoresPrimos.add(5);
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		Collections.sort(factoresPrimos);
		Formato formatear = new Formato();
		String valorEsperando = "2\r\n" + 
								"2\r\n" + 
								"3\r\n" + 
								"3\r\n" + 
								"5\r\n" + 
								"5\r\n" ;
		
		String valorActual = formatear.aplicarFormato(formato, factoresPrimos, numero);
		
		Assert.assertEquals(valorEsperando, valorActual);
	}
	
	
	
	@Test
	public void formatoqUIetDevuelveFactorPrimosDe15EnFormatoQuiet(){
		int numero = 15;
		String formato = "--format=qUIet";
		List<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(3);
		factoresPrimos.add(5);
		Collections.sort(factoresPrimos);
		Formato formatear = new Formato();
		String valorEsperado = "3\r\n" + 
								"5\r\n";
		
		String valorAcutal = formatear.aplicarFormato(formato, factoresPrimos, numero);
		
		Assert.assertEquals(valorEsperado, valorAcutal);
	}
	
	@Test
	public void formatoIgualYerbaDevuelveMensajeDeError(){
		int numero = 90;
		String formato = "--format=yerba";
		List<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		factoresPrimos.add(5);
		factoresPrimos.add(3);
		Collections.sort(factoresPrimos);
		Formato formatear = new Formato();
		String valorEsperado = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
		
		String valorActual = formatear.aplicarFormato(formato, factoresPrimos, numero);
		
		Assert.assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void formatoSinEspecificarDevuelveFormatoPretty(){
		int numero = 90;
		String formato = "";
		List<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		factoresPrimos.add(5);
		factoresPrimos.add(3);
		Collections.sort(factoresPrimos);
		Formato formatear = new Formato();
		String valorEsperado = "Factores primos de 90 : 2 3 3 5 ";
		
		String valorActual = formatear.aplicarFormato(formato, factoresPrimos, numero);
		
		Assert.assertEquals(valorEsperado, valorActual);
	}
	
}
