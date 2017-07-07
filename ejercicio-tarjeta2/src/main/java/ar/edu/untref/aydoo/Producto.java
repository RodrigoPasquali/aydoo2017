package ar.edu.untref.aydoo;

public class Producto {

	private Beneficio beneficioProducto;
	private int precioProducto;

	public Producto(int precio, Beneficio beneficio){
		this.precioProducto = precio;
		this.beneficioProducto = beneficio;
	}
	
	public int getPrecio(){
		return this.precioProducto;
	}
	
	public Beneficio getBeneficio(){
		return this.beneficioProducto;
	}
}
