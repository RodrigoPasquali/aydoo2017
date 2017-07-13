package Excepciones;

public class ExcepcionFaltaProducto extends RuntimeException {
	
    private final static String mensajeFaltaProducto = "Ingrese otro producto para poder aplicar el beneficio";
    
    public ExcepcionFaltaProducto() {
        super(mensajeFaltaProducto);
    }
    
}
