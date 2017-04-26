package ar.edu.untref.aydoo;

public class ExcepcionNumeroInvalido extends RuntimeException {
    private final static String mensajeNumeroInvalido = " El primero Argumento debe ser un numero natural";
    
    public ExcepcionNumeroInvalido() {
        super(mensajeNumeroInvalido);
    }
}
