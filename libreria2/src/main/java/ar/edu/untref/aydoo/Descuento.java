package ar.edu.untref.aydoo;

public abstract class Descuento {
	Descuento siguiente;
	private String tipoDeDescuento;
	
	public Descuento(String anual){
		this.tipoDeDescuento = anual;
	}
	
	public abstract void calcularDescuento();
	
	public abstract int getPorcentajeDeDescuento();
}
