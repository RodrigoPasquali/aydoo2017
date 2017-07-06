package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GeneradorDeRespuesta {
private String salidaObtenida;
private List<Integer> listaDeFactoresPrimos;
private int numeroIngresado;
private String formatoIngresado;
private String ordenIngresado;
private String salidaSolicitadaIngresada;

	public GeneradorDeRespuesta() {
		this.listaDeFactoresPrimos = new LinkedList<Integer>();
	}
	
	public void generarRespuesta(String[] arg) throws IOException {
    	obtenerArgumentos(arg);
    	calcularFactoresPrimos();
    	ordenarFactoresPrimos();
    	darFormatoASalida();
    	ejecutarTipoDeSalida();
	}
	
	private void obtenerArgumentos(String[] args) {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		this.numeroIngresado = obtenedor.getNumero(args[0]);
    	this.formatoIngresado =obtenedor.getFormato(args);
    	this.ordenIngresado = obtenedor.getOrden(args);
    	this.salidaSolicitadaIngresada = obtenedor.getSalidaSolicitada(args);
	}
	
	private void calcularFactoresPrimos() {
		Calculadora calculadora = new Calculadora();
		calculadora.calcularFactoresPrimos(this.numeroIngresado);
		this.listaDeFactoresPrimos = calculadora.obtenerFactoresPrimos();
	}
	
	private void ordenarFactoresPrimos() {
		Orden ordenador;
		ordenador = new OrdenAscendente(this.ordenIngresado, this.listaDeFactoresPrimos);
		this.listaDeFactoresPrimos = ordenador.aplicarOrden();
	}
	
	private void darFormatoASalida() {
		Formato formateador = new FormatoPretty(this.formatoIngresado, this.listaDeFactoresPrimos, this.numeroIngresado);
		this.salidaObtenida = formateador.aplicarFormato();
	}
	
	private void ejecutarTipoDeSalida() throws IOException {
		Salida manejadorDeSalida = new SalidaConsola(this.salidaSolicitadaIngresada, this.salidaObtenida);
		manejadorDeSalida.aplicarSalidaSolicitada();
	}
	
	public String getRespuesta() {
		return this.salidaObtenida;
	}	
}
