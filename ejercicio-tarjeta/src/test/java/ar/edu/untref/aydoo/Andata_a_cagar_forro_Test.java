package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Andata_a_cagar_forro_Test{
	
    @Test
    public void elefante(){
        // En enero, Juan compra 2 kg de helado en la sucursal Caseros de la heladeria "Frio" con la tarjeta Premium.
        // La heladeria Frio vende el helado a $100 por kg y ofrece un descuento del 10% para compras con tarjetas premium.

        String email = "juan@gmail.com";
        Cliente juan = new Cliente("juan", email);
        Tarjeta tarjeta = new Tarjeta(juan);
        Establecimiento heladeriaFrio = new Establecimiento("Heladeria Frio");
        int porcentajeDescuento = 10;
        DescuentoParaTarjetaPremium descuento10 = new DescuentoParaTarjetaPremium(porcentajeDescuento, heladeriaFrio);

        Sucursal caseros = new Sucursal("Caseros", heladeriaFrio);
        int precioUnitario = 100;
        Producto helado = new Producto("Helado", precioUnitario, heladeriaFrio);

        int cantidadDeCompra = 2;
        Compra compraDe2kgDeHelado = new Compra(cantidadDeCompra, helado, caseros, tarjeta);

        assertEquals(1, caseros.getCantidadBeneficiosOtorgados());

   }
    
    @Test
    public void testGrande2() {
    	/*
	    	Carlos tiene tarjeta Classic. Juan tiene tarjeta Premium.
	    	La heladería A ofrece un 10% de descuento con tarjeta Classic y 20% de descuento con tarjeta Premium.
	    	La heladería A tiene las sucursales S1 y S2.
	    	El restaurant B ofrece un 20% de descuento con ambas tarjetas.
	    	El restaurant B tiene una sola sucursal: S3.
	    	Durante Enero, la sucursal S1 realiza 4 beneficios con tarjeta Classic y 3 con tarjeta Premium. Carlos y Juan utilizaron los beneficios con sus tarjetas, una vez cada uno.
	    	La sucursal S2 no realiza beneficios.
	    	La sucursal S3 atendió a 6 clientes y les realizó el beneficio ofrecido. Carlos utilizó su tarjeta Classic para hacer uso del beneficio.
	    	Resultado esperado:
	    	•	La Heladería A es el establecimiento al que se debe felicitar, por ser el que más beneficios realizó.
	    	•	El personal de la sucursal S3 debe recibir el regalo, por ser la sucursal que más beneficios realizó.
	    	•	Carlos debe recibir un mail con la sumatoria de dinero que se ahorró por usar su beneficio en la heladería y el restaurant.
	    	•	Juan debe recibir el mail con lo que ahorró por usar su tarjeta en la heladería
    	 */
    	
    	Cliente carlos = new Cliente("Carlos", "carlos@gmail.com");
    	Tarjeta tarjetaClassicCarlos = new TarjetaClassic(carlos);
    	Cliente juan = new Cliente("Juan", "juan@gmail.com");
    	Tarjeta tarjetaPremiumJuan = new TarjetaPremium(juan);
    	Establecimiento heladeriaA = new Establecimiento("Heladeria A");
    	Descuento descuento10HeladeriaATarjetaPremium = new DescuentoParaTarjetaClassic(10,heladeriaA);
    	Descuento descuento20HeladeriaATarjetaPremium = new DescuentoParaTarjetaPremium(20, heladeriaA);
    	Sucursal sucursalHeladeriaAS1 = new Sucursal("S1", heladeriaA);
    	Sucursal sucursalHeladeriaAS2 = new Sucursal("S2", heladeriaA);
    	heladeriaA.agregarSucursales(sucursalHeladeriaAS1);
    	heladeriaA.agregarSucursales(sucursalHeladeriaAS2);
    	Establecimiento restaurantB = new Establecimiento("Restaurant B");
    	Descuento descuento20RestaurantBTarjetaClassic = new DescuentoParaTarjetaClassic(20, restaurantB);
    	Descuento descuento20RestaurantBTarjetaPremium = new DescuentoParaTarjetaClassic(20, restaurantB);
    	Sucursal sucursalRestaurantBS3 = new Sucursal("S3", restaurantB);
    	restaurantB.agregarSucursales(sucursalRestaurantBS3);
    	
    	Producto heladoCompradoPorCarlos = new Producto("Helado", 100, heladeriaA);
    	Compra compraDeCarlosEnHeladeriaS1 = new Compra(1, heladoCompradoPorCarlos, sucursalHeladeriaAS1, tarjetaClassicCarlos);
    	Producto heladoCompradoPorJuan = new Producto("Helado", 100, heladeriaA);
    	Compra compraDeJuan = new Compra(1, heladoCompradoPorJuan, sucursalHeladeriaAS1, tarjetaPremiumJuan);
    	Beneficio beneficioS11 = new Beneficio();
    	Beneficio beneficioS12 = new Beneficio();
    	Beneficio beneficioS13 = new Beneficio();
    	Beneficio beneficioS14 = new Beneficio();
    	Beneficio beneficioS15 = new Beneficio();
    	Producto comidaCompradoPorCarlos = new Producto("Comida", 150, restaurantB);
    	Compra compraDeCarlosEnRestaurantS3 = new Compra(1, comidaCompradoPorCarlos, sucursalRestaurantBS3, tarjetaClassicCarlos);
    	Beneficio beneficioS31 = new Beneficio();
    	Beneficio beneficioS32 = new Beneficio();
    	Beneficio beneficioS33 = new Beneficio();
    	Beneficio beneficioS34 = new Beneficio();
    	Beneficio beneficioS35 = new Beneficio();
    }
}
