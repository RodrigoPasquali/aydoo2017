package ar.edu.untref.aydoo;

public class Programa {
	    
    public boolean verificarSiArgumentosEsNumero(String cadena){
    		try{
    			Integer.parseInt(cadena);
    			return true;
        	} catch (NumberFormatException nfe){
        		System.out.println("El 1 elemento debe ser un numero natural");
        		return false;
    		}
    }

    public static final void main(String arg[]){
    	Programa lectorDeArgumentos = new Programa();
    	
    	if((arg.length == 2)){
    		try{
    			if(lectorDeArgumentos.verificarSiArgumentosEsNumero(arg[0])){
				int numero = Integer.parseInt(arg[0]);
				Calculadora calculadora = new Calculadora();
				Formato formato = new Formato();
				calculadora.calcularFactoresPrimos(numero);
				formato.aplicarFormato(arg[1], calculadora.obtenerFactoresPrimos(), numero);
				System.out.println(formato.aplicarFormato(arg[1], calculadora.obtenerFactoresPrimos(), numero));
    			}
    		}catch (NumberFormatException nfe){
    		System.out.println("El 1 elemento debe ser un numero natural");
    		}
    	}else if(arg.length == 1){
    		if(lectorDeArgumentos.verificarSiArgumentosEsNumero(arg[0])){
				int numero = Integer.parseInt(arg[0]);
				Calculadora calculadora = new Calculadora();
				Formato formato = new Formato();
				calculadora.calcularFactoresPrimos(numero);
				formato.formatoPretty("", calculadora.obtenerFactoresPrimos(), numero);
				System.out.println(formato.formatoPretty("", calculadora.obtenerFactoresPrimos(), numero));
    			}
    	}else{
    		System.out.println("Cantidad de argumentos invalidos");
    		}
    }
 
 }
