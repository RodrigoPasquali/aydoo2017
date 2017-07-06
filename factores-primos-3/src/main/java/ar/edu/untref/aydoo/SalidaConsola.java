package ar.edu.untref.aydoo;

import java.io.IOException;

public class SalidaConsola extends Salida {
	private Salida salidaSiguiente;
	
	public SalidaConsola(String salida, String cadena) {
		super(salida, cadena);
		this.salidaSiguiente = new SalidaEscrituraDeArchivos(salida, cadena);
	}

	@Override
	public void aplicarSalidaSolicitada() throws IOException {
		setSiguienteSalida(this.salidaSiguiente);
		if(getSalidaSolicitada().equals("")) {
			imprimirEnConsola(getCadenaDeSalida());
		} else {
			getSiguienteSalida().aplicarSalidaSolicitada();
		}
	}
	
	protected String imprimirEnConsola(String cadena) {
		System.out.println(cadena);
		return cadena;
	}
}
