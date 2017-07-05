package excepciones;

public class ExcepcionFormatoInvalido extends RuntimeException {
    private final static String mensajeFormatoInvalido = " Formato no aceptado. Las opciones posibles son pretty o quiet";
    
    public ExcepcionFormatoInvalido() {
        super(mensajeFormatoInvalido);
    }
}
