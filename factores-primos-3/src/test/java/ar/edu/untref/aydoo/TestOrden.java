package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import excepciones.ExcepcionOrdenInvalido;

public class TestOrden {
	
	@Test
	public void ordenarSinIndicarOrdenDeberiaDevolverListaDeNumerosDeFormaAscendente(){
		String orden = "";
		List<Integer> listaNumeros = new LinkedList<Integer>();
		listaNumeros.add(25);
		listaNumeros.add(3);
		listaNumeros.add(50);
		listaNumeros.add(10);
		Orden ordenador = new OrdenAscendente(orden, listaNumeros);
		List<Integer> listaEsperada = new LinkedList<Integer>();
		listaEsperada.add(0, 3);
		listaEsperada.add(1, 10);
		listaEsperada.add(2, 25);
		listaEsperada.add(3, 50);

		List<Integer> listaActual = ordenador.aplicarOrden();
		
		assertEquals(listaEsperada, listaActual);
	}

	@Test
	public void ordenDescDeberiaOrdenarLaListaDeNumerosDeFormaDescendete(){
		String orden = "--sort=desc";
		List<Integer> listaNumeros = new LinkedList<Integer>();
		listaNumeros.add(25);
		listaNumeros.add(3);
		listaNumeros.add(50);
		listaNumeros.add(10);
		Orden ordenador = new OrdenAscendente(orden, listaNumeros);
		List<Integer> listaEsperada = new LinkedList<Integer>();
		listaEsperada.add(0, 50);
		listaEsperada.add(1, 25);
		listaEsperada.add(2, 10);
		listaEsperada.add(3, 3);
		
		List<Integer> listaActual = ordenador.aplicarOrden();
		
		assertEquals(listaEsperada, listaActual);
	}
	
	@Test
	public void ordenarAscDeberiaDevolverListaDeNumerosDeFormaAscendete(){
		String orden = "--sort=asc";
		List<Integer> listaNumeros = new LinkedList<Integer>();
		listaNumeros.add(25);
		listaNumeros.add(3);
		listaNumeros.add(50);
		listaNumeros.add(10);
		Orden ordenador = new OrdenAscendente(orden, listaNumeros);
		List<Integer> listaEsperada = new LinkedList<Integer>();
		listaEsperada.add(0, 3);
		listaEsperada.add(1, 10);
		listaEsperada.add(2, 25);
		listaEsperada.add(3, 50);
		
		List<Integer> listaActual = ordenador.aplicarOrden();
		
		assertEquals(listaEsperada, listaActual);
	}

	@Test
	public void ordenMesaDeberiaDevolverExpecionOrdenInvalido(){
		String orden = "--sort=mesa";
		List<Integer> listaNumeros = new LinkedList<Integer>();
		listaNumeros.add(25);
		listaNumeros.add(3);
		listaNumeros.add(50);
		listaNumeros.add(10);
		Orden ordenador = new OrdenAscendente(orden, listaNumeros);
		List<Integer> listaEsperada = new LinkedList<Integer>();
		listaEsperada.add(0, 3);
		listaEsperada.add(1, 10);
		listaEsperada.add(2, 25);
		listaEsperada.add(3, 50);
				
		try {
			ordenador.aplicarOrden();
		}catch (ExcepcionOrdenInvalido e){

	    }
	}

}
