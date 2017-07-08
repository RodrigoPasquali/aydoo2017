package ar.edu.untref.aydoo;

import java.util.List;

import Excepciones.ExcepcionPocentajeDescuentoInvalido;
import Excepciones.ExpecionBeneficioInvalido;

public abstract class Beneficio {
	
	Beneficio beneficioSiguiente;
	private String beneficioIngresado;
	private Producto productoA;
	private int porcentajeDescuento;
	private List<Producto> listaProductos;
	
	public Beneficio(String beneficio, List<Producto> productos){
		this.beneficioIngresado = beneficio.toLowerCase();
		//this.productoA = productoA;
		this.listaProductos = productos;
	}
	
	public abstract double aplicarBeneficio() throws ExpecionBeneficioInvalido;
	
	public String getBeneficioIngresado(){
		return this.beneficioIngresado;
	}
	
	public void setBeneficioSiguiente(Beneficio beneficio){
		this.beneficioSiguiente = beneficio;
	}
	
	public Beneficio getBeneficioSiguiente(){
		return this.beneficioSiguiente;
	}
	
	/*
	public Producto getProductoA(){
		return this.productoA;
	}
	*/

	/*
	public double getPrecioProductoA(){
		double precioProductoA = this.productoA.getPrecio();
		return precioProductoA;
	}
	*/
	
	public void setPorcentajeDescuento(int porcentaje){
		if(porcentaje < 5 || porcentaje > 100){
			throw new ExcepcionPocentajeDescuentoInvalido();
		}
		this.porcentajeDescuento = porcentaje;
	}
	
	public int getPorcentajeDescuento(){
		return this.porcentajeDescuento;
	}
	
}
