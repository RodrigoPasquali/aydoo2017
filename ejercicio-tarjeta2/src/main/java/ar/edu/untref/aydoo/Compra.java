package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import Excepciones.ExpecionDosProductosPorCompra;

public class Compra {
	
	private List<Producto> listaProductoComprado;
	private String beneficioIngresado;
	private Tarjeta tarjetaIngresada;
	private Sucursal sucursalDondeSeCompra;

	public Compra(Tarjeta tarjeta, Sucursal sucursal){
		this.listaProductoComprado = new LinkedList<Producto>();
		this.tarjetaIngresada = tarjeta;
		this.sucursalDondeSeCompra = sucursal;
		this.beneficioIngresado = null;
	}
	
	public void agregarProducto(Producto producto) {
		if(this.listaProductoComprado.size() <= 2) {
			this.listaProductoComprado.add(producto);
		} else {
			throw new ExpecionDosProductosPorCompra();
		}
	}
	
	public void setBeneficio(String beneficio) {
		this.beneficioIngresado = beneficio;
	}
	
	public Tarjeta getTarjeta() {
		return this.tarjetaIngresada;
	}
	
	public List<Producto> getListaProductosComprados() {
		return this.listaProductoComprado;
	}
	
	public Sucursal getSucursal() {
		return this.sucursalDondeSeCompra;
	}
	
	public double sumarPrecioProductos() {
		double montoTotal = 0;
		for(int i = 0; i < this.listaProductoComprado.size(); i++){
			montoTotal = montoTotal + this.listaProductoComprado.get(i).getPrecio();
		}
		return montoTotal;
	}
	
	public double obtenerPrecioFinal() {
		double precioFinal = 0;
		if(this.beneficioIngresado == null){
			precioFinal = sumarPrecioProductos();
		} else {
			Beneficio beneficio = new BeneficioDescuentoPorcentaje(this.beneficioIngresado, this.listaProductoComprado);
			precioFinal = beneficio.aplicarBeneficio();
		}
		return precioFinal;
	}

}
