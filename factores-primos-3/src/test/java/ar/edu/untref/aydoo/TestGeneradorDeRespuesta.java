package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import excepciones.ExcepcionNumeroInvalido;

public class TestGeneradorDeRespuesta {	
	@Test
	public void salidaDeberiaDevolverFactoresPrimosDe360ConFormatoQuietOrdenDesc() throws IOException {
		String[] entrada = {"360", "--format=quiet", "--sort=desc"};
		String valorEsperado = "5\r\n" + 
								"3\r\n" + 
								"3\r\n" + 
								"2\r\n" + 
								"2\r\n" + 
								"2\r\n";
		GeneradorDeRespuesta generador = new GeneradorDeRespuesta();
		
		generador.generarRespuesta(entrada);
		String valorActual = generador.getRespuesta();
		
		assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void siPrimerArgumentoNoEsNumeroDeberiaDevolverExcepcionNumeroInvalido() throws ExcepcionNumeroInvalido, IOException{
		String[] entrada = {"kk", "--format=quiet", "--sort=desc"};
		GeneradorDeRespuesta generador = new GeneradorDeRespuesta();
				
		try{
			generador.generarRespuesta(entrada);
	    }catch (ExcepcionNumeroInvalido e){
	    	
	    }
	}

	@Test
	public void salidaDeberiaDevolverFactoresPrimosDe100ConFormatoPrettyOrdenAsc() throws IOException {
		String[] entrada = {"100", "--format=pretty", "--sort=asc", "--output-file=salida.txt"};
		String valorEsperado = "Factores primos de 100 : 2 2 5 5 ";
		GeneradorDeRespuesta generador = new GeneradorDeRespuesta();
		
		generador.generarRespuesta(entrada);
		String valorActual = generador.getRespuesta();
		
		assertEquals(valorEsperado, valorActual);
	}	
}
