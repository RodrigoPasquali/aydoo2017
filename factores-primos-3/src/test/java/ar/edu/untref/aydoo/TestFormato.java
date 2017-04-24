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
		String orden = "--sort:asc";
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
		
		String valorActual = formatear.aplicarFormato(formato, factoresPrimos, numero, orden);
		
		Assert.assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void formatopREttyDevuelveFactorPrimosDe90EnFormatoPretty(){
		int numero = 90;
		String formato = "--format=pREtty";
		String orden = "--sort:asc";
		List<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		factoresPrimos.add(5);
		factoresPrimos.add(3);
		Collections.sort(factoresPrimos);
		Formato formatear = new Formato();
		String valorEsperado = "Factores primos de 90 : 2 3 3 5 ";
		
		String valorActual = formatear.aplicarFormato(formato, factoresPrimos, numero, orden);
		
		Assert.assertEquals(valorEsperado, valorActual);
	}
	
	
	@Test
	public void formatoQuietDevuelveFactorPrimosDe360EnFormatoQuiet(){
		int numero = 360;
		String formato = "--format=quiet";
		String orden = "--sort:asc";
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
		
		String valorActual = formatear.aplicarFormato(formato, factoresPrimos, numero, orden);
		
		Assert.assertEquals(valorEsperando, valorActual);
	}
	
	
	
	@Test
	public void formatoqUIetDevuelveFactorPrimosDe15EnFormatoQuiet(){
		int numero = 15;
		String formato = "--format=qUIet";
		String orden = "--sort:asc";
		List<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(3);
		factoresPrimos.add(5);
		Collections.sort(factoresPrimos);
		Formato formatear = new Formato();
		String valorEsperado = "3\r\n" + 
								"5\r\n";
		
		String valorAcutal = formatear.aplicarFormato(formato, factoresPrimos, numero, orden);
		
		Assert.assertEquals(valorEsperado, valorAcutal);
	}
	
	@Test
	public void formatoSinEspecificarDevuelveFormatoPretty(){
		int numero = 90;
		String formato = "";
		String orden = "--sort:asc";
		List<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		factoresPrimos.add(5);
		factoresPrimos.add(3);
		Collections.sort(factoresPrimos);
		Formato formatear = new Formato();
		String valorEsperado = "Factores primos de 90 : 2 3 3 5 ";
		
		String valorActual = formatear.aplicarFormato(formato, factoresPrimos, numero, orden);
		
		Assert.assertEquals(valorEsperado, valorActual);
	}
	
}
