package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Ejecutador {
private String salidaObtenida;
private VerificadorDeArgumentos verificador;
private Calculadora calculadora;
private Formato formateador;
private Orden ordenador;
private EscrituraDeArchivos escritor;
private List<Integer> listaDeFactoresPrimos;
private int numeroIngresado;
private String formatoIngresado;
private String ordenIngresado;
private String outPutFile;

	public Ejecutador() {
		this.verificador = new VerificadorDeArgumentos();
		this.calculadora = new Calculadora();
		this.formateador = new Formato();
		this.ordenador = new Orden();
		this.listaDeFactoresPrimos = new LinkedList<Integer>();
	}
	
	public void ejecutarPeticion(String[] arg) throws IOException {
		this.verificarArgumentos(arg);
    	this.obtenerArgumentos(arg);
    	this.calculadora.calcularFactoresPrimos(numeroIngresado);
    	this.listaDeFactoresPrimos = this.calculadora.obtenerFactoresPrimos();
    	this.ordenador.ordenarNumeros(this.listaDeFactoresPrimos, ordenIngresado);
		List<Integer> listaDeFactoresPrimosOrdenados = this.ordenador.getOrdenDeNumeros();
		this.salidaObtenida = this.formateador.aplicarFormato(formatoIngresado, listaDeFactoresPrimosOrdenados, numeroIngresado);
		if (outPutFile != null) {
    		this.escritor = new EscrituraDeArchivos();
    		this.escritor.escribirArchivo(outPutFile, this.salidaObtenida);
    	} else {
    		System.out.println(this.salidaObtenida);
    	}
	}
	
	public void verificarArgumentos(String[] args) {
    	this.verificador.verificarSiArgumentosEsNumero(args[0]);
    	this.verificador.verificarFormato(args);
    	this.verificador.verificarOrden(args);
    	this.verificador.verificarOutputFile(args);
	}
	
	public void obtenerArgumentos(String[] args) {
		numeroIngresado = Integer.parseInt(args[0]);
    	formatoIngresado = this.verificador.getFormato();
    	ordenIngresado = this.verificador.getOrden();
    	outPutFile = this.verificador.getOutPutFile();
	}
	
	public String getSalida() {
		return this.salidaObtenida;
	}	
}
