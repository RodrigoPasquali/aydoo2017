package ar.edu.untref.aydoo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

public class TestSucursal {

	@Test
	public void laSucursalDeberiaDevolver2VentasEnDiciembre() {
		Mes diciembre = Mes.Diciembre;
		Sucursal s1 = new Sucursal("S1");
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", tarjetaPremium);
		descuento10.setPorcentajeDescuento(10);
		Producto hamburguesa = new Producto("Hamburguesa", 100);
		Producto papas = new Producto("Papas", 50);
		Compra compraHamburguesa = new Compra(tarjetaPremium, s1, diciembre);
		compraHamburguesa.agregarProducto(hamburguesa);
		compraHamburguesa.setBeneficio("descuentO");
		Compra compraPapas = new Compra(tarjetaPremium, s1, diciembre);
		compraPapas.agregarProducto(papas);
		compraPapas.setBeneficio("descuentO");
		s1.agregarVenta(compraHamburguesa);
		s1.agregarVenta(compraPapas);
		Mes enero = Mes.Enero;
		Producto combo = new Producto("Combo", 200);
		Compra compraCombo = new Compra(tarjetaPremium, s1, enero);
		compraCombo.agregarProducto(combo);
		compraCombo.setBeneficio("descuentO");
		s1.agregarVenta(compraCombo);
		int valorEsperado = 2;
		
		int valorObtenido = s1.getCantidadDeVentasEnMes(diciembre);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void getListaDeVentasDeberiaDevolverUnaListaConLasVentasRealizadas() {
		Mes diciembre = Mes.Diciembre;
		Sucursal s1 = new Sucursal("S1");
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", tarjetaPremium);
		descuento10.setPorcentajeDescuento(10);
		Producto hamburguesa = new Producto("Hamburguesa", 100);
		Producto papas = new Producto("Papas", 50);
		Compra compraHamburguesa = new Compra(tarjetaPremium, s1, diciembre);
		compraHamburguesa.agregarProducto(hamburguesa);
		compraHamburguesa.setBeneficio("descuentO");
		Compra compraPapas = new Compra(tarjetaPremium, s1, diciembre);
		compraPapas.agregarProducto(papas);
		compraPapas.setBeneficio("descuentO");
		s1.agregarVenta(compraHamburguesa);
		s1.agregarVenta(compraPapas);
		Mes enero = Mes.Enero;
		Producto combo = new Producto("Combo", 200);
		Compra compraCombo = new Compra(tarjetaPremium, s1, enero);
		compraCombo.agregarProducto(combo);
		compraCombo.setBeneficio("descuentO");
		s1.agregarVenta(compraCombo);
		List<Compra> valorEsperado = new LinkedList<Compra>();
		valorEsperado.add(compraHamburguesa);
		valorEsperado.add(compraPapas);
		valorEsperado.add(compraCombo);
		
		List<Compra> valorObtenido = s1.getListaDeVentas();
		
		assertEquals(valorEsperado, valorObtenido);
	}
}
