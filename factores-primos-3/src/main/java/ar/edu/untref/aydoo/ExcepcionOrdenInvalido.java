package ar.edu.untref.aydoo;

public class ExcepcionOrdenInvalido extends RuntimeException {

    private final static String mensajeOrdenInvalido = " Orden no aceptado. Las opciones posibles son asc o desc";
    
    public ExcepcionOrdenInvalido(){
        super(mensajeOrdenInvalido);
    }
    
}
