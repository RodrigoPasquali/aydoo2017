package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestVerificadorDeArgumentos {

	@Test
	public void verificarFormatoDeberiaDevolverPretty(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=pretty", "--output-file=salida.txt"};
		String valorEsperado = "--format=pretty";
		
		verificador.verificarFormato(cadena);
		String valorActual = verificador.getFormato();
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void verificarFormatoDeberiaDevolverQuiet(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=quiet", "--output-file=salida.txt"};
		String valorEsperado = "--format=quiet";
		
		verificador.verificarFormato(cadena);
		String valorActual = verificador.getFormato();
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siNoSeIndicaFormatoDeberiaDevolverPretty(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--output-file=salida.txt"};
		String valorEsperado = "--format=pretty";
		
		verificador.verificarFormato(cadena);
		String valorActual = verificador.getFormato();
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siPongoFormatIgualYerbaDeberiaDevolverExpecionFormatoInvalido(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt"};
		String valorEsperado = "Formato Invalido";
		
		verificador.verificarFormato(cadena);
		String valorActual = verificador.getFormato();
		
		assertEquals(valorEsperado,valorActual);
	}
	
}
