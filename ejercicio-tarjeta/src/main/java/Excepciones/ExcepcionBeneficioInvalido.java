package Excepciones;

public class ExcepcionBeneficioInvalido extends RuntimeException {
	
    private final static String mensajeBeneficioInvalido = " El beneficio que desea utilizar no existe. Las opciones posibles son '2x1' o 'DescuentoPorcentaje'";
    
    public ExcepcionBeneficioInvalido() {
        super(mensajeBeneficioInvalido);
    }
    
}
