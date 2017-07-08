package ar.edu.untref.aydoo;

import java.util.List;

import Excepciones.ExcepcionPocentajeDescuentoInvalido;
import Excepciones.ExpecionBeneficioInvalido;

public abstract class Beneficio {
	
	Beneficio beneficioSiguiente;
	private String beneficioIngresado;
	private int porcentajeDescuento;
	private Tarjeta tarjetaIngresada;
	
	public Beneficio(String beneficio, List<Producto> productos, Tarjeta tarjeta) {
		this.beneficioIngresado = beneficio.toLowerCase();
		this.tarjetaIngresada = tarjeta;
	}
	
	public abstract double aplicarBeneficio() throws ExpecionBeneficioInvalido;
	
	public String getBeneficioIngresado() {
		return this.beneficioIngresado;
	}
	
	public void setBeneficioSiguiente(Beneficio beneficio) {
		this.beneficioSiguiente = beneficio;
	}
	
	public Beneficio getBeneficioSiguiente() {
		return this.beneficioSiguiente;
	}
	
	public Tarjeta getTarjeta() {
		return this.tarjetaIngresada;
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
