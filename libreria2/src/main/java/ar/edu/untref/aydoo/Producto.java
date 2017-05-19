package ar.edu.untref.aydoo;

//Tipo de objeto: Value Object
public abstract class Producto{
	private int cantidad;
	private boolean iva;
	private double precio;
	private String nombre;
	private String tipoDeProducto;
	public Producto siguiente;
	
	public Producto(String nombre, String tipoDeProducto, double precio){
		this.precio = precio;
		this.nombre = nombre;
		this.tipoDeProducto = tipoDeProducto;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getTipoDeProducto(){
		return this.tipoDeProducto;
	}
	
	public void setIVa(boolean iva){
		this.iva = iva;
	}
	
	public boolean poseeIva(){
		return this.iva;
	}
	
	public void setPrecio(double precio){
		this.precio = precio;
	}
	
	public double getPrecio(){
		return this.precio;
	}

	public abstract double obtenerPrecioFinal();
	
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
}
