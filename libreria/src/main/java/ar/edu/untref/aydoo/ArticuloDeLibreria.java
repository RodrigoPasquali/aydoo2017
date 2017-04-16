package ar.edu.untref.aydoo;

//Tipo de objeto: Value Object
public class ArticuloDeLibreria extends Producto{

	private double precio;

	public ArticuloDeLibreria(String nombre, double precio, String mes, int cantidad){
		super(nombre, precio, mes, cantidad);
		this.precio = precio;
	}
	
	@Override
	public double obtenerPrecio(){
		return this.precio*1.21;
	}
	
}