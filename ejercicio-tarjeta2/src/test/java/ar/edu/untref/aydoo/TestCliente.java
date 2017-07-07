package ar.edu.untref.aydoo;


import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestCliente {

	@Test
	public void juanDeberiaTenerTarjetaPremium(){
		Cliente juan = new Cliente("Juan", "juan@gamil.com");
		Tarjeta tarjetaClassic = new Tarjeta("Classic");
		juan.setTarjeta(tarjetaClassic);		
		Tarjeta valorEsperado = tarjetaClassic;
		
		Tarjeta valorObtenido = juan.getTarjeta();
		
		assertEquals(valorEsperado, valorObtenido);	
	}
	
}
