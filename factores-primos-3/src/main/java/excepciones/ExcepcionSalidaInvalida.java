package excepciones;

public class ExcepcionSalidaInvalida extends RuntimeException {
	private final static String mensajeSalidaInvalida = "Salida no valida";
    
    public ExcepcionSalidaInvalida() {
        super(mensajeSalidaInvalida);
    }
}
