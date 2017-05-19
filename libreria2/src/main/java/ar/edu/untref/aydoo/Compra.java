package ar.edu.untref.aydoo;

public class Compra {
	private Mes mes;
	private Producto producto;

	public Compra(Producto productoComprado, Mes mesDeLaCompra) {
		this.producto = productoComprado;
		this.mes = mesDeLaCompra;
	}
}
