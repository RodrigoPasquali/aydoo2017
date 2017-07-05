package ar.edu.untref.aydoo;

import java.util.Collections;
import java.util.List;

public class OrdenAscendente extends Orden {
	private Orden ordenSiguiente;
	
	public OrdenAscendente(String orden, List<Integer> factoresPrimos) {
		super(orden, factoresPrimos);
		this.ordenSiguiente= new OrdenDescendente(orden, factoresPrimos);
	}

	@Override
	public List<Integer> aplicarOrden() {
		this.setSiguienteOrden(this.ordenSiguiente);
		if(getOrden().equals("") || getOrden().equals("--sort=asc")) {
			return this.ordenAscendente(getListaDeFactoresPrimos());
		} else {
			return this.getSiguienteOrden().aplicarOrden();
		}
	}

	private List<Integer> ordenAscendente(List<Integer> factoresPrimosIngresados) {
		List<Integer> factoresOrdenados = factoresPrimosIngresados;
		Collections.sort(factoresOrdenados);
		return factoresOrdenados;
	}

}

