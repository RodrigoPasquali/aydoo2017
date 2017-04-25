package ar.edu.untref.aydoo;

public class ExcepcionOutPutFileInvalido extends RuntimeException {

    private final static String mensajeOutPutFileInvalido = " Archivo no aceptado. El archvio debe poseer extencion .txt";
    
    public ExcepcionOutPutFileInvalido(){
        super(mensajeOutPutFileInvalido);
    }

}
