package ar.edu.untref.aydoo;

public class Revista extends ArticuloConSuscripcion{

	public Revista(String nombre, double precio, int frecuenciaPublicacionMensual, boolean suscripcionAnual, String mes, int cantidad){
		super(nombre, precio, frecuenciaPublicacionMensual, suscripcionAnual, mes, cantidad);
	}

}
