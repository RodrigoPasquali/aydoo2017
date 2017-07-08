package ar.edu.untref.aydoo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCompra {
	
	@Test 
	public void getProductoCompradoDeberiaDevolverHelado() {
		Producto helado = new Producto(100);
		Compra compra = new Compra(helado);
		Producto valorEsperado = helado;
		
		Producto valorObtenido = compra.getProductoComprado();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
}
