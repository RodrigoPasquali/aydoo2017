package ar.edu.untref.aydoo;

import java.util.List;

public class FormatoQuiet extends Formato {
	private List <Integer> factoresPrimosObtenidos;
	private int numeroObtenido;
	//private String formatoObtenido;
	
	public FormatoQuiet(String formato, List<Integer> factoresPrimos, int numero) {
		super(formato, factoresPrimos, numero);
		this.factoresPrimosObtenidos = factoresPrimos;
		this.numeroObtenido = numero;
		//this.formatoObtenido = formato.toLowerCase();
	}

	@Override
	public void aplicarFormato() {
		if(getFormato().equals("--format=quiet")) {
			//this.formatoSalida = this.formatoQuiet(this.factoresPrimosObtenidos, this.numeroObtenido);
			setFormatoSalida(this.formatoQuiet(this.factoresPrimosObtenidos, this.numeroObtenido));
		} else {
	        throw new ExcepcionFormatoInvalido();
	    }
	}

	private String formatoQuiet(List<Integer> factoresPrimos, int numero) {
		String stringFP = "";
		for (int i = 0; i <= factoresPrimos.size() - 1; i++) {
			stringFP = stringFP + factoresPrimos.get(i).toString() + "\r\n";
		}
		return stringFP;
	}
	
}
