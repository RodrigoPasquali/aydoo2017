package ar.edu.untref.aydoo;

public class Compra {
	private Producto producto;
	private int cantidad;
	double precioDeCompra;

	public Compra(Producto productoComprado, int cantidad) {
		this.producto = productoComprado;
		this.cantidad = cantidad;
	}
	
	public void calcularPrecioCompra(){
		precioDeCompra = this.producto.obtenerPrecio() * this.cantidad;
	}
}
