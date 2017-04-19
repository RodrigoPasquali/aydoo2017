package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClubTest {

	@Test
	public void EstablecimientoQueOtorgoMasBeneficiosDeberiaSerRestaurantB(){
		Club club = new Club("Club de Beneficios");
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
	
	@Test
	public void MailDeFelicitacionesDeberiaLlegarARestaurantB(){
		Club club = new Club("Club de Beneficios");
		Establecimiento restaurantB = new Establecimiento("Restaurant B");	
		Establecimiento heladeriaA = new Establecimiento("Heladeria A");
		Sucursal sucursalS1 = new Sucursal("S1", restaurantB);
		MailDeFelicitaciones mail;
	
		club.agregarEstablecimientos(restaurantB);
		restaurantB.agregarSucursales(sucursalS1);
		sucursalS1.registrarCompra();
		mail = new MailDeFelicitaciones(club.getEstablecimientoQueOtorgoMasBeneficios());
		mail.setTexto("Felicitaciones Restaurant B");
		club.enviarMaildeFelicitaciones(mail);
		MailDeFelicitaciones valorEsperado = mail;
		MailDeFelicitaciones valorActual = restaurantB.getMailDeFelicitacion();
		
		assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void S4DeberiaSerSucursalQueMasBeneficiosOtorgo(){
		Club club = new Club("Club de Beneficios");
		Establecimiento heladeriaA = new Establecimiento("Heladeria A");
		Sucursal sucursalS1 = new Sucursal("S1", heladeriaA);
		Sucursal sucursalS2 = new Sucursal("S2", heladeriaA);
		Sucursal sucursalS3 = new Sucursal("S3", heladeriaA);
		Establecimiento restaurantB = new Establecimiento("Restaurant B");
		Sucursal sucursalS4 = new Sucursal("S4", restaurantB);
		Establecimiento ropaC = new Establecimiento("Ropa C");
		Sucursal sucursalS5 = new Sucursal("S5", ropaC);
		Sucursal valorEsperado = sucursalS4;
		
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
		Sucursal valorActual = club.getSucursalQueOtorgoMasBeneficios();
		
		assertEquals(valorEsperado, valorActual);
	}
	
}
