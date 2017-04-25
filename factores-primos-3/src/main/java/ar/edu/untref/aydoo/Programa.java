package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Programa {
	
	public static final void main(String arg[]){
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
			String salidaObtenida = formateador.aplicarFormato(formatoIngresado, listaDeFactoresPrimosOrdenados2, numero);
			if(outPutFile != null){
    			escritor = new EscrituraDeArchivos();
    			escritor.escribirArchivo(outPutFile, salidaObtenida);
    		}else{
    			System.out.println(salidaObtenida);
    		}
    	}else{
    		System.err.println("El primer argumento debe ser un numero");
    	}
    }
      
 }
