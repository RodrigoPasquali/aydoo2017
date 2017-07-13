package Excepciones;

public class ExcepcionDosProductosPorCompra extends RuntimeException {
	
    private final static String mensajeDosPRoductos = "Solo se puede comprar 2 productos por Compra realizada";
    
    public ExcepcionDosProductosPorCompra() {
        super(mensajeDosPRoductos);
    }
    
}