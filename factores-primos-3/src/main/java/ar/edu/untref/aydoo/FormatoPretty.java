package ar.edu.untref.aydoo;

import java.util.List;

public class FormatoPretty extends Formato {
	private Formato formatoSiguiente;
	
	public FormatoPretty(String formato, List<Integer> factoresPrimos, int numero) {
		super(formato, factoresPrimos, numero);
		this.formatoSiguiente = new FormatoQuiet(formato, factoresPrimos, numero);
	}

	@Override
	public void aplicarFormato() {
		this.setSiguienteFormato(this.formatoSiguiente);
		if(getFormato().equals("") || getFormato().equals("--format=pretty")) {
			//this.formatoSalida = this.formatoPretty(getListaDeFactoresPrimos(), getNumeroAFactorizar());
			setFormatoSalida(this.formatoPretty(getListaDeFactoresPrimos(), getNumeroAFactorizar()));
		} else {
			this.getSiguienteFormato().aplicarFormato();
		}
	}

	public String formatoPretty(List<Integer> factoresPrimos, int numero) {
		String stringFP = "";
		for (int i = 0; i <= factoresPrimos.size() - 1; i++) {
			stringFP = stringFP + factoresPrimos.get(i).toString() + " ";
		}
		String cadenaFormatoPretty = "Factores primos de " + numero + " : " + stringFP;
		return cadenaFormatoPretty;
	}

}
