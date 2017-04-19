package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SucursalTest {
	
	@Test
	public void SucursalOtorgo2BeneficiosEsCorrecto(){
		Sucursal s1 = new Sucursal("S1", null);
		s1.registrarCompra();
		s1.registrarCompra();
		int valorEsperado = 2;
		
		assertEquals(valorEsperado, s1.getCantidadBeneficiosOtorgados());
	}

}
