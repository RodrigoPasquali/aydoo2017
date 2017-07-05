package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import excepciones.ExcepcionFormatoInvalido;
import excepciones.ExcepcionNumeroInvalido;
import excepciones.ExcepcionOrdenInvalido;
import excepciones.ExcepcionOutPutFileInvalido;

public class TestObtencionDeArgumentos {

	@Test
	public void getFormatoDeberiaDevolverFormatoPretty(){
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String[] cadena = {"360", "--format=pretty", "--output-file=salida.txt"};
		String valorEsperado = "--format=pretty";
		
		String valorActual = obtenedor.getFormato(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void getFormatoDeberiaDevolverFormatoQuiet(){
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String[] cadena = {"360", "--format=quiet", "--output-file=salida.txt"};
		String valorEsperado = "--format=quiet";
		
		String valorActual = obtenedor.getFormato(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siNoSeIndicaFormatoDeberiaDevolverFormatoPretty(){
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String[] cadena = {"360", "--output-file=salida.txt"};
		String valorEsperado = "--format=pretty";
		
		String valorActual = obtenedor.getFormato(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
    @Test
    public void siIndicoFormatoInvalidoDeberiaLanzarExcepcionFormatoInvalido() throws ExcepcionFormatoInvalido {
    	ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt"};
		
        try{
        	obtenedor.getFormato(cadena);
        }catch (ExcepcionFormatoInvalido e){

        }
    }
	
	@Test
	public void getOrdenDeberiaDevolverOrdenAsc(){
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt", "--sort=asc"};
		String valorEsperado = "--sort=asc";
		
		String valorActual = obtenedor.getOrden(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void getOrdenDeberiaDevolverOrdenDesc(){
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt", "--sort=desc"};
		String valorEsperado = "--sort=desc";
		
		String valorActual = obtenedor.getOrden(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siNoIndicoOrdenDeberiaDevolverOrdenAsc(){
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt"};
		String valorEsperado = "--sort=asc";
		
		String valorActual = obtenedor.getOrden(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siIndicoOrdenInvalidoDeberiaLanzarExcepcionOrdenInvalido() throws ExcepcionOrdenInvalido {
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String[] cadena = {"360", "--format=pretty", "--output-file=salida.txt", "--sort=yerba"};
		
		try{
	       	obtenedor.getOrden(cadena);
	    }catch (ExcepcionOrdenInvalido e){

	    }
	}
	
	@Test
	public void getOutPutFileDeberiaDevolverSalidapuntotxt(){
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--output-file=salida.txt", "--sort=yerba"};
		String valorEsperado = "salida.txt";
		
		String valorActual = obtenedor.getOutputFile(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void siIndicoOutPutFileIgualYerbaDeberiaDevolverExcepcionOutPutFileInvalido(){
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String[] cadena = {"360", "--format=pretty", "--output-file=yerba", "--sort=asc"};
		
		try{
	       	obtenedor.getOutputFile(cadena);
	    }catch (ExcepcionOutPutFileInvalido e){

	    }
	}
	
	@Test
	public void siNoSeIndicaOutPutFileDeberiaDevolverNull(){
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String[] cadena = {"360", "--format=yerba", "--sort=yerba"};
		String valorEsperado = null;
		
		String valorActual = obtenedor.getOutputFile(cadena);
		
		assertEquals(valorEsperado,valorActual);
	}
	
	@Test
	public void getNumeroDeberiaDevolver360(){
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String cadena = "360";
		int valorEsperado = 360;
		
		int valorActual = obtenedor.getNumero(cadena);
		
		assertEquals(valorEsperado, valorActual);
	}
	
	@Test
	public void getNumeroDeKkDeberiaDevolverExcepcionNumeroInvalido() throws ExcepcionNumeroInvalido{
		ObtencionDeArgumentos obtenedor = new ObtencionDeArgumentos();
		String cadena = "kk";
		
		try{
	       	obtenedor.getNumero(cadena);
	    }catch (ExcepcionNumeroInvalido e){

	    }
	}
	
}
