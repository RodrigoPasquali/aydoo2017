package Excepciones;

public class ExpecionBeneficioInvalido extends RuntimeException {
	
    private final static String mensajeBeneficioInvalido = " El beneficio que desea utilizar no existe. Las opciones posibles son '2x1' o 'DescuentoPorcentaje'";
    
    public ExpecionBeneficioInvalido() {
        super(mensajeBeneficioInvalido);
    }
    
}
