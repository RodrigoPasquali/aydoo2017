package Excepciones;

public class ExcepcionPocentajeDescuentoInvalido extends RuntimeException {
	
    private final static String mensajePorcentajeInvalido = "El porcetaje ingresado para descuento debe ser mayor a 5 y menor a 100";
    
    public ExcepcionPocentajeDescuentoInvalido() {
        super(mensajePorcentajeInvalido);
    }
    
}