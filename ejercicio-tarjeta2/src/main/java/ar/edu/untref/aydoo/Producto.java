package ar.edu.untref.aydoo;

public class Producto {

	private double precioProducto;

	public Producto(double precio){
		this.precioProducto = precio;
	}
	
	public double getPrecio(){
		return this.precioProducto;
	}

}
