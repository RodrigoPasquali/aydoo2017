package ar.edu.untref.aydoo;

public abstract class Frecuencia {
	public Frecuencia siguiente;
	public String tipoDeFrecuencia;
	
	public Frecuencia(String frecuencia){
		this.tipoDeFrecuencia = frecuencia;
	}
	
	public void setfrecuenciaSiguiente(Frecuencia frecuencia){
		this.siguiente = frecuencia;
	}
	
	public Frecuencia getDrecuenciaSiguiente(){
		return this.siguiente;
	}
	
	public String getTipoDeFrecuencia(){
		return this.tipoDeFrecuencia;
	}
	
	public abstract int getFrecuenciaAlMes(String frecuencia);
	
	public abstract void inicializarFrecuenciaAlMes(String frecuencia);
}
