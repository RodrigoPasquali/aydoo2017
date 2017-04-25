package ar.edu.untref.aydoo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Orden {
	
	private List<Integer> factoresPrimos;
	
	public List<Integer> ordenarNumeros(List<Integer> factoresPrimosIngresados, String orden){
		this.factoresPrimos = new LinkedList<Integer>();
		if(orden.equals("--sort=asc") || orden.equals("")){
			this.factoresPrimos = this.ordenAscendente(factoresPrimosIngresados);
		}else if(orden.equals("--sort=desc")){
			this.factoresPrimos = this.ordenDescendente(factoresPrimosIngresados);
		}
		return this.factoresPrimos;
	}

	public List<Integer> ordenAscendente(List<Integer> factoresPrimosIngresados){
		this.factoresPrimos = factoresPrimosIngresados;
		Collections.sort(this.factoresPrimos);
		return this.factoresPrimos;
	}
	
	public List<Integer> ordenDescendente(List<Integer> factoresPrimosIngresados){
		this.factoresPrimos = factoresPrimosIngresados;
		Collections.sort(this.factoresPrimos, Collections.reverseOrder());
		return this.factoresPrimos;
	}
	
	public List<Integer> getOrdenDeNumeros(){
		return this.factoresPrimos;
	}

}
