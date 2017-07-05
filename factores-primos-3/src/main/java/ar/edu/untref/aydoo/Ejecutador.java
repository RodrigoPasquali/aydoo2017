package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Ejecutador {
private String salidaObtenida;
private ObtenedorDeArgumentos obtenedor;
private Calculadora calculadora;
private Formato formateador;
private Orden ordenador;
private SalidaEscrituraDeArchivos escritor;
private List<Integer> listaDeFactoresPrimos;
private int numeroIngresado;
private String formatoIngresado;
private String ordenIngresado;
private String outPutFile;

	public Ejecutador() {
		this.obtenedor = new ObtenedorDeArgumentos();
		this.calculadora = new Calculadora();
		this.listaDeFactoresPrimos = new LinkedList<Integer>();
	}
	
	public void ejecutarPeticion(String[] arg) throws IOException {
    	this.obtenerArgumentos(arg);
    	this.calculadora.calcularFactoresPrimos(this.numeroIngresado);
    	this.listaDeFactoresPrimos = this.calculadora.obtenerFactoresPrimos();
    	this.ordenador = new OrdenAscendente(this.ordenIngresado, this.listaDeFactoresPrimos);
    	List<Integer> listaDeFactoresPrimosOrdenados = this.ordenador.aplicarOrden();
		this.formateador = new FormatoPretty(this.formatoIngresado, listaDeFactoresPrimosOrdenados, this.numeroIngresado);
		this.salidaObtenida = this.formateador.aplicarFormato();
		if (this.outPutFile != null) {
    		this.escritor = new SalidaEscrituraDeArchivos();
    		this.escritor.escribirArchivo(this.outPutFile, this.salidaObtenida);
    	} else {
    		System.out.println(this.salidaObtenida);
    	}
	}
	
	public void obtenerArgumentos(String[] args) {
		this.numeroIngresado = this.obtenedor.getNumero(args[0]);
    	this.formatoIngresado = this.obtenedor.getFormato(args);
    	this.ordenIngresado = this.obtenedor.getOrden(args);
    	this.outPutFile = this.obtenedor.getOutputFile(args);
	}
	
	public String getSalida() {
		return this.salidaObtenida;
	}	
}
