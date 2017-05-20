package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

public class IntegrationTest {
	private Libreria libreria;
	private ArticuloConSuscripcion revistaBarcelona;
	private ArticuloConSuscripcion revistaElGrafico;
	private Producto elHobbit;
	private Producto lapicera;
	private ArticuloConSuscripcion diarioPagina12;
	private ArticuloConSuscripcion diarioClarin;
	private Cliente juan;
	private Cliente maria;
	private Mes agosto;
	private Mes enero;
	
	@Before
	public void inicializar(){
		libreria = new Libreria();
		elHobbit = new Producto("El Hobbit", "Libro", 50);
		lapicera = new ProductoConIva("Lapicera", "Articulo de libreria", 5);
		juan = new Cliente("Juan", "xxxxx", 55555555);
		maria = new Cliente("Maria", "zzzzzzzz", 8888888);
	}
	
	@Test
	public void juanDeberiaDevolverListaDeCompras(){
		
	}

}
