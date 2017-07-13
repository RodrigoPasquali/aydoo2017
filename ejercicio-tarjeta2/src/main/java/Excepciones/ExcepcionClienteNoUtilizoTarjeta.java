package Excepciones;

public class ExcepcionClienteNoUtilizoTarjeta extends RuntimeException {
	
    private final static String mensajeClienteNoUtilizoTarjeta = "El cliente solicitado no realizo compras en el mes indicado";
    
    public ExcepcionClienteNoUtilizoTarjeta() {
        super(mensajeClienteNoUtilizoTarjeta);
    }
    
}