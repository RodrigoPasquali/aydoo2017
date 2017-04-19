package ar.edu.untref.aydoo;


import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class EstablecimientoTest {
	
	@Test
	public void SucursalS2OtorgaMasBeneficios(){
		Establecimiento heladeriaA = new Establecimiento("HeladeriaA");
		Sucursal sucursalS1 = new Sucursal("S1", heladeriaA);
		Sucursal sucursalS2 = new Sucursal("S2", heladeriaA);
		Sucursal sucursalS3 = new Sucursal("S3", heladeriaA);
		
		heladeriaA.agregarSucursales(sucursalS1);
		heladeriaA.agregarSucursales(sucursalS2);
		heladeriaA.agregarSucursales(sucursalS3);
		sucursalS1.registrarCompra();
		sucursalS1.registrarCompra();
		sucursalS2.registrarCompra();
		sucursalS2.registrarCompra();
		sucursalS2.registrarCompra();
		sucursalS3.registrarCompra();
		
		assertEquals(sucursalS2, heladeriaA.getSucursalQueOtorgoMasBeneficios());
	}
	
	@Test
	public void CantidadDeBeneficiosOtorgadosDeberiaDevolver5(){
		Establecimiento heladeriaA = new Establecimiento("HeladeriaA");
		Sucursal sucursalS1 = new Sucursal("S1", heladeriaA);
		Sucursal sucursalS2 = new Sucursal("S2", heladeriaA);
		Sucursal sucursalS3 = new Sucursal("S3", heladeriaA);
		int valorEsperado = 5;
		
		heladeriaA.agregarSucursales(sucursalS1);
		heladeriaA.agregarSucursales(sucursalS2);
		heladeriaA.agregarSucursales(sucursalS3);
		sucursalS1.registrarCompra();
		sucursalS1.registrarCompra();
		sucursalS2.registrarCompra();
		sucursalS2.registrarCompra();
		sucursalS3.registrarCompra();
		int valorActual = heladeriaA.getCantidadDeBeneficiosOtorgados();
		
		assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void CantidadDeBeneficiosOtorgadosDeberiaSer0(){
		Establecimiento heladeriaA = new Establecimiento("HeladeriaA");
		int valorEsperado = 0;
		
		int valorActual = heladeriaA.getCantidadDeBeneficiosOtorgados();
		
		assertEquals(valorEsperado, valorActual);
	}

}
