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
	public void elPrecioFinalDeberiaSer90(){		
		Producto libro = new Producto(100);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(libro);
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", listaProductos, null);
		descuento10.setPorcentajeDescuento(10);
		double valorEsperado = 90;
		
		double valorObtenido = descuento10.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.01);		
	}
	
	@Test
	public void elPrecioFinalDeberiaSer90CuandoSeEscribeDescuentoConMayuscula(){		
		Producto libro = new Producto(100);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(libro);
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("Descuento", listaProductos, null);
		descuento10.setPorcentajeDescuento(10);
		double valorEsperado = 90;
		
		double valorObtenido = descuento10.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.01);		
	}
	
	@Test
	public void deberiaDevolverExpecionCuandoPorcentajeEsMenorA5(){
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento", null, null);
		
		try {
			descuento10.setPorcentajeDescuento(4);
		}catch (ExcepcionPocentajeDescuentoInvalido e){

	    }
	}
	
	@Test
	public void deberiaDevolverExpecionCuandoPorcentajeEsMayorA100(){
		Beneficio descuento10 = new BeneficioDescuentoPorcentaje("descuento",null, null);	
		
		try {
			descuento10.setPorcentajeDescuento(101);
		}catch (ExcepcionPocentajeDescuentoInvalido e){

	    }
	}
	
	@Test
	public void precioFinalDeberiaDevolver100(){
		Producto elHobbit = new Producto(100);
		Producto elPrincipito = new Producto(50);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(elPrincipito);
		listaProductos.add(elHobbit);
		Beneficio promocion2x1 = new BeneficioDescuentoPorcentaje("2x1", listaProductos, null);
		double valorEsperado = 100;
		
		double valorObtenido = promocion2x1.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.001);
	}
	
	@Test
	public void precioFinalDeberiaDevolverExpecionFaltaProducto(){
		Producto elHobbit = new Producto(100);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(elHobbit);
		Beneficio promocion2x1 = new BeneficioDescuentoPorcentaje("2x1", listaProductos, null);
		
		try {
			promocion2x1.aplicarBeneficio();
		}catch (ExpecionFaltaProducto e){

	    }	
	}
	
	@Test
	public void precioFinalDeberiaDevolver200(){
		Producto elHobbit = new Producto(100);
		Producto elPrincipito = new Producto(200);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(elPrincipito);
		listaProductos.add(elHobbit);
		Beneficio promocion2x1 = new BeneficioDescuentoPorcentaje("2x1", listaProductos, null);
		double valorEsperado = 200;
		
		double valorObtenido = promocion2x1.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.001);
	}
	
	@Test
	public void precioFinalDeberiaDevolver140(){
		Producto elHobbit = new Producto(90);
		Producto elPrincipito = new Producto(50);
		List<Producto> listaProductos = new LinkedList<Producto>();
		listaProductos.add(elPrincipito);
		listaProductos.add(elHobbit);
		Beneficio promocion2x1 = new BeneficioDescuentoPorcentaje("2x1", listaProductos, null);
		double valorEsperado = 140;
		
		double valorObtenido = promocion2x1.aplicarBeneficio();
		
		assertEquals(valorEsperado, valorObtenido, 0.001);
	}
	
}
