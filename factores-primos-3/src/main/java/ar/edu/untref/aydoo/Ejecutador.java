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

	public Ejecutador(){
		this.verificador = new VerificadorDeArgumentos();
		this.calculadora = new Calculadora();
		this.formateador = new Formato();
		this.ordenador = new Orden();
		this.listaDeFactoresPrimos = new LinkedList<Integer>();
	}
	
	public void ejecutarPeticion(String[] arg) throws IOException {
    	this.verificador.verificarSiArgumentosEsNumero(arg[0]);
    	int numero = Integer.parseInt(arg[0]);
    	this.verificador.verificarFormato(arg);
    	String formatoIngresado = this.verificador.getFormato();
    	this.verificador.verificarOrden(arg);
    	String ordenIngresado = this.verificador.getOrden();
    	this.verificador.verificarOutputFile(arg);
    	String outPutFile = this.verificador.getOutPutFile();
    	this.calculadora.calcularFactoresPrimos(numero);
    	this.listaDeFactoresPrimos = this.calculadora.obtenerFactoresPrimos();
    	this.ordenador.ordenarNumeros(this.listaDeFactoresPrimos, ordenIngresado);
		List<Integer> listaDeFactoresPrimosOrdenados = this.ordenador.getOrdenDeNumeros();
		this.salidaObtenida = this.formateador.aplicarFormato(formatoIngresado, listaDeFactoresPrimosOrdenados, numero);
		if (outPutFile != null) {
    		this.escritor = new EscrituraDeArchivos();
    		this.escritor.escribirArchivo(outPutFile, this.salidaObtenida);
    	} else {
    		System.out.println(this.salidaObtenida);
    	}
	}
	
	public String getSalida() {
		return this.salidaObtenida;
	}	
}
