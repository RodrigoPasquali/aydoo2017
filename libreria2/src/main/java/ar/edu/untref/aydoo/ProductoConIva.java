package ar.edu.untref.aydoo;

//Tipo de objeto: Value Object
public class ProductoConIva extends Producto{
	private double precioConIva;
	private double precioSinIva;
	
	public ProductoConIva(String nombre, String tipoDeProducto, double precio){
		super(nombre, tipoDeProducto, precio);
		this.precioSinIva = precio;
	}
	
	@Override
	public double obtenerPrecio(){
		this.precioConIva = calcularPrecio();
		return this.precioConIva;
	}
	
	private double calcularPrecio(){
		return this.precioSinIva*1.21;
	}

}