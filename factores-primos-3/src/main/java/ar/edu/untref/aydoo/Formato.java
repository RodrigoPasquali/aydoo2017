package ar.edu.untref.aydoo;

import java.util.List;

public abstract class Formato {
	private String formatoAFactorizarEnMiniscula;
	private int numeroAFactorizar;
	private List<Integer> listaDeFactoresPrimos;
	private Formato formatoSiguiente;
	
	public Formato(String formato, List<Integer> factoresPrimos, int numero){
		this.formatoAFactorizarEnMiniscula = formato.toLowerCase();
		this.numeroAFactorizar = numero;
		this.listaDeFactoresPrimos = factoresPrimos;
	}
	
	public abstract String aplicarFormato();
	
	public String getFormato() {
		return this.formatoAFactorizarEnMiniscula;
	}
	
	public void setSiguienteFormato(Formato formato) {
		this.formatoSiguiente = formato;
	}
	
	public Formato getSiguienteFormato() {
		return this.formatoSiguiente;
	}
	
	public int getNumeroAFactorizar() {
		return numeroAFactorizar;
	}

	public List<Integer> getListaDeFactoresPrimos() {
		return listaDeFactoresPrimos;
	}
	
}
