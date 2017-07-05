package ar.edu.untref.aydoo;

import java.io.IOException;

public abstract class Salida {
	private String cadenaDeSalida;
	private String salidaSolicitada;
	private Salida salidaSiguiente;
	
	public Salida(String salida, String cadena){
		this.salidaSolicitada = salida;
		this.cadenaDeSalida = cadena;
	}
	
	public abstract void aplicarSalidaSolicitada() throws IOException;
	
	public String getSalidaSolicitada() {
		return this.salidaSolicitada;
	}
	
	public void setSiguienteSalida(Salida salida) {
		this.salidaSiguiente = salida;
	}
	
	public Salida getSiguienteSalida() {
		return this.salidaSiguiente;
	}

	public String getCadenaDeSalida(){
		return this.cadenaDeSalida;
	}
}
