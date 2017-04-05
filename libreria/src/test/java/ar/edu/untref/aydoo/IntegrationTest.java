package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {

	@Test
	public void precioDeLibroDebeDar50(){
		Libro hobbit = new Libro("El Hobbit", 50, "Enero",1);
		double valorEsperado = 50;
		
		Assert.assertEquals(valorEsperado, hobbit.obtenerPrecio(), 0.01);
	}
	
	
	@Test
	public void precioDeRevistaDebeDar50(){
		Revista barcelona = new Revista("Barcelona", 20, 15, false, "Enero",1);
		double valorEsperado = 20;
		
		Assert.assertEquals(valorEsperado, barcelona.obtenerPrecio(), 0.01);
	}
	
		
	@Test
	public void periodicidadDeRevistaDebeDar15(){		
		Revista barcelona = new Revista("Barcelona", 20, 15, false, "Enero",1);
		int valorEsperado = 15;
		
		Assert.assertEquals(valorEsperado, barcelona.obtenerPeriodicidad());
	}
	
	
	@Test
	public void periodicidadDeDiarioDebeDar1(){
		Periodico pagina12 = new Periodico("Pagina 12", 12, 1, false, "Enero",1);
		int valorEsperado = 1;
		
		Assert.assertEquals(valorEsperado, pagina12.obtenerPeriodicidad());
	}
	
	
	@Test
	public void precioConIvaDeAritculoDeLibreriaDeberiaDevolverSeisConCinco(){
		ArticuloDeLibreria lapicera = new ArticuloDeLibreria("Lapicera", 5, "Enero",1);
		double valorEsperado = 6.05;
		
		lapicera.obtenerPrecio();
		double valorActual = lapicera.obtenerPrecio();
		
		Assert.assertEquals(valorEsperado, valorActual,0.01);
	}
	
	
	@Test
	public void suscripcionAnualEsVerdadero(){
		Periodico clarin = new Periodico("Clarin", 13,3, true, "Enero",1);
		boolean valorEsperado = true;
		
		boolean valorActual = clarin.tieneSuscripcionAnual();
		
		Assert.assertEquals(valorEsperado, valorActual);
	}
	
	
	@Test
	public void suscripcionAnualEsFalse(){
		Periodico clarin = new Periodico("Clarin", 13, 1, false, "Enero",1);
		boolean valorEsperado = false;
		
		boolean valorActual = clarin.tieneSuscripcionAnual();
		
		Assert.assertEquals(valorEsperado, valorActual);
	}
	
	
	
	@Test
	public void obtieneDescuentoPorSuscripcionAnual(){
		Periodico pagina12 = new Periodico("Pagina 12", 12, 30, true, "Enero",1);
		double valorEsperado = (12 - 12*0.2) * 30;
		
		double valorActual = pagina12.aplicarDescuentoPorSuscripcionEnUnMes();
		
		Assert.assertEquals(valorEsperado, valorActual, 0.01);
	}

	
	@Test
	public void valorObtenidoAlAplicarDescuentoDeSuscpricionQueNoPoseeDeberiaEntregarMismoPrecioSinDescuento(){
		Periodico pagina12 = new Periodico("Pagina 12", 12, 30, false, "Enero",1);
		double valorEsperado = 12;
		
		double valorActual = pagina12.aplicarDescuentoPorSuscripcionEnUnMes();
		
		Assert.assertEquals(valorEsperado, valorActual, 0.01);
	}
	
	@Test
	public void gastoTotalJuanEnAgostoDebeSer92con01(){
		Libreria libreria = new Libreria();
		Cliente juan = new Cliente("Juan", "Ayacucho 554", 55555555);
		Producto hobbit = new Libro("El Hobbit", 50, "Agosto",1);
		Producto lapicera = new ArticuloDeLibreria("Lapicera", 5, "Agosto",2);
		Producto elGrafico = new Revista("El Grafico", 30, 1, false, "Agosto",1);
		juan.comprarProducto(hobbit);
		juan.comprarProducto(lapicera);
		juan.comprarProducto(elGrafico);
		double valorEsperado = 50 + 30 + 5*1.21*2;
		
		double valorActual = libreria.calcularMontoACobrar("Agosto", juan);
		
		Assert.assertEquals(valorEsperado, valorActual, 0.1);
	}
	
	@Test
	public void gastoTotalMariaEnEneroDebeSer44(){
		Libreria libreria = new Libreria();
		Cliente maria = new Cliente("Maria", "Corrientes 441", 444444444);
		Producto barcelona = new Revista("Barcelona", 20, 2, true, "Enero", 1);
		Producto pagina12 = new Periodico("Pagina 12", 12, 30, false, "Enero", 1);
		maria.comprarProducto(pagina12);
		maria.comprarProducto(barcelona);
		double valorEsperado = (20 - 20*0.2)*2 + 12;
		
		double valorActual = libreria.calcularMontoACobrar("Enero", maria);
		
		Assert.assertEquals(valorEsperado, valorActual, 0.1);
	}
	
	
}
