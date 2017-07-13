package ar.edu.untref.aydoo;

public class Producto {

	private double precioProducto;
	private String nombreProducto;

	public Producto(String nombre, double precio) {
		this.precioProducto = precio;
		this.nombreProducto = nombre;
	}
	
	public double getPrecio() {
		return this.precioProducto;
	}
	
	public String getNombre() {
		return this.nombreProducto;
	}

}
