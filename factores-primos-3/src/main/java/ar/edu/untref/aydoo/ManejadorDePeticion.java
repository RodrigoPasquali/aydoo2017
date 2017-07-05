package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ManejadorDePeticion {
private String salidaObtenida;
private SalidaEscrituraDeArchivos escritor;
private List<Integer> listaDeFactoresPrimos;
private int numeroIngresado;
private String formatoIngresado;
private String ordenIngresado;
private String outPutFile;

	public ManejadorDePeticion() {
		this.listaDeFactoresPrimos = new LinkedList<Integer>();
	}
	
	public void ejecutarPeticion(String[] arg) throws IOException {
    	obtenerArgumentos(arg);
    	calcularFactoresPrimos();
    	ordenarFactoresPrimos();
    	darFormatoASalida();
		if (this.outPutFile != null) {
    		this.escritor = new SalidaEscrituraDeArchivos();
    		this.escritor.escribirArchivo(this.outPutFile, this.salidaObtenida);
    	} else {
    		System.out.println(this.salidaObtenida);
    	}
	}
	
	private void obtenerArgumentos(String[] args) {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		this.numeroIngresado = obtenedor.getNumero(args[0]);
    	this.formatoIngresado =obtenedor.getFormato(args);
    	this.ordenIngresado = obtenedor.getOrden(args);
    	this.outPutFile = obtenedor.getOutputFile(args);
	}
	
	private void calcularFactoresPrimos(){
		Calculadora calculadora = new Calculadora();
		calculadora.calcularFactoresPrimos(this.numeroIngresado);
		this.listaDeFactoresPrimos = calculadora.obtenerFactoresPrimos();
	}
	
	private void ordenarFactoresPrimos(){
		Orden ordenador;
		ordenador = new OrdenAscendente(this.ordenIngresado, this.listaDeFactoresPrimos);
		this.listaDeFactoresPrimos = ordenador.aplicarOrden();
	}
	
	private void darFormatoASalida(){
		Formato formateador = new FormatoPretty(this.formatoIngresado, this.listaDeFactoresPrimos, this.numeroIngresado);
		this.salidaObtenida = formateador.aplicarFormato();
	}
	
	public String getSalida() {
		return this.salidaObtenida;
	}	
}
