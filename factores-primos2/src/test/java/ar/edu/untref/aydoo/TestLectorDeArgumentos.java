/*package ar.edu.untref.aydoo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLectorDeArgumentos {

	@Test
	public void factoresPrimosDe1Devuelve1() {
		Programa lector = new Programa();
		String[] cadena = {"java","-jar", "factores-primos.jar", "1"};
		lector.leerArgumentos(cadena);
	}
	
	@Test
	public void factoresPrimosDe360Devuelve2x2x2x3x3x5() {
		Programa lector = new Programa();
		String[] cadena = {"java","-jar", "factores-primos.jar", "360"};
		lector.leerArgumentos(cadena);
	}
	
	@Test
	public void tresArgumentosDaError(){
		Programa lector = new Programa();
		String[] cadena = {"-jar", "factores-primos.jar", "360"};
		lector.leerArgumentos(cadena);
	}
	
	@Test
	public void cincoArgumentosDaError(){
		Programa lector = new Programa();
		String[] cadena = {"java","-jar", "factores-primos.jar", "360", "kkk"};
		lector.leerArgumentos(cadena);
	}
	
	@Test
	public void cuartoArgumentoNoEsUnNumeroDaError(){
		Programa lector = new Programa();
		String[] cadena = {"java","-jar", "factores-primos.jar", "kkk"};
		lector.leerArgumentos(cadena);
	}
	
	@Test
	public void factoresPrimosDe0DevuelveMenos1() {
		Programa lector = new Programa();
		String[] cadena = {"java","-jar", "factores-primos.jar", "0"};
		lector.leerArgumentos(cadena);
	}

}
*/