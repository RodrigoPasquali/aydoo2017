package ar.edu.untref.aydoo;

import java.util.Collections;
import java.util.List;

import excepciones.ExcepcionOrdenInvalido;

public class OrdenDescendente extends Orden {
	
	public OrdenDescendente(String orden, List<Integer> factoresPrimos) {
		super(orden, factoresPrimos);
	}

	@Override
	public List<Integer> aplicarOrden() {
		if(getOrden().equals("--sort=desc")) {
			return this.ordenDescendente(getListaDeFactoresPrimos());
		} else {
	        throw new ExcepcionOrdenInvalido();
	    }
	}

	public List<Integer> ordenDescendente(List<Integer> factoresPrimosIngresados) {
		List<Integer> factoresOrdenados = factoresPrimosIngresados;
		Collections.sort(factoresOrdenados, Collections.reverseOrder());
		return factoresOrdenados;
	}
}
