package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import Excepciones.ExcepcionPocentajeDescuentoInvalido;
import Excepciones.ExcepcionBeneficioInvalido;

public abstract class Beneficio {
	
	Beneficio beneficioSiguiente;
	private String beneficioIngresado;
	private int porcentajeDescuento;
	private Tarjeta tarjetaIngresada;
	private List<Producto> listaDeProductos;
	
	public Beneficio(String beneficio, Tarjeta tarjeta) {
		this.beneficioIngresado = beneficio.toLowerCase();
		this.tarjetaIngresada = tarjeta;
		this.listaDeProductos = new LinkedList<Producto>();
	}
	
	public abstract double aplicarBeneficio() throws ExcepcionBeneficioInvalido;
	
	public String getBeneficioIngresado() {
		return this.beneficioIngresado;
	}
	
	protected void setBeneficioSiguiente(Beneficio beneficio) {
		this.beneficioSiguiente = beneficio;
	}
	
	public Beneficio getBeneficioSiguiente() {
		return this.beneficioSiguiente;
	}
	
	public Tarjeta getTarjeta() {
		return this.tarjetaIngresada;
	}
	
	public void setProductos(List<Producto> productos) {
		this.listaDeProductos = productos;
	}
	
	public List<Producto> getProductos() {
		return this.listaDeProductos;
	}
	
	public void setPorcentajeDescuento(int porcentaje) {
		if(porcentaje < 5 || porcentaje > 100){
			throw new ExcepcionPocentajeDescuentoInvalido();
		}
		this.porcentajeDescuento = porcentaje;
	}
	
	public int getPorcentajeDescuento() {
		return this.porcentajeDescuento;
	}
	
}
