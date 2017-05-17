package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JuntaElectoralTest {
	JuntaElectoral junta;
	Provincia provinciaX;
	Provincia provinciaY;
	Provincia provinciaZ;
	Partido partidoX;
	Partido partidoZ;
	Candidato cadidatoX;
	Candidato cadidatoY;
	Candidato cadidatoZ;
	Voto voto1;
	Voto voto2;
	Voto voto3;
	
	@Before
	public void inicializar(){
		junta = new JuntaElectoral();
		provinciaX = new Provincia("PrX");
		provinciaY = new Provincia("PrY");
		provinciaZ = new Provincia("Prz");
		partidoX = new Partido("ParX");
		partidoZ = new Partido("ParZ");
		cadidatoX = new Candidato("canX");
		cadidatoY = new Candidato("canY");
		cadidatoZ = new Candidato("canZ");
		voto1 = new Voto(cadidatoX, partidoX, provinciaX);
		voto2 = new Voto(cadidatoY, partidoZ, provinciaY);
		voto3 = new Voto(cadidatoZ, partidoX, provinciaZ);
		junta.agregarVoto(voto3);
		junta.agregarVoto(voto2);
		junta.agregarVoto(voto1);
	}
	
	@Test
	public void cantidadDeVotosDeberiaSer3() {
		int valorEsperado = 3;
		int valorObtenido = junta.getCantidadDeVotos();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void deberiaDevolverLaListaDePronvinciasAgregadas() {
		junta.agregarProvincias();
		List<Provincia> listaEsperada = new LinkedList<Provincia>();
		listaEsperada.add(provinciaZ);
		listaEsperada.add(provinciaY);
		listaEsperada.add(provinciaX);
		
		List<Provincia> listaObtenida = junta.getPronvincias(); 
		
		Assert.assertEquals(listaEsperada, listaObtenida);
	}
	
	@Test
	public void deberiaDevolverListaDePartidosAgregados() {
		junta.agregarPartidos();
		List<Partido> listaEsperada = new LinkedList<Partido>();
		listaEsperada.add(partidoX);
		listaEsperada.add(partidoZ);
		
		List<Partido> listaObtenida = junta.getPartidos(); 

		Assert.assertEquals(listaEsperada, listaObtenida);
	}
	
	@Test
	public void deberiaDevolverListaCandidatosAgregados() {
		junta.agregarCandidatos();
		List<Candidato> listaEsperada = new LinkedList<Candidato>();
		listaEsperada.add(cadidatoZ);
		listaEsperada.add(cadidatoY);
		listaEsperada.add(cadidatoX);
		
		List<Candidato> listaObtenida = junta.getCandidatos(); 

		Assert.assertEquals(listaEsperada, listaObtenida);
	}
}
