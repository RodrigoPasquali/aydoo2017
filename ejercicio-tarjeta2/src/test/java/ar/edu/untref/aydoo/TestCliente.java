package ar.edu.untref.aydoo;


import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class TestCliente {

	@Test
	public void juanDeberiaTenerTarjetaPremium() {
		Cliente juan = new Cliente("Juan", "juan@gamil.com");
		Tarjeta tarjetaClassic = new Tarjeta("Premium");
		juan.setTarjeta(tarjetaClassic);		
		Tarjeta valorEsperado = tarjetaClassic;
		
		Tarjeta valorObtenido = juan.getTarjeta();
		
		assertEquals(valorEsperado, valorObtenido);	
	}
	
	@Test
	public void getListaDeComprasDeberiaDevolverLaListaDeComorasDeJuan1Producto() {
		Cliente juan = new Cliente("Juan", "juan@gamil.com");
		Producto helado = new Producto(100, null);
		Compra compraDeJuan = new Compra(helado);
		List<Compra> valorEsperado = new LinkedList<Compra>();
		valorEsperado.add(compraDeJuan);
		
		juan.registrarCompra(compraDeJuan, null);
		List<Compra> valorObtenido = juan.getListaDeCompras();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void getListaDeCompraDeberiaDevolverLaListaDeJuanCon2Productos() {
		Cliente juan = new Cliente("Juan", "juan@gamil.com");
		Producto helado = new Producto(100, null);
		Producto hamburguesa = new Producto(70, null);
		Compra compraHelado = new Compra(helado);
		Compra compraHamburguesa = new Compra(hamburguesa);
		List<Compra> valorEsperado = new LinkedList<Compra>();
		valorEsperado.add(compraHelado);
		valorEsperado.add(compraHamburguesa);
		
		juan.registrarCompra(compraHelado, null);
		juan.registrarCompra(compraHamburguesa, null);
		List<Compra> valorObtenido = juan.getListaDeCompras();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
}
