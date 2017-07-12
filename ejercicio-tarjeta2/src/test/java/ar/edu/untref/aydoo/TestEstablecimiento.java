package ar.edu.untref.aydoo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

public class TestEstablecimiento {

	@Test
	public void getBeneficioTarjetaClassicDeberiaDevolverDescuento10() {
		Establecimiento establecimiento = new Establecimiento("Fredo");
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Tarjeta tarjetaClassic = Tarjeta.CLASSIC;
		Beneficio beneficio2x1 = new BeneficioDescuentoPorcentaje("2x1", tarjetaPremium);
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", tarjetaClassic);
		establecimiento.agregarBeneficio(beneficio2x1);
		establecimiento.agregarBeneficio(descuento10);
		List<Beneficio> listaEsperada = new LinkedList<Beneficio>();
		listaEsperada.add(descuento10);
		
		List<Beneficio> listaObtenida = establecimiento.getBeneficiosParaTarjeta(tarjetaClassic);
	
		assertEquals(listaEsperada, listaObtenida);
	}
	
	@Test
	public void getBeneficioTarjetaPremiumDeberiaDevolverDescuento10yBeneficio2x1() {
		Establecimiento establecimiento = new Establecimiento("Fredo");
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio beneficio2x1 = new BeneficioDescuentoPorcentaje("2x1",tarjetaPremium);
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", tarjetaPremium);
		establecimiento.agregarBeneficio(beneficio2x1);
		establecimiento.agregarBeneficio(descuento10);
		List<Beneficio> listaEsperada = new LinkedList<Beneficio>();
		listaEsperada.add(0, beneficio2x1);
		listaEsperada.add(1, descuento10);
		
		List<Beneficio> listaObtenida = establecimiento.getBeneficiosParaTarjeta(tarjetaPremium);
	
		assertEquals(listaEsperada, listaObtenida);
	}
	
}
