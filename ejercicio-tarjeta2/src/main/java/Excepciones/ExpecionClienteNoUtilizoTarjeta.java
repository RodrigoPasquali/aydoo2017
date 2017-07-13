package Excepciones;

public class ExpecionClienteNoUtilizoTarjeta extends RuntimeException {
	
    private final static String mensajeClienteNoUtilizoTarjeta = "El cliente solicitado no realizo compras en el mes indicado";
    
    public ExpecionClienteNoUtilizoTarjeta() {
        super(mensajeClienteNoUtilizoTarjeta);
    }
    
}