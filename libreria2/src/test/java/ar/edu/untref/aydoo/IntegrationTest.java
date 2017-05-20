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
	public void deberiaDevolverListaDeCompraDeMesDeEneroDeJuan(){
		Compra compraJuanElHobbit = new Compra(elHobbit, 1);
		Compra compraJuanLapicera = new Compra(lapicera, 1);
		juan.agregarMes(enero);
		juan.agregarCompra(compraJuanElHobbit, enero);
		juan.agregarCompra(compraJuanLapicera, enero);
		List<Compra> resultadoEsperado = new LinkedList<Compra>();
		resultadoEsperado.add(compraJuanElHobbit);
		resultadoEsperado.add(compraJuanLapicera);
		System.out.println(juan.getMeses());

		List<Compra> resultadoObtenido = juan.obtenerComprasDeMes(enero);
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	public void deberiaDevolverComprasDeAgostoCuandoSeCompraEn2Meses(){
		Compra compraJuanElHobbit = new Compra(elHobbit, 1);
		Compra compraJuanLapicera = new Compra(lapicera, 1);
		Compra compraJuanLibrox3 = new Compra(elHobbit, 3);
		juan.agregarMes(agosto);
		juan.agregarCompra(compraJuanElHobbit, agosto);
		juan.agregarCompra(compraJuanLapicera, agosto);
		juan.agregarMes(enero);
		juan.agregarCompra(compraJuanLibrox3, enero);
		List<Compra> resultadoEsperado = new LinkedList<Compra>();
		resultadoEsperado.add(compraJuanElHobbit);
		resultadoEsperado.add(compraJuanLapicera);
		
		List<Compra> resultadoObtenido = juan.obtenerComprasDeMes(agosto);
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	public void debriaDevolverComprasEneroCuandoSeCompraEn2Meses(){
		Compra compraJuanElHobbit = new Compra(elHobbit, 1);
		Compra compraJuanLapicera = new Compra(lapicera, 1);
		Compra compraJuanLibrox3 = new Compra(elHobbit, 3);
		juan.agregarMes(agosto);
		juan.agregarMes(enero);
		juan.agregarCompra(compraJuanElHobbit, agosto);
		juan.agregarCompra(compraJuanLapicera, agosto);
		juan.agregarCompra(compraJuanLibrox3, enero);
		List<Compra> resultadoEsperado = new LinkedList<Compra>();
		resultadoEsperado.add(compraJuanLibrox3);
		
		List<Compra> resultadoObtenido = juan.obtenerComprasDeMes(enero);
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	public void deberiaDevolverListaDeCompraDeMesDeAgostoDeMaria(){
		Compra compraMariaElHobbit = new Compra(elHobbit, 1);
		Compra compraMariaLapicera = new Compra(lapicera, 1);
		maria.agregarMes(agosto);
		maria.agregarCompra(compraMariaElHobbit, agosto);
		maria.agregarCompra(compraMariaLapicera, agosto);
		List<Compra> resultadoEsperado = new LinkedList<Compra>();
		resultadoEsperado.add(compraMariaElHobbit);
		resultadoEsperado.add(compraMariaLapicera);
				
		List<Compra> resultadoObtenido = maria.obtenerComprasDeMes(agosto);
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	public void montoGastadoPorJuanEnEneroDeberiaSerDe112con10(){
		//enero.inicializarListaDeComprasDeMes("enero");
		juan.agregarMes(enero);
		Compra compraJuanLibros = new Compra(elHobbit, 2);
		Compra compraJuanLapiceras = new Compra(lapicera, 2);
		juan.agregarCompra(compraJuanLibros, enero);
		juan.agregarCompra(compraJuanLapiceras, enero);
		double resultadoEsperado = (50 * 2) + (5 * 1.21 * 2);
		
		double resultadoObtenido = libreria.calcularMontoACobrar(enero, juan);
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido, 0.1);
	}
	
	@Test
	public void montoGastadoPorJuanEnAgostoDeberiaSerDe62con10(){
		//agosto.inicializarListaDeComprasDeMes("agosto");
		juan.agregarMes(agosto);
		Compra compraJuanLibros = new Compra(elHobbit, 1);
		Compra compraJuanLapiceras = new Compra(lapicera, 2);
		juan.agregarCompra(compraJuanLibros, agosto);
		juan.agregarCompra(compraJuanLapiceras, agosto);
		double resultadoEsperado = (50) + (5 * 1.21 * 2);
		
		double resultadoObtenido = libreria.calcularMontoACobrar(agosto, juan);
		
		Assert.assertEquals(resultadoEsperado, resultadoObtenido, 0.1);
	}

}
