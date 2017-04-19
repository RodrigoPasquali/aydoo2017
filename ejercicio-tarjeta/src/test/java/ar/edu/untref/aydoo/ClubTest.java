package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClubTest {

	@Test
	public void EstablecimientoQueOtorgoMasBeneficiosDeberiaSerRestaurantB(){
		Club club = new Club();
		Establecimiento heladeriaA = new Establecimiento("Heladeria A");
		Sucursal sucursalS1 = new Sucursal("S1", heladeriaA);
		Sucursal sucursalS2 = new Sucursal("S2", heladeriaA);
		Sucursal sucursalS3 = new Sucursal("S3", heladeriaA);
		Establecimiento restaurantB = new Establecimiento("Restaurant B");
		Sucursal sucursalS4 = new Sucursal("S4", restaurantB);
		Establecimiento ropaC = new Establecimiento("Ropa C");
		Sucursal sucursalS5 = new Sucursal("S5", ropaC);
		Establecimiento valorEsperado = restaurantB;
		
		club.agregarEstablecimientos(ropaC);
		club.agregarEstablecimientos(restaurantB);
		club.agregarEstablecimientos(heladeriaA);
		heladeriaA.agregarSucursales(sucursalS1);
		heladeriaA.agregarSucursales(sucursalS2);
		heladeriaA.agregarSucursales(sucursalS3);
		restaurantB.agregarSucursales(sucursalS4);
		ropaC.agregarSucursales(sucursalS5);
		sucursalS1.registrarCompra();
		sucursalS1.registrarCompra();
		sucursalS3.registrarCompra();
		sucursalS4.registrarCompra();
		sucursalS4.registrarCompra();
		sucursalS4.registrarCompra();
		sucursalS4.registrarCompra();
		sucursalS4.registrarCompra();
		sucursalS5.registrarCompra();
		
		Establecimiento valorActual = club.getEstablecimientoQueOtorgoMasBeneficios();
		
		assertEquals(valorEsperado, valorActual);
	}
	
}
