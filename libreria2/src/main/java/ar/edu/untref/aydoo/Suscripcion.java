package ar.edu.untref.aydoo;

public class Suscripcion {
	private ArticuloConSuscripcion articulo;
	private Frecuencia periodicidad;

	public Suscripcion(ArticuloConSuscripcion articuloASuscribirse, Frecuencia periodicidadDeArticulo, Descuento descuento){
		this.articulo = articuloASuscribirse;
		this.periodicidad = periodicidadDeArticulo;
	}
}
