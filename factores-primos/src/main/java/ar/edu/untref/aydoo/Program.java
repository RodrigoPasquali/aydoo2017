package ar.edu.untref.aydoo;

public class Program {
	
    public static final void main(String arg[]){
    	for(int i = 0; i<arg.length; i++){
    		String cadena = arg[i];	
        	int numero = Integer.parseInt(cadena);
        	FactoresPrimos numerosFactoresPrimos = new FactoresPrimos();
        	numerosFactoresPrimos.calcularFactoresPrimos(numero);
    	}
    }
}
