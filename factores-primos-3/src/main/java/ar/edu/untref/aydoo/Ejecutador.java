package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Ejecutador {

String salidaObtenida;
	
	public void ejecutarPeticion(String[] arg){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
    	Calculadora calculadora = new Calculadora();
    	Formato formateador = new Formato();
    	Orden ordenador = new Orden();
    	EscrituraDeArchivos escritor;
    	List<Integer> listaDeFactoresPrimos = new LinkedList<Integer>();
    	if(verificador.verificarSiArgumentosEsNumero(arg[0])){
    		int numero = Integer.parseInt(arg[0]);
    		verificador.verificarFormato(arg);
    		String formatoIngresado = verificador.getFormato();
    		verificador.verificarOrden(arg);
    		String ordenIngresado = verificador.getOrden();
    		verificador.verificarOutputFile(arg);
    		String outPutFile = verificador.getOutPutFile();
    		calculadora.calcularFactoresPrimos(numero);
			listaDeFactoresPrimos = calculadora.obtenerFactoresPrimos();
			ordenador.ordenarNumeros(listaDeFactoresPrimos, ordenIngresado);
			List<Integer> listaDeFactoresPrimosOrdenados2 = ordenador.getOrdenDeNumeros();
			this.salidaObtenida = formateador.aplicarFormato(formatoIngresado, listaDeFactoresPrimosOrdenados2, numero);
			if(outPutFile != null){
    			escritor = new EscrituraDeArchivos();
    			escritor.escribirArchivo(outPutFile, this.salidaObtenida);
    		}else{
    			System.out.println(this.salidaObtenida);
    		}
    	}else{
    		this.salidaObtenida = "El primer argumento debe ser un numero";
    		System.err.println(this.salidaObtenida);
    	}
	}
	
	public String getSalida(){
		return this.salidaObtenida;
	}
	
}
