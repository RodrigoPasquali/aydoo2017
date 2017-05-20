package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
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
		agosto = new MesEnero("agosto");
		enero = new MesEnero("enero");
	}
	
	@Test
	public void deberiaDevolverListaDeMesesDeJuan(){
		juan.agregarMes(enero);
		juan.agregarMes(agosto);
		List<Mes> resultadoEsperado = new LinkedList<Mes>();
		resultadoEsperado.add(enero);
		resultadoEsperado.add(agosto);
		
		List<Mes> resultadoObtenido = juan.getMeses();
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	public void deberiaDevolverListaDeCompraDeMesDeEnero(){
		Compra compraJuanElHobbit = new Compra(elHobbit, 1);
		Compra compraJuanLapicera = new Compra(lapicera, 1);
		juan.agregarCompra(compraJuanElHobbit, enero);
		juan.agregarCompra(compraJuanLapicera, enero);
		juan.agregarMes(enero);
		List<Compra> resultadoEsperado = new LinkedList<Compra>();
		resultadoEsperado.add(compraJuanElHobbit);
		resultadoEsperado.add(compraJuanLapicera);
		
		List<Compra> resultadoObtenido = juan.obtenerComprasDeMes(enero);
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
	}

}
