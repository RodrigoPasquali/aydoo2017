package ar.edu.untref.aydoo;

public class FactoresPrimos {
	
	public void calcularFactoresPrimos(int numero){
		int numeroOriginal = numero;
		String mensaje = "Factores primos de " + numeroOriginal + " = ";
		String factoresPrimos = "";
		if(numero == 1){
			System.out.println(mensaje + numeroOriginal);
		}else{
			for(int divisor = 2; divisor<=numero; divisor++){
				while(numero%divisor == 0){
					String convertir = String.valueOf(divisor);
					convertir = Integer.toString(divisor);
					factoresPrimos = factoresPrimos + convertir + " ";
					numero = numero/divisor;
				}
			}
			System.out.println(mensaje + factoresPrimos);
		}
	}	
}
