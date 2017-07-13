package ar.edu.untref.aydoo;

import org.junit.Test;

import Excepciones.ExcepcionPocentajeDescuentoInvalido;
import Excepciones.ExpecionFaltaProducto;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class TestBeneficio {
	
	@Test
	public void elPrecioFinalDeberiaSer90CuandoDescuentoEsDiez(){		
		Producto libro = new Producto("Libro", 100);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(libro);
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", null);
		descuento10.setProductos(listaProductos);
		descuento10.setPorcentajeDescuento(10);
		double valorEsperado = 90;
		
		double valorObtenido = descuento10.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.01);		
	}
	
	@Test
	public void elPrecioFinalDeberiaSer95CuandoDescuentoEsCinco(){		
		Producto libro = new Producto("Libro", 100);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(libro);
		Beneficio descuento5 = new BeneficioDescuentoPorcentaje("descuento", null);
		descuento5.setProductos(listaProductos);
		descuento5.setPorcentajeDescuento(5);
		double valorEsperado = 95;
		
		double valorObtenido = descuento5.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.01);		
	}
	
	@Test
	public void elPrecioFinalDeberiaSerCeroCuandoDescuentoEsCien(){		
		Producto libro = new Producto("Libro", 100);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(libro);
		Beneficio descuento100 = new BeneficioDescuentoPorcentaje("descuento", null);
		descuento100.setProductos(listaProductos);
		descuento100.setPorcentajeDescuento(100);
		double valorEsperado = 0;
		
		double valorObtenido = descuento100.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.01);		
	}
	
	@Test
	public void elPrecioFinalDeberiaSer90CuandoSeEscribeDescuentoConMayuscula(){		
		Producto libro = new Producto("Libro", 100);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(libro);
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("DESCUENTO", null);
		descuento10.setProductos(listaProductos);
		descuento10.setPorcentajeDescuento(10);
		double valorEsperado = 90;
		
		double valorObtenido = descuento10.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.01);		
	}
	
	@Test
	public void deberiaDevolverExpecionCuandoPorcentajeEsMenorA5(){
		Beneficio descuento4 = new BeneficioDescuentoPorcentaje("descuento", null);
		
		try {
			descuento4.setPorcentajeDescuento(4);
		}catch (ExcepcionPocentajeDescuentoInvalido e){

	    }
	}
	
	@Test
	public void deberiaDevolverExpecionCuandoPorcentajeEsMayorA100(){
		Beneficio descuento101 = new BeneficioDescuentoPorcentaje("descuento", null);	
		
		try {
			descuento101.setPorcentajeDescuento(101);
		}catch (ExcepcionPocentajeDescuentoInvalido e){

	    }
	}
	
	@Test
	public void precioFinalDeberiaDevolver100CuandoSeAplica2x1(){
		Producto elHobbit = new Producto("El Hobbit", 100);
		Producto elPrincipito = new Producto("El Principito", 50);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(elPrincipito);
		listaProductos.add(elHobbit);
		Beneficio promocion2x1 = new BeneficioDescuentoPorcentaje("2x1", null);
		promocion2x1.setProductos(listaProductos);
		double valorEsperado = 100;
		
		double valorObtenido = promocion2x1.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.001);
	}
	
	@Test
	public void precioFinalDeberiaDevolverExpecionFaltaProductoCuandoSeDeseaHacer2x1DeUnSoloProducto(){
		Producto elHobbit = new Producto("El Hobbit", 100);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(elHobbit);
		Beneficio promocion2x1 = new BeneficioDescuentoPorcentaje("2x1", null);
		promocion2x1.setProductos(listaProductos);
		
		try {
			promocion2x1.aplicarBeneficio();
		}catch (ExpecionFaltaProducto e){

	    }	
	}
	
	@Test
	public void precioFinalDeberiaDevolver200(){
		Producto elHobbit = new Producto("El Hobbit", 100);
		Producto elPrincipito = new Producto("El Principito", 50);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(elPrincipito);
		listaProductos.add(elHobbit);
		Beneficio promocion2x1 = new BeneficioDescuentoPorcentaje("2x1", null);
		promocion2x1.setProductos(listaProductos);
		double valorEsperado = 200;
		
		double valorObtenido = promocion2x1.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.001);
	}
	
	@Test
	public void precioFinalDeberiaDevolver140CuandoNingunoDeLosProductosCuesta100OMas(){
		Producto elHobbit = new Producto("El Hobbit", 100);
		Producto elPrincipito = new Producto("El Principito", 50);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(elPrincipito);
		listaProductos.add(elHobbit);
		Beneficio promocion2x1 = new BeneficioDescuentoPorcentaje("2x1", null);
		promocion2x1.setProductos(listaProductos);
		double valorEsperado = 140;
		
		double valorObtenido = promocion2x1.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.001);
	}
	
}
