package ar.edu.untref.aydoo;

//Tipo de objeto: Value Object
public class ProductoConIva extends Producto{
	private double precio;
	private double precioConIva;

	public ProductoConIva(String nombre, String tipoDeProducto, double precio){
		super(nombre, nombre, precio);
		this.precio = precio;
	}
	
	public double obtenerPrecioFinal(){
		this.precioConIva = calcularPrecio();
		return this.precioConIva;
	}
	
	private double calcularPrecio(){
		return this.precio*1.21;
	}

}