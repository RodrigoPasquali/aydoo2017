package ar.edu.untref.aydoo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCompra {
	
	@Test
	public void valorFinalDeCompraDeberiaSer90(){
		Establecimiento mcDonal = new Establecimiento("Mc Donals");
		Sucursal s1 = new Sucursal("S1");
		s1.esUnaSucursalDe(mcDonal);
		mcDonal.agregarSucursal(s1);
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", tarjetaPremium);
		descuento10.setPorcentajeDescuento(10);
		mcDonal.agregarBeneficio(descuento10);
		Producto hamburguesa = new Producto("Hamburgusa", 100);
		Cliente juan = new Cliente("juan", "j@");
		juan.setTarjeta(tarjetaPremium);
		Mes agosto = Mes.Agosto;
		Compra compraMcDonal = new Compra(tarjetaPremium, s1, agosto);
		compraMcDonal.agregarProducto(hamburguesa);
		compraMcDonal.setBeneficio("descuentO");
		juan.registrarCompra(compraMcDonal);
		double valorEsperado = 90;
		
		double valorObtenido = compraMcDonal.getPrecioProductosConBeneficio(); 
		assertEquals(valorEsperado, valorObtenido, 0.1);
	}
	
	@Test
	public void valorFinalDeCompraDeberiaSer100CuandoTarjetasSonDistintas(){
		Establecimiento mcDonal = new Establecimiento("Mc Donals");
		Sucursal s1 = new Sucursal("S1");
		s1.esUnaSucursalDe(mcDonal);
		mcDonal.agregarSucursal(s1);
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", tarjetaPremium);
		descuento10.setPorcentajeDescuento(10);
		mcDonal.agregarBeneficio(descuento10);
		Producto hamburguesa = new Producto("Hamburgusa", 100);
		Tarjeta tarjetaCLASSIC = Tarjeta.CLASSIC;
		Mes agosto = Mes.Agosto;
		Compra compraMcDonal = new Compra(tarjetaCLASSIC, s1, agosto);
		compraMcDonal.agregarProducto(hamburguesa);
		compraMcDonal.setBeneficio("descuentO");
		double valorEsperado = 100;
		
		double valorObtenido = compraMcDonal.getPrecioProductosConBeneficio(); 
		assertEquals(valorEsperado, valorObtenido, 0.1);
	}
	
	@Test
	public void valorFinalDeCompraDeberiaSer100Con2x1(){
		Establecimiento mcDonal = new Establecimiento("Mc Donals");
		Sucursal s1 = new Sucursal("S1");
		s1.esUnaSucursalDe(mcDonal);
		mcDonal.agregarSucursal(s1);
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("2x1", tarjetaPremium);
		mcDonal.agregarBeneficio(descuento10);
		Producto hamburguesa = new Producto("Hamburgusa", 100);
		Producto papas = new Producto("Papas", 50);
		Mes agosto = Mes.Agosto;
		Compra compraMcDonal = new Compra(tarjetaPremium, s1, agosto);
		compraMcDonal.agregarProducto(hamburguesa);
		compraMcDonal.agregarProducto(papas);
		compraMcDonal.setBeneficio("2x1");
		double valorEsperado = 100;
		
		double valorObtenido = compraMcDonal.getPrecioProductosConBeneficio(); 
		assertEquals(valorEsperado, valorObtenido, 0.1);
	}
	
	@Test
	public void valorFinalDeCompraDeberiaSer140Con2x1(){
		Establecimiento mcDonal = new Establecimiento("Mc Donals");
		Sucursal s1 = new Sucursal("S1");
		s1.esUnaSucursalDe(mcDonal);
		mcDonal.agregarSucursal(s1);
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("2x1", tarjetaPremium);
		mcDonal.agregarBeneficio(descuento10);
		Producto hamburguesa = new Producto("Hamburgusa", 90);
		Producto papas = new Producto("Papas", 50);
		Mes agosto = Mes.Agosto;
		Compra compraMcDonal = new Compra(tarjetaPremium, s1, agosto);
		compraMcDonal.agregarProducto(hamburguesa);
		compraMcDonal.agregarProducto(papas);
		compraMcDonal.setBeneficio("2x1");
		double valorEsperado = 140;
		
		double valorObtenido = compraMcDonal.getPrecioProductosConBeneficio(); 
		assertEquals(valorEsperado, valorObtenido, 0.1);
	}
	
	@Test
	public void valorFinalDeCompraDeberiaSer150CuandoTarjetasSonDistintas(){
		Establecimiento mcDonal = new Establecimiento("Mc Donals");
		Sucursal s1 = new Sucursal("S1");
		s1.esUnaSucursalDe(mcDonal);
		mcDonal.agregarSucursal(s1);
		Tarjeta tarjetaClassic = Tarjeta.CLASSIC;
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("2x1", tarjetaClassic);
		mcDonal.agregarBeneficio(descuento10);
		Producto hamburguesa = new Producto("Hamburgusa", 100);
		Producto papas = new Producto("Papas", 50);
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Mes agosto = Mes.Agosto;
		Compra compraMcDonal = new Compra(tarjetaPremium, s1, agosto);
		compraMcDonal.agregarProducto(hamburguesa);
		compraMcDonal.agregarProducto(papas);
		compraMcDonal.setBeneficio("2x1");
		double valorEsperado = 150;
		
		double valorObtenido = compraMcDonal.getPrecioProductosConBeneficio(); 
		assertEquals(valorEsperado, valorObtenido, 0.1);
	}
	
}
