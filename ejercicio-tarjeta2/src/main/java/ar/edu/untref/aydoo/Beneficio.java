package ar.edu.untref.aydoo;

import Excepciones.ExpecionBeneficioInvalido;

public abstract class Beneficio {
	
	Beneficio beneficioSiguiente;
	private String beneficioIngresado;
	private Producto productoA;
	
	public Beneficio(String beneficio, Producto productoA){
		this.beneficioIngresado = beneficio;
		this.productoA = productoA;
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
	
	public Producto getProductoA(){
		return this.productoA;
	}

	public double getPrecioProductoA(){
		double precioProductoA = this.productoA.getPrecio();
		return precioProductoA;
	}
	
}
