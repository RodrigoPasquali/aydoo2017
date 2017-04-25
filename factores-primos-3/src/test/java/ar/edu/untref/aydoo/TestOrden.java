package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestOrden {
	
	@Test
	public void deberiaOrdenarLaListaDeNumerosDeFormaAscendente(){
		Orden ordenador = new Orden();
		List<Integer> listaNumeros = new LinkedList<Integer>();
		listaNumeros.add(25);
		listaNumeros.add(3);
		listaNumeros.add(50);
		listaNumeros.add(10);
		List<Integer> listaEsperada = new LinkedList<Integer>();
		listaEsperada.add(0, 3);
		listaEsperada.add(1, 10);
		listaEsperada.add(2, 25);
		listaEsperada.add(3, 50);

		List<Integer> listaActual = ordenador.ordenAscendente(listaNumeros);
		
		assertEquals(listaEsperada, listaActual);
	}
	
	@Test
	public void deberiaOrdenarLaListaDeNumerosDeFormaDescendete(){
		Orden ordenador = new Orden();
		List<Integer> listaNumeros = new LinkedList<Integer>();
		listaNumeros.add(25);
		listaNumeros.add(3);
		listaNumeros.add(50);
		listaNumeros.add(10);
		List<Integer> listaEsperada = new LinkedList<Integer>();
		listaEsperada.add(0, 50);
		listaEsperada.add(1, 25);
		listaEsperada.add(2, 10);
		listaEsperada.add(3, 3);
		
		List<Integer> listaActual = ordenador.ordenDescendente(listaNumeros);
		
		assertEquals(listaEsperada, listaActual);
	}
	
	@Test
	public void ordenarNumerosDeberiaDevolverListaDeNumerosDeFormaAscendete(){
		Orden ordenador = new Orden();
		List<Integer> listaNumeros = new LinkedList<Integer>();
		listaNumeros.add(25);
		listaNumeros.add(3);
		listaNumeros.add(50);
		listaNumeros.add(10);
		List<Integer> listaEsperada = new LinkedList<Integer>();
		listaEsperada.add(0, 3);
		listaEsperada.add(1, 10);
		listaEsperada.add(2, 25);
		listaEsperada.add(3, 50);
		String orden = "--sort=asc";
		
		ordenador.ordenarNumeros(listaNumeros, orden);
		List<Integer> listaActual = ordenador.getOrdenDeNumeros();
		
		assertEquals(listaEsperada, listaActual);
	}
	
	@Test
	public void ordenarNumerosDeberiaDevolverListaDeNumerosDeFormaDescendente(){
		Orden ordenador = new Orden();
		List<Integer> listaNumeros = new LinkedList<Integer>();
		listaNumeros.add(25);
		listaNumeros.add(3);
		listaNumeros.add(50);
		listaNumeros.add(10);
		List<Integer> listaEsperada = new LinkedList<Integer>();
		listaEsperada.add(0, 50);
		listaEsperada.add(1, 25);
		listaEsperada.add(2, 10);
		listaEsperada.add(3, 3);
		String orden = "--sort=desc";

		ordenador.ordenarNumeros(listaNumeros, orden);
		List<Integer> listaActual = ordenador.getOrdenDeNumeros();
		
		assertEquals(listaEsperada, listaActual);
	}
	
	@Test
	public void ordenarNumerosSinIndicarOrdenDeberiaDevolverListaDeNumerosDeFormaAscendente(){
		Orden ordenador = new Orden();
		List<Integer> listaNumeros = new LinkedList<Integer>();
		listaNumeros.add(25);
		listaNumeros.add(3);
		listaNumeros.add(50);
		listaNumeros.add(10);
		List<Integer> listaEsperada = new LinkedList<Integer>();
		listaEsperada.add(0, 3);
		listaEsperada.add(1, 10);
		listaEsperada.add(2, 25);
		listaEsperada.add(3, 50);
		String orden = "";
		
		ordenador.ordenarNumeros(listaNumeros, orden);
		List<Integer> listaActual = ordenador.getOrdenDeNumeros();
		
		assertEquals(listaEsperada, listaActual);
	}

}
