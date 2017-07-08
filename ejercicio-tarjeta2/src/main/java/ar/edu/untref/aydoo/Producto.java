package ar.edu.untref.aydoo;

public class Producto {

	private Beneficio beneficioProducto;
	private double precioProducto;

	public Producto(double precio, Beneficio beneficio){
		this.precioProducto = precio;
		this.beneficioProducto = beneficio;
	}
	
	public double getPrecio(){
		return this.precioProducto;
	}
	
	public Beneficio getBeneficio(){
		return this.beneficioProducto;
	}
}
