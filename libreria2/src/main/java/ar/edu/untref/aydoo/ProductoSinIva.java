package ar.edu.untref.aydoo;

public class ProductoSinIva extends Producto {
	public ProductoSinIva(String nombre, String tipoDeProducto, double precio){
		super(nombre, nombre, precio);
	}

	@Override
	public double obtenerPrecioFinal() {
		double precioFinal;
		this.siguiente = new ProductoConIva(getNombre(), getTipoDeProducto(), getPrecio());
		if(!this.poseeIva()){
			precioFinal = this.getPrecio();
		}else{
			precioFinal = this.siguiente.obtenerPrecioFinal();
		}
		return precioFinal;
	}
}
