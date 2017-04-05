package ar.edu.untref.aydoo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculadora {
	
	@Test
	public void factoresPrimosDe1Devuelve1(){
		int numero = 1;
		ArrayList<Integer> valorEsperado = new ArrayList<Integer>();
		valorEsperado.add(1);
		ArrayList<Integer> valorObtenido = new ArrayList<Integer>();

		Calculadora calculadora = new Calculadora();
		valorObtenido = calculadora.calcularFactoresPrimos(numero);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	
	@Test
	public void factoresPrimosDe360Devuelve2x2x2x3x3x5(){
		int numero = 360;
		ArrayList<Integer> valorEsperado = new ArrayList<Integer>();
		valorEsperado.add(0,2);
		valorEsperado.add(1,2);
		valorEsperado.add(2,2);
		valorEsperado.add(3,3);
		valorEsperado.add(4,3);
		valorEsperado.add(5,5);
		ArrayList<Integer> valorObtenido = new ArrayList<Integer>();

		Calculadora calculadora = new Calculadora();
		valorObtenido = calculadora.calcularFactoresPrimos(numero);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void factoresPrimosDe90Devuelve2x3x3x5(){
		int numero = 90;
		ArrayList<Integer> valorEsperado = new ArrayList<Integer>();
		valorEsperado.add(0,2);
		valorEsperado.add(1,3);
		valorEsperado.add(2,3);
		valorEsperado.add(3,5);
		ArrayList<Integer> valorObtenido = new ArrayList<Integer>();

		Calculadora calculadora = new Calculadora();
		valorObtenido = calculadora.calcularFactoresPrimos(numero);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void factoresPrimosDe0EsMenos1(){
		
		int numero = 0;
		ArrayList<Integer> valorEsperado = new ArrayList<Integer>();
		valorEsperado.add(-1);
		ArrayList<Integer> valorObtenido = new ArrayList<Integer>();

		Calculadora calculadora = new Calculadora();
		valorObtenido = calculadora.calcularFactoresPrimos(numero);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
		
	}
	
	@Test
	public void factoresPrimosDeMenos1EsMenos1(){
		
		int numero = -1;
		ArrayList<Integer> valorEsperado = new ArrayList<Integer>();
		valorEsperado.add(-1);
		ArrayList<Integer> valorObtenido = new ArrayList<Integer>();

		Calculadora calculadora = new Calculadora();	
		valorObtenido = calculadora.calcularFactoresPrimos(numero);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
		
	}

}
