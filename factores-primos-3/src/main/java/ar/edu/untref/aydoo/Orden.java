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
	
	/*
	public List<Integer> ordenarNumeros(List<Integer> factoresPrimosIngresados, String orden) {
		this.listaDeFactoresPrimos = new LinkedList<Integer>();
		if (orden.equals("--sort=asc") || orden.equals("")) {
			this.listaDeFactoresPrimos = this.ordenAscendente(factoresPrimosIngresados);
		} else if (orden.equals("--sort=desc")) {
			this.listaDeFactoresPrimos = this.ordenDescendente(factoresPrimosIngresados);
		}
		return this.listaDeFactoresPrimos;
	}

	public List<Integer> ordenAscendente(List<Integer> factoresPrimosIngresados) {
		this.listaDeFactoresPrimos = factoresPrimosIngresados;
		Collections.sort(this.listaDeFactoresPrimos);
		return this.listaDeFactoresPrimos;
	}
	
	public List<Integer> ordenDescendente(List<Integer> factoresPrimosIngresados) {
		this.listaDeFactoresPrimos = factoresPrimosIngresados;
		Collections.sort(this.listaDeFactoresPrimos, Collections.reverseOrder());
		return this.listaDeFactoresPrimos;
	}
	
	public List<Integer> getOrdenDeNumeros() {
		return this.listaDeFactoresPrimos;
	}
	*/
}
