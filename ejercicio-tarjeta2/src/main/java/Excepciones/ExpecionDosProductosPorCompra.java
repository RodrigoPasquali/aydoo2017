package Excepciones;

public class ExpecionDosProductosPorCompra extends RuntimeException {
	
    private final static String mensajeDosPRoductos = "Solo se puede comprar 2 productos por Compra realizada";
    
    public ExpecionDosProductosPorCompra() {
        super(mensajeDosPRoductos);
    }
    
}