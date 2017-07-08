package Excepciones;

public class ExpecionFaltaProducto extends RuntimeException {
	
    private final static String mensajeFaltaProducto = "Ingrese otro producto para poder aplicar el beneficio";
    
    public ExpecionFaltaProducto() {
        super(mensajeFaltaProducto);
    }
    
}
