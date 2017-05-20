package ar.edu.untref.aydoo;

//Tipo de objeto: Value Object
public class Producto{
	//private int cantidad;
	private double precio;
	private String nombre;
	private String tipoDeProducto;
	public Producto siguiente;
	
	public Producto(String nombre, String tipoDeProducto, double precio){
		this.precio = precio;
		this.nombre = nombre;
		this.tipoDeProducto = tipoDeProducto;
		//this.cantidad = 1;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getTipoDeProducto(){
		return this.tipoDeProducto;
	}
	
	public void setPrecio(double precio){
		this.precio = precio;
	}
	
	/*
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	*/
	
	public double obtenerPrecio(){
		return this.precio;
	}
	
}
