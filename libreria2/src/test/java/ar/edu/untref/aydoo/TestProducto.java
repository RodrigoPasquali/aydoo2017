package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TestProducto {
	
	@Test
	public void precioDeLibroNoDeberiaAplicarseIva(){
		Producto elHobbit = new Producto("El Hobbit", "libro", 50);
		double valorEsperado = 50;
		
		double valorObtenido = elHobbit.obtenerPrecio();
		
		Assert.assertEquals(valorEsperado, valorObtenido, 0.01);
	}
	
	@Test
	public void precioDeArticuloDeLibreriaDeberiaAplicarseIva(){
		Producto lapicera = new ProductoConIva("Simbol", "Articulo de Libreria", 5);
		double valorEsperado = 5*1.21;
		
		double valorObtenido = lapicera.obtenerPrecio();
		
		Assert.assertEquals(valorEsperado, valorObtenido, 0.01);
	}

}
