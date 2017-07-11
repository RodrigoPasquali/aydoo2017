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
		this.beneficioIngresado = beneficio.toLowerCase();
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
	
	private List<Beneficio> getBeneficiosDeEstablecimiento(){
		Establecimiento establecimiento = this.sucursalDondeSeCompra.getEstablecimientoAlQuePertenece();
		List<Beneficio> listaDeBeneficios = establecimiento.getBeneficiosParaTarjeta(this.tarjetaIngresada);
		return listaDeBeneficios;
	}
	
	private double sumarPrecioProductos() {
		double montoTotal = 0;
		for(int i = 0; i < this.listaProductoComprado.size(); i++){
			montoTotal = montoTotal + this.listaProductoComprado.get(i).getPrecio();
		}
		return montoTotal;
	}
	
	public double obtenerPrecioFinal() {
		double precioFinal = sumarPrecioProductos();
		int i = 0;
		while(i < getBeneficiosDeEstablecimiento().size()){
			if(getBeneficiosDeEstablecimiento().get(i).getTarjeta().equals(this.tarjetaIngresada)){
				int porcentaje;
				Beneficio beneficio = new BeneficioDescuentoPorcentaje(this.beneficioIngresado, this.listaProductoComprado, this.tarjetaIngresada);
				if(getBeneficiosDeEstablecimiento().get(i).getBeneficioIngresado().equals("descuento")){
					porcentaje = getBeneficiosDeEstablecimiento().get(i).getPorcentajeDescuento();
					beneficio.setPorcentajeDescuento(porcentaje);
				}
				precioFinal = beneficio.aplicarBeneficio();
			}
			i++;
		}
		return precioFinal;
	}

}
