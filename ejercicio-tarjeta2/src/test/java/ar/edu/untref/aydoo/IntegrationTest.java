package ar.edu.untref.aydoo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IntegrationTest {
	
	@Test
	public void pruebaDeCompra3(){
		Club club = new Club();
		Establecimiento mcDonal = new Establecimiento("Mc Donals");
		club.agregarEstablecimiento(mcDonal);
		Sucursal s1 = new Sucursal("S1");
		s1.esUnaSucursalDe(mcDonal);
		mcDonal.agregarSucursal(s1);
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", tarjetaPremium);
		descuento10.setPorcentajeDescuento(10);
		mcDonal.agregarBeneficio(descuento10);
		Producto hamburguesa = new Producto(100);
		Cliente juan = new Cliente("juan", "j@");
		juan.setTarjeta(tarjetaPremium);
		Compra compraMcDonal = new Compra(tarjetaPremium, s1, null);
		compraMcDonal.agregarProducto(hamburguesa);
		compraMcDonal.setBeneficio("descuentO");
		juan.registrarCompra(compraMcDonal);
		double valorEsperado = 90;
		
		double valorObtenido = compraMcDonal.obtenerPrecioFinal(); 
		assertEquals(valorEsperado, valorObtenido, 0.1);
	}
	
	public void pruebaDeCompra(){
		Club club = new Club();
		Establecimiento mcDonal = new Establecimiento("Mc Donals");
		club.agregarEstablecimiento(mcDonal);
		Sucursal s1 = new Sucursal("S1");
		s1.esUnaSucursalDe(mcDonal);
		mcDonal.agregarSucursal(s1);
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", tarjetaPremium);
		descuento10.setPorcentajeDescuento(10);
		mcDonal.agregarBeneficio(descuento10);
		Producto hamburguesa = new Producto(100);
		Cliente juan = new Cliente("juan", "j@");
		juan.setTarjeta(tarjetaPremium);
		Compra compraMcDonal = new Compra(tarjetaPremium, s1, null);
		compraMcDonal.agregarProducto(hamburguesa);
		compraMcDonal.setBeneficio("descuentO");
		juan.registrarCompra(compraMcDonal);
		double valorEsperado = 90;
		
		double valorObtenido = compraMcDonal.obtenerPrecioFinal(); 
		assertEquals(valorEsperado, valorObtenido, 0.1);
	}
	
	@Test
	public void deberiaDevolver100CuandoSeAplica2x1CuandoSeCompranProductosDe80y100(){
		//	Mateo compra con su tarjeta classic el libro "Martín Fierro" ($100) en la librería 
		//	"El altillo" (sucursal única). Esta librería está asociada al club y ofrece el beneficio 2x1.
		//	Entonces Mateo elige como segundo libro "El Cantar del Cid" ($80) pero como tiene el beneficio 
		//	este segundo libro le resultar gratis. O sea que Mateo se lleva estos dos libros por $100 
		//	(el beneficio 2x1 tomo como referencia el  precio del libro más alto)
		
		Club club = new Club();
		Establecimiento libreria = new Establecimiento("El Altillo");
		club.agregarEstablecimiento(libreria);
		Sucursal sucursalElAltillo = new Sucursal("El Altillo Sucursal");
		sucursalElAltillo.esUnaSucursalDe(libreria);
		libreria.agregarSucursal(sucursalElAltillo);
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio beneficio2x1 = new BeneficioDescuentoPorcentaje("2x1", tarjetaPremium);
		libreria.agregarBeneficio(beneficio2x1);
		Cliente mateo = new Cliente("Mateo", "mat@gmail.com");
		mateo.setTarjeta(tarjetaPremium);
		Producto martinFierro = new Producto(100);
		Producto elCantarDelCid = new Producto(80);
		Mes agosto = Mes.Agosto;
		Compra compraElAltillo = new Compra(tarjetaPremium, sucursalElAltillo, agosto);
		compraElAltillo.agregarProducto(elCantarDelCid);
		compraElAltillo.agregarProducto(martinFierro);
		compraElAltillo.setBeneficio("2x1");
		mateo.registrarCompra(compraElAltillo);
		double valorEsperado = 100;
		
		double valorObtenido = mateo.getMontoGastadoEnMes(agosto);
		
		assertEquals(valorEsperado, valorObtenido, 0.1);
	}
	
	@Test
	public void seDeberiaEnviarMailDeFelicitacionesAHeladeriaAEnEneroPorSerEstablecimientoConMasVentas() {
		// Carlos tiene tarjeta Classic. Juan tiene tarjeta Premium.  
		// La heladería A ofrece un 10% de descuento con tarjeta Classic y 20% de descuento con tarjeta Premium. 
		// La heladería A tiene las sucursales S1y S2.
		// El restaurant B ofrece un 20% de descuento con ambas tarjetas.
		// El restaurant B tiene una sola sucursal: S3. 
		// Durante Enero, la sucursal S1 realiza 4 beneficios con tarjeta Classic y 3 con tarjet Premium.
		// 		Carlos y Juan utilizaron los beneficios con sus tarjetas, una vez cada uno. 
		// La sucursal S2 no realiza beneficios. 
		// La sucursal S3 atendió a 6 clientes y les realizó el beneficio ofrecido.
		//		Carlos utilizó su tarjeta Classic para hacer uso del beneficio.
		// Resultado esperado: OK --> • La Heladería A es el establecimiento al que se debe felicitar, por ser el que más beneficios realizó. 
		
		Cliente carlos = new Cliente("Carlos", "car@gamil");
		Tarjeta tarjetaClassic = Tarjeta.CLASSIC;
		carlos.setTarjeta(tarjetaClassic);
		Cliente juan = new Cliente("Juan", "juan@gmail");
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		juan.setTarjeta(tarjetaPremium);
		Club club = new Club();
		Establecimiento heladeriaA = new Establecimiento("Heladeria A");
		club.agregarEstablecimiento(heladeriaA);
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
		Establecimiento restaurantB = new Establecimiento("Restaurant B");
		club.agregarEstablecimiento(restaurantB);
		Beneficio descuento20Classic = new BeneficioDescuentoPorcentaje("descuento", tarjetaClassic);
		descuento20Classic.setPorcentajeDescuento(20);
		restaurantB.agregarBeneficio(descuento20Classic);
		restaurantB.agregarBeneficio(descuento20Premium);
		Sucursal s3 = new Sucursal("S3");
		restaurantB.agregarSucursal(s3);
		s3.esUnaSucursalDe(restaurantB);
		Mes enero = Mes.Enero;
		Producto helado = new Producto(100);
		Compra compraJuanS1 = new Compra(tarjetaPremium, s1, enero);
		compraJuanS1.agregarProducto(helado);
		compraJuanS1.setBeneficio("descuento");
		juan.registrarCompra(compraJuanS1);
		s1.agregarVenta(compraJuanS1);
		Compra compraCarlosS1 = new Compra(tarjetaClassic, s1, enero);
		compraCarlosS1.agregarProducto(helado);
		compraCarlosS1.setBeneficio("descuento");
		carlos.registrarCompra(compraCarlosS1);
		s1.agregarVenta(compraCarlosS1);
		Compra compraClassicS11 = new Compra(tarjetaClassic, s1, enero);
		compraClassicS11.setBeneficio("descuento");
		s1.agregarVenta(compraClassicS11);
		Compra compraClassicS12 = new Compra(tarjetaClassic, s1, enero);
		compraClassicS12.setBeneficio("descuento");
		s1.agregarVenta(compraClassicS12);
		Compra compraClassicS13 = new Compra(tarjetaClassic, s1, enero);
		compraClassicS13.setBeneficio("descuento");
		s1.agregarVenta(compraClassicS13);
		Compra compraPremiumS11 = new Compra(tarjetaPremium, s1, enero);
		compraPremiumS11.setBeneficio("descuento");
		s1.agregarVenta(compraPremiumS11);
		Compra compraPremiumS12 = new Compra(tarjetaPremium, s1, enero);
		compraPremiumS12.setBeneficio("descuento");
		s1.agregarVenta(compraPremiumS12);
		Producto menuCena = new Producto(250);
		Compra compraCarlosS3 = new Compra(tarjetaClassic, s3, enero);
		compraCarlosS3.agregarProducto(menuCena);
		compraCarlosS3.setBeneficio("descuento");
		carlos.registrarCompra(compraCarlosS3);
		s3.agregarVenta(compraCarlosS3);
		Compra compraS31 = new Compra(tarjetaClassic, s3, enero);
		compraS31.agregarProducto(menuCena);
		s3.agregarVenta(compraS31);
		Compra compraS32 = new Compra(tarjetaClassic, s3, enero);
		compraS32.agregarProducto(menuCena);
		s3.agregarVenta(compraS32);
		Compra compraS33 = new Compra(tarjetaClassic, s3, enero);
		compraS33.agregarProducto(menuCena);
		s3.agregarVenta(compraS33);
		Compra compraS34 = new Compra(tarjetaClassic, s3, enero);
		compraS34.agregarProducto(menuCena);
		s3.agregarVenta(compraS34);
		Compra compraS35 = new Compra(tarjetaClassic, s3, enero);
		compraS35.agregarProducto(menuCena);
		s3.agregarVenta(compraS35);
		String valorEsperado = "Felicidades Heladeria A por ser el establecimiento que mas beneficios otorgo con la cantidad de 7 en el mes de Enero!";

		String valorObtenido = club.felicitarEstablecimientoConMasBeneficiosOtorgadosEnMes(enero).getTexto();
		System.out.println(valorObtenido);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void deberiaDevolver3LaCantidadDeBeneficiosOtorgadosEneroPorLibreria(){
		Club club = new Club();
		Establecimiento libreria = new Establecimiento("El Altillo");
		club.agregarEstablecimiento(libreria);
		Sucursal sucursalElAltillo = new Sucursal("El Altillo Sucursal");
		sucursalElAltillo.esUnaSucursalDe(libreria);
		libreria.agregarSucursal(sucursalElAltillo);
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio beneficio2x1 = new BeneficioDescuentoPorcentaje("2x1",tarjetaPremium);
		libreria.agregarBeneficio(beneficio2x1);
		Producto martinFierro = new Producto(100);
		Producto elCantarDelCid = new Producto(80);
		Mes agosto = Mes.Agosto;
		Compra compra1 = new Compra(tarjetaPremium, sucursalElAltillo, agosto);
		compra1.agregarProducto(elCantarDelCid);
		compra1.agregarProducto(martinFierro);
		compra1.setBeneficio("2x1");
		sucursalElAltillo.agregarVenta(compra1);
		Compra compra2 = new Compra(tarjetaPremium, sucursalElAltillo, agosto);
		compra2.agregarProducto(elCantarDelCid);
		compra2.agregarProducto(martinFierro);
		compra2.setBeneficio("2x1");
		sucursalElAltillo.agregarVenta(compra2);
		Compra compra3 = new Compra(tarjetaPremium, sucursalElAltillo, agosto);
		compra3.agregarProducto(elCantarDelCid);
		compra3.agregarProducto(martinFierro);
		compra3.setBeneficio("2x1");
		sucursalElAltillo.agregarVenta(compra3);
		int valorEsperado = 3;
		
		int valorObtenido = libreria.getCantidadBeneficioOtorgadosEnMes(agosto);
	
		assertEquals(valorEsperado, valorObtenido);
	}
	
	

//	@Test
//	public void elefante() {
//		// En enero, Juan compra 2 kg de helado en la sucursal Caseros de la
//		// heladeria "Frio" con la tarjeta Premium.
//		// La heladeria Frio vende el helado a $100 por kg y ofrece un descuento
//		// del 10% para compras con tarjetas premium.
//
//		String email = "juan@gmail.com";
//		Cliente juan = new Cliente("juan", email);
//		Tarjeta tarjeta = new Tarjeta(juan);
//		Establecimiento heladeriaFrio = new Establecimiento("Heladeria Frio");
//		int porcentajeDescuento = 10;
//		DescuentoParaTarjetaPremium descuento10 = new DescuentoParaTarjetaPremium(porcentajeDescuento, heladeriaFrio);
//
//		Sucursal caseros = new Sucursal("Caseros", heladeriaFrio);
//		int precioUnitario = 100;
//		Producto helado = new Producto("Helado", precioUnitario, heladeriaFrio);
//
//		int cantidadDeCompra = 2;
//		Compra compraDe2kgDeHelado = new Compra(cantidadDeCompra, helado, caseros, tarjeta);
//
//		assertEquals(1, caseros.getCantidadBeneficiosOtorgados());
//
//	}
//
//	@Test
//	public void HeladeriaADeberiaSerEstablecimientoQueMasBeneficiosOtorgo() {
//		/*
//		 * Carlos tiene tarjeta Classic. Juan tiene tarjeta Premium. La
//		 * heladería A ofrece un 10% de descuento con tarjeta Classic y 20% de
//		 * descuento con tarjeta Premium. La heladería A tiene las sucursales S1
//		 * y S2. El restaurant B ofrece un 20% de descuento con ambas tarjetas.
//		 * El restaurant B tiene una sola sucursal: S3. Durante Enero, la
//		 * sucursal S1 realiza 4 beneficios con tarjeta Classic y 3 con tarjeta
//		 * Premium. Carlos y Juan utilizaron los beneficios con sus tarjetas,
//		 * una vez cada uno. La sucursal S2 no realiza beneficios. La sucursal
//		 * S3 atendió a 6 clientes y les realizó el beneficio ofrecido. Carlos
//		 * utilizó su tarjeta Classic para hacer uso del beneficio. Resultado
//		 * esperado: OK --> • La Heladería A es el establecimiento al que se
//		 * debe felicitar, por ser el que más beneficios realizó. • El personal
//		 * de la sucursal S3 debe recibir el regalo, por ser la sucursal que más
//		 * beneficios realizó. • Carlos debe recibir un mail con la sumatoria de
//		 * dinero que se ahorró por usar su beneficio en la heladería y el
//		 * restaurant. • Juan debe recibir el mail con lo que ahorró por usar su
//		 * tarjeta en la heladería
//		 */
//
//		Club club = new Club("Club de Beneficios");
//		Cliente carlos = new Cliente("Carlos", "carlos@gmail.com");
//		Tarjeta tarjetaClassicCarlos = new TarjetaClassic(carlos);
//		Cliente juan = new Cliente("Juan", "juan@gmail.com");
//		Tarjeta tarjetaPremiumJuan = new TarjetaPremium(juan);
//		Establecimiento heladeriaA = new Establecimiento("Heladeria A");
//		Descuento descuento10HeladeriaATarjetaPremium = new DescuentoParaTarjetaClassic(10, heladeriaA);
//		Descuento descuento20HeladeriaATarjetaPremium = new DescuentoParaTarjetaPremium(20, heladeriaA);
//		Sucursal sucursalHeladeriaAS1 = new Sucursal("S1", heladeriaA);
//		Sucursal sucursalHeladeriaAS2 = new Sucursal("S2", heladeriaA);
//		heladeriaA.agregarSucursales(sucursalHeladeriaAS1);
//		heladeriaA.agregarSucursales(sucursalHeladeriaAS2);
//		Establecimiento restaurantB = new Establecimiento("Restaurant B");
//		Descuento descuento20RestaurantBTarjetaClassic = new DescuentoParaTarjetaClassic(20, restaurantB);
//		Descuento descuento20RestaurantBTarjetaPremium = new DescuentoParaTarjetaClassic(20, restaurantB);
//		Sucursal sucursalRestaurantBS3 = new Sucursal("S3", restaurantB);
//		restaurantB.agregarSucursales(sucursalRestaurantBS3);
//		club.agregarEstablecimientos(heladeriaA);
//		club.agregarEstablecimientos(restaurantB);
//		Establecimiento establecimientoQueOtorgoMasBeneficios;
//		MailDeFelicitaciones mailRecibidoEsperado;
//		MailDeFelicitaciones mailRecibidoActual;
//
//		Producto heladoCompradoPorCarlos = new Producto("Helado", 100, heladeriaA);
//		Compra compraDeCarlosEnHeladeriaS1 = new Compra(1, heladoCompradoPorCarlos, sucursalHeladeriaAS1,
//				tarjetaClassicCarlos);
//		sucursalHeladeriaAS1.registrarCompra();
//		Producto heladoCompradoPorJuan = new Producto("Helado", 100, heladeriaA);
//		Compra compraDeJuan = new Compra(1, heladoCompradoPorJuan, sucursalHeladeriaAS1, tarjetaPremiumJuan);
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		Producto comidaCompradoPorCarlos = new Producto("Comida", 150, restaurantB);
//		Compra compraDeCarlosEnRestaurantS3 = new Compra(1, comidaCompradoPorCarlos, sucursalRestaurantBS3,
//				tarjetaClassicCarlos);
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		establecimientoQueOtorgoMasBeneficios = club.getEstablecimientoQueOtorgoMasBeneficios();
//		MailDeFelicitaciones mail = new MailDeFelicitaciones(establecimientoQueOtorgoMasBeneficios);
//		club.enviarMaildeFelicitaciones(mail);
//		mailRecibidoEsperado = mail;
//		mailRecibidoActual = establecimientoQueOtorgoMasBeneficios.getMailDeFelicitacion();
//
//		assertEquals(heladeriaA, establecimientoQueOtorgoMasBeneficios);
//	}
//
//	@Test
//	public void heladeriaADeberiaRecibirMailDeFelicitaciones() {
//		/*
//		 * Carlos tiene tarjeta Classic. Juan tiene tarjeta Premium. La
//		 * heladería A ofrece un 10% de descuento con tarjeta Classic y 20% de
//		 * descuento con tarjeta Premium. La heladería A tiene las sucursales S1
//		 * y S2. El restaurant B ofrece un 20% de descuento con ambas tarjetas.
//		 * El restaurant B tiene una sola sucursal: S3. Durante Enero, la
//		 * sucursal S1 realiza 4 beneficios con tarjeta Classic y 3 con tarjeta
//		 * Premium. Carlos y Juan utilizaron los beneficios con sus tarjetas,
//		 * una vez cada uno. La sucursal S2 no realiza beneficios. La sucursal
//		 * S3 atendió a 6 clientes y les realizó el beneficio ofrecido. Carlos
//		 * utilizó su tarjeta Classic para hacer uso del beneficio. Resultado
//		 * esperado: • La Heladería A es el establecimiento al que se debe
//		 * felicitar, por ser el que más beneficios realizó. OK --> • El
//		 * personal de la sucursal S3 debe recibir el regalo, por ser la
//		 * sucursal que más beneficios realizó. • Carlos debe recibir un mail
//		 * con la sumatoria de dinero que se ahorró por usar su beneficio en la
//		 * heladería y el restaurant. • Juan debe recibir el mail con lo que
//		 * ahorró por usar su tarjeta en la heladería
//		 */
//
//		Club club = new Club("Club de Beneficios");
//		Cliente carlos = new Cliente("Carlos", "carlos@gmail.com");
//		Tarjeta tarjetaClassicCarlos = new TarjetaClassic(carlos);
//		Cliente juan = new Cliente("Juan", "juan@gmail.com");
//		Tarjeta tarjetaPremiumJuan = new TarjetaPremium(juan);
//		Establecimiento heladeriaA = new Establecimiento("Heladeria A");
//		Descuento descuento10HeladeriaATarjetaPremium = new DescuentoParaTarjetaClassic(10, heladeriaA);
//		Descuento descuento20HeladeriaATarjetaPremium = new DescuentoParaTarjetaPremium(20, heladeriaA);
//		Sucursal sucursalHeladeriaAS1 = new Sucursal("S1", heladeriaA);
//		Sucursal sucursalHeladeriaAS2 = new Sucursal("S2", heladeriaA);
//		heladeriaA.agregarSucursales(sucursalHeladeriaAS1);
//		heladeriaA.agregarSucursales(sucursalHeladeriaAS2);
//		Establecimiento restaurantB = new Establecimiento("Restaurant B");
//		Descuento descuento20RestaurantBTarjetaClassic = new DescuentoParaTarjetaClassic(20, restaurantB);
//		Descuento descuento20RestaurantBTarjetaPremium = new DescuentoParaTarjetaClassic(20, restaurantB);
//		Sucursal sucursalRestaurantBS3 = new Sucursal("S3", restaurantB);
//		restaurantB.agregarSucursales(sucursalRestaurantBS3);
//		club.agregarEstablecimientos(heladeriaA);
//		club.agregarEstablecimientos(restaurantB);
//		Establecimiento establecimientoQueOtorgoMasBeneficios;
//		MailDeFelicitaciones mailRecibidoEsperado;
//		MailDeFelicitaciones mailRecibidoActual;
//
//		Producto heladoCompradoPorCarlos = new Producto("Helado", 100, heladeriaA);
//		Compra compraDeCarlosEnHeladeriaS1 = new Compra(1, heladoCompradoPorCarlos, sucursalHeladeriaAS1,
//				tarjetaClassicCarlos);
//		sucursalHeladeriaAS1.registrarCompra();
//		Producto heladoCompradoPorJuan = new Producto("Helado", 100, heladeriaA);
//		Compra compraDeJuan = new Compra(1, heladoCompradoPorJuan, sucursalHeladeriaAS1, tarjetaPremiumJuan);
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		Producto comidaCompradoPorCarlos = new Producto("Comida", 150, restaurantB);
//		Compra compraDeCarlosEnRestaurantS3 = new Compra(1, comidaCompradoPorCarlos, sucursalRestaurantBS3,
//				tarjetaClassicCarlos);
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		establecimientoQueOtorgoMasBeneficios = club.getEstablecimientoQueOtorgoMasBeneficios();
//		MailDeFelicitaciones mail = new MailDeFelicitaciones(establecimientoQueOtorgoMasBeneficios);
//		club.enviarMaildeFelicitaciones(mail);
//		mailRecibidoEsperado = mail;
//		mailRecibidoActual = establecimientoQueOtorgoMasBeneficios.getMailDeFelicitacion();
//
//		assertEquals(mailRecibidoEsperado, mailRecibidoActual);
//	}
//
//	@Test
//	public void sucursalHeladeriaAS1DeberiaSerSucursalQueOtorgoMasBeneficios() {
//		/*
//		 * Carlos tiene tarjeta Classic. Juan tiene tarjeta Premium. La
//		 * heladería A ofrece un 10% de descuento con tarjeta Classic y 20% de
//		 * descuento con tarjeta Premium. La heladería A tiene las sucursales S1
//		 * y S2. El restaurant B ofrece un 20% de descuento con ambas tarjetas.
//		 * El restaurant B tiene una sola sucursal: S3. Durante Enero, la
//		 * sucursal S1 realiza 4 beneficios con tarjeta Classic y 3 con tarjeta
//		 * Premium. Carlos y Juan utilizaron los beneficios con sus tarjetas,
//		 * una vez cada uno. La sucursal S2 no realiza beneficios. La sucursal
//		 * S3 atendió a 6 clientes y les realizó el beneficio ofrecido. Carlos
//		 * utilizó su tarjeta Classic para hacer uso del beneficio. Resultado
//		 * esperado: • La Heladería A es el establecimiento al que se debe
//		 * felicitar, por ser el que más beneficios realizó. OK--> • El personal
//		 * de la sucursal S1 debe recibir el regalo, por ser la sucursal que más
//		 * beneficios realizó. • Carlos debe recibir un mail con la sumatoria de
//		 * dinero que se ahorró por usar su beneficio en la heladería y el
//		 * restaurant. • Juan debe recibir el mail con lo que ahorró por usar su
//		 * tarjeta en la heladería
//		 */
//
//		Club club = new Club("Club de Beneficios");
//		Cliente carlos = new Cliente("Carlos", "carlos@gmail.com");
//		Tarjeta tarjetaClassicCarlos = new TarjetaClassic(carlos);
//		Cliente juan = new Cliente("Juan", "juan@gmail.com");
//		Tarjeta tarjetaPremiumJuan = new TarjetaPremium(juan);
//		Establecimiento heladeriaA = new Establecimiento("Heladeria A");
//		Descuento descuento10HeladeriaATarjetaPremium = new DescuentoParaTarjetaClassic(10, heladeriaA);
//		Descuento descuento20HeladeriaATarjetaPremium = new DescuentoParaTarjetaPremium(20, heladeriaA);
//		Sucursal sucursalHeladeriaAS1 = new Sucursal("S1", heladeriaA);
//		Sucursal sucursalHeladeriaAS2 = new Sucursal("S2", heladeriaA);
//		heladeriaA.agregarSucursales(sucursalHeladeriaAS1);
//		heladeriaA.agregarSucursales(sucursalHeladeriaAS2);
//		Establecimiento restaurantB = new Establecimiento("Restaurant B");
//		Descuento descuento20RestaurantBTarjetaClassic = new DescuentoParaTarjetaClassic(20, restaurantB);
//		Descuento descuento20RestaurantBTarjetaPremium = new DescuentoParaTarjetaClassic(20, restaurantB);
//		Sucursal sucursalRestaurantBS3 = new Sucursal("S3", restaurantB);
//		restaurantB.agregarSucursales(sucursalRestaurantBS3);
//		club.agregarEstablecimientos(heladeriaA);
//		club.agregarEstablecimientos(restaurantB);
//		Sucursal sucursalEsperado = sucursalHeladeriaAS1;
//
//		Producto heladoCompradoPorCarlos = new Producto("Helado", 100, heladeriaA);
//		Compra compraDeCarlosEnHeladeriaS1 = new Compra(1, heladoCompradoPorCarlos, sucursalHeladeriaAS1,
//				tarjetaClassicCarlos);
//		sucursalHeladeriaAS1.registrarCompra();
//		Producto heladoCompradoPorJuan = new Producto("Helado", 100, heladeriaA);
//		Compra compraDeJuan = new Compra(1, heladoCompradoPorJuan, sucursalHeladeriaAS1, tarjetaPremiumJuan);
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		Producto comidaCompradoPorCarlos = new Producto("Comida", 150, restaurantB);
//		Compra compraDeCarlosEnRestaurantS3 = new Compra(1, comidaCompradoPorCarlos, sucursalRestaurantBS3,
//				tarjetaClassicCarlos);
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		Sucursal sucursalActual = club.getSucursalQueOtorgoMasBeneficios();
//
//		assertEquals(sucursalEsperado, sucursalActual);
//	}
//
//	@Test
//	public void sucursalHeladeriaAS1DeberiaRecibirRegalo() {
//		Club club = new Club("Club de Beneficios");
//		Cliente carlos = new Cliente("Carlos", "carlos@gmail.com");
//		Tarjeta tarjetaClassicCarlos = new TarjetaClassic(carlos);
//		Cliente juan = new Cliente("Juan", "juan@gmail.com");
//		Tarjeta tarjetaPremiumJuan = new TarjetaPremium(juan);
//		Establecimiento heladeriaA = new Establecimiento("Heladeria A");
//		Descuento descuento10HeladeriaATarjetaPremium = new DescuentoParaTarjetaClassic(10, heladeriaA);
//		Descuento descuento20HeladeriaATarjetaPremium = new DescuentoParaTarjetaPremium(20, heladeriaA);
//		Sucursal sucursalHeladeriaAS1 = new Sucursal("S1", heladeriaA);
//		Sucursal sucursalHeladeriaAS2 = new Sucursal("S2", heladeriaA);
//		heladeriaA.agregarSucursales(sucursalHeladeriaAS1);
//		heladeriaA.agregarSucursales(sucursalHeladeriaAS2);
//		Establecimiento restaurantB = new Establecimiento("Restaurant B");
//		Descuento descuento20RestaurantBTarjetaClassic = new DescuentoParaTarjetaClassic(20, restaurantB);
//		Descuento descuento20RestaurantBTarjetaPremium = new DescuentoParaTarjetaClassic(20, restaurantB);
//		Sucursal sucursalRestaurantBS3 = new Sucursal("S3", restaurantB);
//		restaurantB.agregarSucursales(sucursalRestaurantBS3);
//		club.agregarEstablecimientos(heladeriaA);
//		club.agregarEstablecimientos(restaurantB);
//		Regalo regaloEsperado;
//
//		Producto heladoCompradoPorCarlos = new Producto("Helado", 100, heladeriaA);
//		Compra compraDeCarlosEnHeladeriaS1 = new Compra(1, heladoCompradoPorCarlos, sucursalHeladeriaAS1,
//				tarjetaClassicCarlos);
//		sucursalHeladeriaAS1.registrarCompra();
//		Producto heladoCompradoPorJuan = new Producto("Helado", 100, heladeriaA);
//		Compra compraDeJuan = new Compra(1, heladoCompradoPorJuan, sucursalHeladeriaAS1, tarjetaPremiumJuan);
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		sucursalHeladeriaAS1.registrarCompra();
//		Producto comidaCompradoPorCarlos = new Producto("Comida", 150, restaurantB);
//		Compra compraDeCarlosEnRestaurantS3 = new Compra(1, comidaCompradoPorCarlos, sucursalRestaurantBS3,
//				tarjetaClassicCarlos);
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		sucursalRestaurantBS3.registrarCompra();
//		Regalo regalo = new Regalo("2 Pasjes de Viaje", club.getSucursalQueOtorgoMasBeneficios());
//		club.enviarRegalo(regalo);
//		regaloEsperado = regalo;
//		Regalo regaloActual = sucursalHeladeriaAS1.getRegalo();
//
//		assertEquals(regaloEsperado, regaloActual);
//	}
//
}
