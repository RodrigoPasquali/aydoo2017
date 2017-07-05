package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import excepciones.ExcepcionFormatoInvalido;
import excepciones.ExcepcionNumeroInvalido;
import excepciones.ExcepcionOrdenInvalido;
import excepciones.ExcepcionOutPutFileInvalido;

public class TestObtenedorDeArgumentos {
	@Test
	public void getFormatoDeberiaDevolverFormatoPretty() {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String[] cadena = {"360", "--format=pretty", "--output-file=salida.txt"};
		String valorEsperado = "--format=pretty";
		
		String valorActual = obtenedor.getFormato(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void getFormatoDeberiaDevolverFormatoQuiet() {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String[] cadena = {"360", "--format=quiet", "--output-file=salida.txt"};
		String valorEsperado = "--format=quiet";
		
		String valorActual = obtenedor.getFormato(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siNoSeIndicaFormatoDeberiaDevolverFormatoPretty() {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String[] cadena = {"360", "--output-file=salida.txt"};
		String valorEsperado = "--format=pretty";
		
		String valorActual = obtenedor.getFormato(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
    @Test
    public void siIndicoFormatoInvalidoDeberiaLanzarExcepcionFormatoInvalido() throws ExcepcionFormatoInvalido {
    	ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt"};
		
        try{
        	obtenedor.getFormato(cadena);
        }catch (ExcepcionFormatoInvalido e) {

        }
    }
	
	@Test
	public void getOrdenDeberiaDevolverOrdenAsc() {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt", "--sort=asc"};
		String valorEsperado = "--sort=asc";
		
		String valorActual = obtenedor.getOrden(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void getOrdenDeberiaDevolverOrdenDesc() {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt", "--sort=desc"};
		String valorEsperado = "--sort=desc";
		
		String valorActual = obtenedor.getOrden(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siNoIndicoOrdenDeberiaDevolverOrdenAsc(){ 
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt"};
		String valorEsperado = "--sort=asc";
		
		String valorActual = obtenedor.getOrden(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siIndicoOrdenInvalidoDeberiaLanzarExcepcionOrdenInvalido() throws ExcepcionOrdenInvalido {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String[] cadena = {"360", "--format=pretty", "--output-file=salida.txt", "--sort=yerba"};
		
		try{
	       	obtenedor.getOrden(cadena);
	    }catch (ExcepcionOrdenInvalido e) {

	    }
	}
	
	@Test
	public void getOutPutFileDeberiaDevolverSalidapuntotxt() {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt", "--sort=yerba"};
		String valorEsperado = "--output-file=salida.txt";
		
		String valorActual = obtenedor.getSalidaSolicitada(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siIndicoOutPutFileIgualYerbaDeberiaDevolverExcepcionOutPutFileInvalido() {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String[] cadena = {"360", "--format=pretty", "--output-file=yerba", "--sort=asc"};
		
		try{
	       	obtenedor.getSalidaSolicitada(cadena);
	    }catch (ExcepcionOutPutFileInvalido e){

	    }
	}
	
	@Test
	public void siNoSeIndicaOutPutFileDeberiaDevolverNada() {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--sort=yerba"};
		String valorEsperado = "";
		
		String valorActual = obtenedor.getSalidaSolicitada(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void getNumeroDeberiaDevolver360() {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String cadena = "360";
		int valorEsperado = 360;
		
		int valorActual = obtenedor.getNumero(cadena);
		
		assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void getNumeroDeKkDeberiaDevolverExcepcionNumeroInvalido() throws ExcepcionNumeroInvalido {
		ObtenedorDeArgumentos obtenedor = new ObtenedorDeArgumentos();
		String cadena = "kk";
		
		try{
	       	obtenedor.getNumero(cadena);
	    }catch (ExcepcionNumeroInvalido e) {

	    }
	}
}
