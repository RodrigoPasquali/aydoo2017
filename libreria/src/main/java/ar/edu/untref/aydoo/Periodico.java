package ar.edu.untref.aydoo;

//Tipo de objeto: Value Object
public class Periodico extends ArticuloConSuscripcion{
	
	public Periodico(String nombre, double precio, int frecuenciaPublicacionMensual, boolean suscripcionAnual, String mes, int cantidad){
		super(nombre, precio, frecuenciaPublicacionMensual, suscripcionAnual, mes, cantidad);
	}

	
}
