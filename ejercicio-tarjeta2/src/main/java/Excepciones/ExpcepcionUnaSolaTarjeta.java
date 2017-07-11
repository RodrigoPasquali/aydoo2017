package Excepciones;

public class ExpcepcionUnaSolaTarjeta extends RuntimeException {
	
    private final static String mensajeUnaSolaTarjeta = "El cliente ya posee una tarjeta y no puede tener mas de una.";
    
    public ExpcepcionUnaSolaTarjeta() {
        super(mensajeUnaSolaTarjeta);
    }
    
}
