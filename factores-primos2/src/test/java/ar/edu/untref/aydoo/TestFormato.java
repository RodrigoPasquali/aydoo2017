package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Collections;


import org.junit.Assert;
import org.junit.Test;

public class TestFormato {
	
	@Test
	public void formatoPrettyDevuelveFactorPrimosDe360EnFormatoPretty(){
		String formato = "--format=pretty";
		ArrayList<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(2);
		factoresPrimos.add(5);
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		Collections.sort(factoresPrimos);
		int numero = 360;
		Formato formatear = new Formato();
		
		formatear.aplicarFormato(formato, factoresPrimos, numero);
		System.out.println("------------------------------------");

	}
	
	@Test
	public void formatopREttyDevuelveFactorPrimosDe90EnFormatoPretty(){
		String formato = "--format=pREtty";
		System.out.println("--format=pREtty");

		ArrayList<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		factoresPrimos.add(5);
		factoresPrimos.add(3);
		
		Collections.sort(factoresPrimos);
		int numero = 90;
		Formato formatear = new Formato();
		
		System.out.println(formatear.aplicarFormato(formato, factoresPrimos, numero));
		System.out.println("------------------------------------");

	}
	
	
	@Test
	public void formatoQuietDevuelveFactorPrimosDe360EnFormatoQuiet(){
		String formato = "--format=quiet";
		ArrayList<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(2);
		factoresPrimos.add(5);
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		factoresPrimos.add(2);
		factoresPrimos.add(3);
		Collections.sort(factoresPrimos);
		int numero = 360;
		Formato formatear = new Formato();
		
		formatear.aplicarFormato(formato, factoresPrimos, numero);
		System.out.println("------------------------------------");

	}
	
	
	
	@Test
	public void formatoqUIetDevuelveFactorPrimosDe15EnFormatoQuiet(){
		String formato = "--format=qUIet";
		System.out.println("--format=qUIet");
		ArrayList<Integer> factoresPrimos = new ArrayList<Integer>();
		factoresPrimos.add(3);
		factoresPrimos.add(5);
	
		Collections.sort(factoresPrimos);
		int numero = 15;
		Formato formatear = new Formato();
		
		System.out.println(formatear.aplicarFormato(formato, factoresPrimos, numero));
		System.out.println("------------------------------------");
	}
	
}
