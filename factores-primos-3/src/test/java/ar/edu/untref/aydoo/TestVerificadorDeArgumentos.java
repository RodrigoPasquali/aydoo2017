package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
	public void siPongoFormatIgualYerbaDeberiaDevolverExpecionFormatoInvalido(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt"};
		String valorEsperado = "Formato Invalido";
		
		verificador.verificarFormato(cadena);
		String valorActual = verificador.getFormato();
		
		assertEquals(valorEsperado,valorActual);
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
	public void siIndicoOrdenIgualYerbaDeberiaVolverExcepcionOrdenInvalido(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt", "--sort=yerba"};
		String valorEsperado = "Orden Invalido";
		
		verificador.verificarOrden(cadena);
		String valorActual = verificador.getOrden();
		
		assertEquals(valorEsperado,valorActual);
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
	
	/*
	@Test
	public void siIndicoOutPutFileIgualYerbaDeberiaDevolverExcepcionOutPutFileInvalido(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=yerba", "--sort=yerba"};
		String valorEsperado = "File OutPut Invalido";
		
		verificador.verificarOutputFile(cadena);
		String valorActual = verificador.getOutPutFile();
		
		assertEquals(valorEsperado,valorActual);
	}
	*/
	
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
	public void verificarSiArgumentosEsNumeroDeberiaDevolverFalse(){
		VerificadorDeArgumentos verificador = new VerificadorDeArgumentos();
		String cadena = "kk";
		boolean valorEsperado = false;
		
		boolean valorActual = verificador.verificarSiArgumentosEsNumero(cadena);
		
		assertEquals(valorEsperado, valorActual);
	}
	
}
