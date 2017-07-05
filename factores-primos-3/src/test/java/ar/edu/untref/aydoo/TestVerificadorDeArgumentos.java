package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import excepciones.ExcepcionFormatoInvalido;
import excepciones.ExcepcionNumeroInvalido;
import excepciones.ExcepcionOrdenInvalido;
import excepciones.ExcepcionOutPutFileInvalido;

public class TestVerificadorDeArgumentos {

	@Test
	public void verificarFormatoDeberiaDevolverFormatoPretty(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=pretty", "--output-file=salida.txt"};
		String valorEsperado = "--format=pretty";
		
		verificador.verificarFormato(cadena);
		String valorActual = verificador.getFormato();
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void verificarFormatoDeberiaDevolverFormatoQuiet(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=quiet", "--output-file=salida.txt"};
		String valorEsperado = "--format=quiet";
		
		verificador.verificarFormato(cadena);
		String valorActual = verificador.getFormato();
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siNoSeIndicaFormatoDeberiaDevolverFormatoPretty(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--output-file=salida.txt"};
		String valorEsperado = "--format=pretty";
		
		verificador.verificarFormato(cadena);
		String valorActual = verificador.getFormato();
		
		assertEquals(valorEsperado,valorActual);
	}
	
    @Test
    public void siIndicoFormatoInvalidoDeberiaLanzarExcepcionFormatoInvalido() throws ExcepcionFormatoInvalido {
    	VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt"};
		
        try{
        	verificador.verificarFormato(cadena);
        }catch (ExcepcionFormatoInvalido e){

        }
    }
	
	@Test
	public void verificarOrdenDeberiaDevolverOrdenAsc(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt", "--sort=asc"};
		String valorEsperado = "--sort=asc";
		
		verificador.verificarOrden(cadena);
		String valorActual = verificador.getOrden();
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void verificarOrdenDeberiaDevolverOrdenDesc(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt", "--sort=desc"};
		String valorEsperado = "--sort=desc";
		
		verificador.verificarOrden(cadena);
		String valorActual = verificador.getOrden();
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siNoIndicoOrdenDeberiaDevolverOrdenAsc(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt"};
		String valorEsperado = "--sort=asc";
		
		verificador.verificarOrden(cadena);
		String valorActual = verificador.getOrden();
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siIndicoOrdenInvalidoDeberiaLanzarExcepcionOrdenInvalido() throws ExcepcionOrdenInvalido {
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=pretty", "--output-file=salida.txt", "--sort=yerba"};
		
		try{
	       	verificador.verificarOrden(cadena);
	    }catch (ExcepcionOrdenInvalido e){

	    }
	}
	
	@Test
	public void verificarOutPutFileDeberiaDevolverSalidapuntotxt(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt", "--sort=yerba"};
		String valorEsperado = "salida.txt";
		
		verificador.verificarOutputFile(cadena);
		String valorActual = verificador.getOutPutFile();
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siIndicoOutPutFileIgualYerbaDeberiaDevolverExcepcionOutPutFileInvalido(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=pretty", "--output-file=yerba", "--sort=asc"};
		
		try{
	       	verificador.verificarOutputFile(cadena);
	    }catch (ExcepcionOutPutFileInvalido e){

	    }
	}
	
	@Test
	public void siNoSeIndicaOutPutFileDeberiaDevolverNull(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--sort=yerba"};
		String valorEsperado = null;
		
		verificador.verificarOutputFile(cadena);
		String valorActual = verificador.getOutPutFile();
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void verificarSiArgumentosEsNumeroDeberiaDevolverTrue(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String cadena = "360";
		boolean valorEsperado = true;
		
		boolean valorActual = verificador.verificarSiArgumentosEsNumero(cadena);
		
		assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void verificarSiArgumentosEsNumeroDeberiaDevolverExcepcionNumeroInvalido() throws ExcepcionNumeroInvalido{
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String cadena = "kk";
		
		try{
	       	verificador.verificarSiArgumentosEsNumero(cadena);
	    }catch (ExcepcionNumeroInvalido e){

	    }
	}
	
}
