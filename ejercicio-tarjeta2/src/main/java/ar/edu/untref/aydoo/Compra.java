package ar.edu.untref.aydoo;

public class Compra {
	
	private Producto productoComprado;

	public Compra(Producto producto){
		this.productoComprado = producto;
	}
	
	public Producto getProductoComprado(){
		return this.productoComprado;
	}

}
