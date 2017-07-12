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
	
	@Test
	public void laSucursalQueAtendioMasClintesDeberiaSerS1() {
		Tarjeta tarjetaClassic = Tarjeta.CLASSIC;
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Establecimiento heladeriaA = new Establecimiento("Heladeria A");
		Beneficio descuento10Classic = new BeneficioDescuentoPorcentaje("descuento", tarjetaClassic);
		descuento10Classic.setPorcentajeDescuento(10);
		Beneficio descuento20Premium = new BeneficioDescuentoPorcentaje("descuento", tarjetaPremium);
		descuento20Premium.setPorcentajeDescuento(20);
		heladeriaA.agregarBeneficio(descuento20Premium);
		heladeriaA.agregarBeneficio(descuento10Classic);
		Sucursal s1 = new Sucursal("S1");
		heladeriaA.agregarSucursal(s1);
		s1.esUnaSucursalDe(heladeriaA);
		Sucursal s2 = new Sucursal("S2");
		heladeriaA.agregarSucursal(s2);
		s2.esUnaSucursalDe(heladeriaA);
		Sucursal s3 = new Sucursal("S3");
		s3.esUnaSucursalDe(heladeriaA);
		heladeriaA.agregarSucursal(s3);
		Beneficio descuento20Classic = new BeneficioDescuentoPorcentaje("descuento", tarjetaClassic);
		descuento20Classic.setPorcentajeDescuento(20);
		Mes enero = Mes.Enero;
		Producto helado = new Producto(100);
		Compra compraJuanS1 = new Compra(tarjetaPremium, s1, enero);
		compraJuanS1.agregarProducto(helado);
		compraJuanS1.setBeneficio("descuento");
		s1.agregarVenta(compraJuanS1);
		Compra compraCarlosS1 = new Compra(tarjetaClassic, s1, enero);
		compraCarlosS1.agregarProducto(helado);
		compraCarlosS1.setBeneficio("descuento");
		s1.agregarVenta(compraCarlosS1);
		Compra compraClassicS11 = new Compra(tarjetaClassic, s1, enero);
		compraClassicS11.setBeneficio("descuento");
		s1.agregarVenta(compraClassicS11);
		Compra compraClassicS12 = new Compra(tarjetaClassic, s1, enero);
		compraClassicS12.setBeneficio("descuento");
		s1.agregarVenta(compraClassicS12);
		Compra compraClassicS13 = new Compra(tarjetaClassic, s2, enero);
		compraClassicS13.setBeneficio("descuento");
		s2.agregarVenta(compraClassicS13);
		Compra compraPremiumS11 = new Compra(tarjetaPremium, s2, enero);
		compraPremiumS11.setBeneficio("descuento");
		s2.agregarVenta(compraPremiumS11);
		Compra compraPremiumS12 = new Compra(tarjetaPremium, s2, enero);
		compraPremiumS12.setBeneficio("descuento");
		s2.agregarVenta(compraPremiumS12);
		Sucursal valorEsperado = s1;
		
		Sucursal valorObtenido = heladeriaA.getSucursalQueAtendioMasClientesEnMes(enero);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
}
