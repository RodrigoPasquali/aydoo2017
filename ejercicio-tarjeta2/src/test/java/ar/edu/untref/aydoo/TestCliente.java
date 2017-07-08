package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCliente {

	@Test
	public void juanDeberiaTenerTarjetaPremium() {
		Cliente juan = new Cliente("Juan", "juan@gamil.com");
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		juan.setTarjeta(tarjetaPremium);		
		Tarjeta valorEsperado = tarjetaPremium;
		
		Tarjeta valorObtenido = juan.getTarjeta();
		
		assertEquals(valorEsperado, valorObtenido);	
	}
	
	@Test
	public void getListaDeComprasDeberiaDevolverLaListaDeComorasDeJuan1Producto() {
		Cliente juan = new Cliente("Juan", "juan@gamil.com");
		Producto helado = new Producto(100);
		Compra compraDeJuan = new Compra(null, null);
		compraDeJuan.agregarProducto(helado);
		List<Compra> valorEsperado = new LinkedList<Compra>();
		valorEsperado.add(compraDeJuan);
		
		juan.registrarCompra(compraDeJuan, null);
		List<Compra> valorObtenido = juan.getListaDeCompras();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void getListaDeCompraDeberiaDevolverLaListaDeJuanCon2Productos() {
		Cliente juan = new Cliente("Juan", "juan@gamil.com");
		Producto helado = new Producto(100);
		Producto hamburguesa = new Producto(70);
		Compra compraHeladeria = new Compra(null, null);
		Compra compraRestaurant = new Compra(null, null);
		compraHeladeria.agregarProducto(helado);
		compraRestaurant.agregarProducto(hamburguesa);
		List<Compra> valorEsperado = new LinkedList<Compra>();
		valorEsperado.add(compraHeladeria);
		valorEsperado.add(compraRestaurant);
		
		juan.registrarCompra(compraHeladeria, null);
		juan.registrarCompra(compraRestaurant, null);
		List<Compra> valorObtenido = juan.getListaDeCompras();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
}
