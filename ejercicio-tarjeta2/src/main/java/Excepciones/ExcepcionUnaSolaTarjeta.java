package Excepciones;

public class ExcepcionUnaSolaTarjeta extends RuntimeException {
	
    private final static String mensajeUnaSolaTarjeta = "El cliente ya posee una tarjeta y no puede tener mas de una.";
    
    public ExcepcionUnaSolaTarjeta() {
        super(mensajeUnaSolaTarjeta);
    }
    
}
