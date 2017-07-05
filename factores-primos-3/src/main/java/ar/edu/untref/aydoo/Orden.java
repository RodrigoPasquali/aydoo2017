package ar.edu.untref.aydoo;

import java.util.List;

public abstract class Orden {
	private List<Integer> listaDeFactoresPrimos;
	private String ordenAFactorizarEnMiniscula;
	private Orden ordenSiguiente;
	
	public Orden(String orden, List<Integer> factoresPrimos){
		this.ordenAFactorizarEnMiniscula = orden.toLowerCase();
		this.listaDeFactoresPrimos = factoresPrimos;
	}
	
	public abstract List<Integer> aplicarOrden();
	
	public String getOrden() {
		return this.ordenAFactorizarEnMiniscula;
	}
	
	public void setSiguienteOrden(Orden orden) {
		this.ordenSiguiente = orden;
	}
	
	public Orden getSiguienteOrden() {
		return this.ordenSiguiente;
	}

	public List<Integer> getListaDeFactoresPrimos() {
		return listaDeFactoresPrimos;
	}

}
