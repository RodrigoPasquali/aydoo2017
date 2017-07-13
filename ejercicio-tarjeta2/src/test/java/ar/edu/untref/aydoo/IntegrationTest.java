package ar.edu.untref.aydoo;

import org.junit.Test;

import Excepciones.ExcepcionClienteNoUtilizoTarjeta;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class IntegrationTest {
	
	private ClubBeneficios club;
	private Cliente carlos;
	private Cliente juan;
	private Tarjeta tarjetaClassic;
	private Tarjeta tarjetaPremium;
	private Establecimiento heladeriaA;
	private Beneficio descuento10Classic;
	private Beneficio descuento20Premium;
	private Sucursal s1;
	private Sucursal s2;
	private Establecimiento restaurantB;
	private Beneficio descuento20Classic;
	private Sucursal s3;
	private Mes enero;
	
	@Before
	public void inicializar() {
		this.carlos = new Cliente("Carlos", "car@gmail");
		this.tarjetaClassic = Tarjeta.CLASSIC;
		this.carlos.setTarjeta(this.tarjetaClassic);
		this.juan = new Cliente("Juan", "juan@gmail");
		this.tarjetaPremium = Tarjeta.PREMIUM;
		this.juan.setTarjeta(this.tarjetaPremium);
		this.club = new ClubBeneficios();
		this.heladeriaA = new Establecimiento("Heladeria A");
		this.club.agregarEstablecimiento(this.heladeriaA);
		this.descuento10Classic = new BeneficioDescuentoPorcentaje("descuento", this.tarjetaClassic);
		this.descuento10Classic.setPorcentajeDescuento(10);
		this.descuento20Premium = new BeneficioDescuentoPorcentaje("descuento", this.tarjetaPremium);
		this.descuento20Premium.setPorcentajeDescuento(20);
		this.heladeriaA.agregarBeneficio(this.descuento20Premium);
		this.heladeriaA.agregarBeneficio(this.descuento10Classic);
		this.s1 = new Sucursal("S1");
		this.heladeriaA.agregarSucursal(this.s1);
		this.s1.esUnaSucursalDe(this.heladeriaA);
		this.s2 = new Sucursal("S2");
		this.heladeriaA.agregarSucursal(this.s2);
		this.s2.esUnaSucursalDe(this.heladeriaA);
		this.restaurantB = new Establecimiento("Restaurant B");
		this.club.agregarEstablecimiento(this.restaurantB);
		this.descuento20Classic = new BeneficioDescuentoPorcentaje("descuento", this.tarjetaClassic);
		this.descuento20Classic.setPorcentajeDescuento(20);
		this.restaurantB.agregarBeneficio(this.descuento20Classic);
		this.restaurantB.agregarBeneficio(this.descuento20Premium);
		this.s3 = new Sucursal("S3");
		this.restaurantB.agregarSucursal(this.s3);
		this.s3.esUnaSucursalDe(this.restaurantB);
		this.enero = Mes.Enero;
		Producto helado = new Producto("Helado", 100);
		Compra compraJuanS1 = new Compra(this.tarjetaPremium, this.s1, this.enero);
		compraJuanS1.agregarProducto(helado);
		compraJuanS1.setBeneficio("descuento");
		this.juan.registrarCompra(compraJuanS1);
		this.s1.agregarVenta(compraJuanS1);
		Compra compraCarlosS1 = new Compra(this.tarjetaClassic, this.s1, this.enero);
		compraCarlosS1.agregarProducto(helado);
		compraCarlosS1.setBeneficio("descuento");
		this.carlos.registrarCompra(compraCarlosS1);
		this.s1.agregarVenta(compraCarlosS1);
		Compra compraClassicS11 = new Compra(this.tarjetaClassic, this.s1, this.enero);
		compraClassicS11.setBeneficio("descuento");
		this.s1.agregarVenta(compraClassicS11);
		Compra compraClassicS12 = new Compra(this.tarjetaClassic, this.s1, this.enero);
		compraClassicS12.setBeneficio("descuento");
		this.s1.agregarVenta(compraClassicS12);
		Compra compraClassicS13 = new Compra(this.tarjetaClassic, this.s1, this.enero);
		compraClassicS13.setBeneficio("descuento");
		this.s1.agregarVenta(compraClassicS13);
		Compra compraPremiumS11 = new Compra(this.tarjetaPremium, this.s1, this.enero);
		compraPremiumS11.setBeneficio("descuento");
		this.s1.agregarVenta(compraPremiumS11);
		Compra compraPremiumS12 = new Compra(this.tarjetaPremium, this.s1, this.enero);
		compraPremiumS12.setBeneficio("descuento");
		this.s1.agregarVenta(compraPremiumS12);
		Producto menuCena = new Producto("Cena", 250);
		Compra compraCarlosS3 = new Compra(this.tarjetaClassic, this.s3, this.enero);
		compraCarlosS3.agregarProducto(menuCena);
		compraCarlosS3.setBeneficio("descuento");
		this.carlos.registrarCompra(compraCarlosS3);
		this.s3.agregarVenta(compraCarlosS3);
		Compra compraS31 = new Compra(this.tarjetaClassic, this.s3, this.enero);
		compraS31.agregarProducto(menuCena);
		this.s3.agregarVenta(compraS31);
		Compra compraS32 = new Compra(this.tarjetaClassic, this.s3, this.enero);
		compraS32.agregarProducto(menuCena);
		this.s3.agregarVenta(compraS32);
		Compra compraS33 = new Compra(this.tarjetaClassic, this.s3, this.enero);
		compraS33.agregarProducto(menuCena);
		this.s3.agregarVenta(compraS33);
		Compra compraS34 = new Compra(this.tarjetaClassic, this.s3, this.enero);
		compraS34.agregarProducto(menuCena);
		this.s3.agregarVenta(compraS34);
		Compra compraS35 = new Compra(this.tarjetaClassic, this.s3, this.enero);
		compraS35.agregarProducto(menuCena);
		this.s3.agregarVenta(compraS35);
	}
	
	@Test
	public void getDescuentoEnMarzoDeberiaSerQuince(){
		ClubBeneficios club = new ClubBeneficios();
		Establecimiento mcDonal = new Establecimiento("Mc Donals");
		club.agregarEstablecimiento(mcDonal);
		Sucursal s1 = new Sucursal("S1");
		s1.esUnaSucursalDe(mcDonal);
		mcDonal.agregarSucursal(s1);
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", tarjetaPremium);
		descuento10.setPorcentajeDescuento(10);
		mcDonal.agregarBeneficio(descuento10);
		Producto hamburguesa = new Producto("Hamburguesa",100);
		Producto papas = new Producto("Papas",50);
		Cliente juan = new Cliente("juan", "j@");
		juan.setTarjeta(tarjetaPremium);
		Mes marzo = Mes.Marzo;
		Compra compraMcDonal = new Compra(tarjetaPremium, s1, marzo);
		compraMcDonal.agregarProducto(hamburguesa);
		compraMcDonal.agregarProducto(papas);
		compraMcDonal.setBeneficio("descuentO");
		juan.registrarCompra(compraMcDonal);
		double valorEsperado = 15;
		
		double valorObtenido = juan.getDescuentosObtenidosEnMes(marzo); 
		
		assertEquals(valorEsperado, valorObtenido, 0.1);
	}
	
	@Test
	public void deberiaDevolver3LaCantidadDeBeneficiosOtorgadosEneroPorLibreria(){
		ClubBeneficios club = new ClubBeneficios();
		Establecimiento libreria = new Establecimiento("El Altillo");
		club.agregarEstablecimiento(libreria);
		Sucursal sucursalElAltillo = new Sucursal("El Altillo Sucursal");
		sucursalElAltillo.esUnaSucursalDe(libreria);
		libreria.agregarSucursal(sucursalElAltillo);
		Tarjeta tarjetaPremium = Tarjeta.PREMIUM;
		Beneficio beneficio2x1 = new BeneficioDescuentoPorcentaje("2x1",tarjetaPremium);
		libreria.agregarBeneficio(beneficio2x1);
		Producto martinFierro = new Producto("Martin Fierro", 100);
		Producto elCantarDelCid = new Producto("El Cantar del Cid", 80);
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
	
	@Test
	public void deberiaDevolver100CuandoSeAplica2x1CuandoSeCompranProductosDe80y100(){
		//	Mateo compra con su tarjeta classic el libro "Martín Fierro" ($100) en la librería 
		//	"El altillo" (sucursal única). Esta librería está asociada al club y ofrece el beneficio 2x1.
		//	Entonces Mateo elige como segundo libro "El Cantar del Cid" ($80) pero como tiene el beneficio 
		//	este segundo libro le resultar gratis. O sea que Mateo se lleva estos dos libros por $100 
		//	(el beneficio 2x1 tomo como referencia el  precio del libro más alto)
		
		ClubBeneficios club = new ClubBeneficios();
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
		Producto martinFierro = new Producto("Martin Fierro", 100);
		Producto elCantarDelCid = new Producto("El Cantar del Cid", 80);
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
		// Resultado esperado: OK --> • La Heladería A es el establecimiento al que se debe felicitar, 
		// 		por ser el que más beneficios realizó. 
		
		
		String valorEsperado = "Felicidades Heladeria A por ser el establecimiento que mas beneficios otorgo con la cantidad de 7 en el mes de Enero!";

		String valorObtenido = this.club.felicitarEstablecimientoConMasBeneficiosOtorgadosEnMes(this.enero).getTexto();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void seDeberiaEnviarRegaloDeFelicitacionesAS3AEnEneroPorSerSucursalQueAtendioMasClintes() {
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
		// Resultado esperado: OK --> • El personal de la sucursal S3 debe recibir el regalo, por ser la sucursal que más
		//		  beneficios realizó.
		
		
		String valorEsperado = "Felicidades S1 por ser la sucursal ganadora del regalo del mes de Enero"
				+ " por ser la sucursal que mas cliente atendio con la cantidad de 7!";

		String valorObtenido = this.club.enviarRegaloASucursalQueAtendioMasClientesEnElMes(this.enero).getTexto();
		
		assertEquals(valorEsperado, valorObtenido);
	}	
	
	@Test
	public void seDeberiaEnviarReporteDeBeneficiosObtenidosPorCarlos() {
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
		// Resultado esperado: OK -->  • Carlos debe recibir un mail con la sumatoria de
		//		 dinero que se ahorró por usar su beneficio en la heladería y el restaurant. 
		
		
		String valorEsperado = "...Reporte de ahorros obtenidos por Carlos con la tarjeta del club en el mes de Enero... \r\n" 
				 + "Establecimiento | Producto Comprado  | Precio Habitual | Precio Con Beneficio | Beneficio \r\n" 
				 + "Heladeria A | Helado | 100.0 | 90.0 | descuento \r\n"
				 + "Restaurant B | Cena | 250.0 | 200.0 | descuento \r\n" ;

		String valorObtenido = this.club.generarReporteDeAhorrosDeClienteEnMes(this.carlos, this.enero);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void seDeberiaEnviarReporteDeBeneficiosObtenidosPorJuan() {
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
		// Resultado esperado: OK -->  Juan debe recibir el mail con lo que ahorró por usar su
		//	 	tarjeta en la heladería
		
		
		String valorEsperado = "...Reporte de ahorros obtenidos por Juan con la tarjeta del club en el mes de Enero... \r\n"
				+ "Establecimiento | Producto Comprado  | Precio Habitual | Precio Con Beneficio | Beneficio \r\n"
				+ "Heladeria A | Helado | 100.0 | 80.0 | descuento \r\n";

		String valorObtenido = this.club.generarReporteDeAhorrosDeClienteEnMes(this.juan, this.enero);
		
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void deberiaDevolverExpecionClienteNoUtilizoTarjetaCuandoSePideGenerarReporteParaPablo() {
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
		// Resultado esperado: OK -->  Juan debe recibir el mail con lo que ahorró por usar su
		//	 	tarjeta en la heladería
		
		Cliente pablo = new Cliente("Pablo", "pablo@gmail");
		this.club.agregarCliente(pablo);
		
		try {
			this.club.generarReporteDeAhorrosDeClienteEnMes(pablo, enero);
		}catch (ExcepcionClienteNoUtilizoTarjeta e){

	    }
	}

}