package ar.edu.untref.aydoo;

public class Producto{

	public double precio;
	public String nombre;
	public String mes;
	public int cantidad;

	public Producto(String nombre, double precio, String mes, int cantidad){
		this.precio = precio;
		this.nombre = nombre;
		this.mes = mes;
		this.cantidad = cantidad;
	}
	
	public void ponerPrecio(double precio){
		this.precio = precio;
	}
	
	public String obtenerMes() {
		return mes;
	}

	public double obtenerPrecio(){
		return this.precio;
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}

	public int obtenerCantidad() {
		return cantidad;
	}
	
}
