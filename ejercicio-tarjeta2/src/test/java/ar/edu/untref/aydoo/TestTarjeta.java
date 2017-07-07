package ar.edu.untref.aydoo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTarjeta {
	
	@Test
	public void laTarjetaDeberiaSerPremium(){
		Tarjeta tarjeta = new Tarjeta("Premium");
		String valorEsperado = "Premium";
		
		String valorObtenido = tarjeta.getRangoTarjeta();
		
		assertEquals(valorEsperado, valorObtenido);
	}

}
