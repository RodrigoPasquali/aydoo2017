package ar.edu.untref.aydoo;

import java.util.Collections;
import java.util.List;

public class Orden {
	
	private List<Integer> factoresPrimos;

	public List<Integer> ordenAscendente(List<Integer> factoresPrimosIngresados){
		this.factoresPrimos = factoresPrimosIngresados;
		Collections.sort(factoresPrimos);
		return this.factoresPrimos;
	}
	
	public List<Integer> ordenDescendente(List<Integer> factoresPrimosIngresados){
		this.factoresPrimos = factoresPrimosIngresados;
		Collections.sort(factoresPrimos, Collections.reverseOrder());
		return this.factoresPrimos;
	}

}
