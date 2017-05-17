package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {	
	Candidato candidatoJuan;
	Candidato candidatoJose;
	Partido partidoJ;
	Candidato candidatoMartin;
	Candidato candidatoMauro;
	Partido partidoM;
	JuntaElectoral junta;
	Provincia buenosAires;
	Provincia jujuy;
	Provincia salta;
	
	@Before
	public void inicializar() {
		candidatoJuan = new Candidato("Juan");
		candidatoJose = new Candidato("Jose");
		candidatoMartin = new Candidato("Martin");
		candidatoMauro = new Candidato("Mauro");
		partidoJ = new Partido("J");
		partidoJ.agregarCandidato(candidatoJuan);
		partidoJ.agregarCandidato(candidatoJose);
		partidoM = new Partido("M");
		partidoM.agregarCandidato(candidatoMartin);
		partidoM.agregarCandidato(candidatoMauro);
		junta = new JuntaElectoral();
		junta.agregarCandidatos();
		/*
		junta.agregarPartido(partidoJ);
		junta.agregarPartido(partidoM);
		*/
		buenosAires = new Provincia("Buenos Aires");
		jujuy = new Provincia("Jujuy");
		salta = new Provincia("Salta");
		buenosAires.agregarPartido(partidoJ);
		buenosAires.agregarPartido(partidoM);
		jujuy.agregarPartido(partidoJ);
		jujuy.agregarPartido(partidoM);
		salta.agregarPartido(partidoJ);
		salta.agregarPartido(partidoM);
		junta.agregarProvincia(buenosAires);
		junta.agregarProvincia(jujuy);
		junta.agregarProvincia(salta);
		Voto voto1 = new Voto(candidatoJuan, partidoJ, buenosAires);
		Voto voto2 = new Voto(candidatoJuan, partidoJ, buenosAires);
		Voto voto3 = new Voto(candidatoJuan, partidoJ, buenosAires);
		Voto voto4 = new Voto(candidatoJuan, partidoJ, buenosAires);
		Voto voto5 = new Voto(candidatoJuan, partidoJ, buenosAires);
		Voto voto6 = new Voto(candidatoJuan, partidoJ, buenosAires);
		Voto voto7 = new Voto(candidatoJose, partidoJ, jujuy);
		Voto voto8 = new Voto(candidatoJose, partidoJ, jujuy);
		Voto voto9 = new Voto(candidatoJose, partidoJ, jujuy);
		Voto voto10 = new Voto(candidatoJose, partidoJ, jujuy);
		Voto voto11 = new Voto(candidatoMartin, partidoM, jujuy);
		Voto voto12 = new Voto(candidatoMartin, partidoM, jujuy);
		Voto voto13 = new Voto(candidatoMartin, partidoM, jujuy);
		Voto voto14 = new Voto(candidatoMartin, partidoM, jujuy);
		Voto voto15 = new Voto(candidatoMartin, partidoM, jujuy);
		Voto voto16 = new Voto(candidatoMartin, partidoM, jujuy);
		Voto voto17 = new Voto(candidatoMartin, partidoM, jujuy);
		Voto voto18 = new Voto(candidatoMauro, partidoJ, buenosAires);
		Voto voto19 = new Voto(candidatoJuan, partidoJ, salta);
		Voto voto20 = new Voto(candidatoJuan, partidoJ, salta);
		Voto voto21 = new Voto(candidatoJuan, partidoJ, salta);
		Voto voto22 = new Voto(candidatoJuan, partidoJ, salta);
		Voto voto23 = new Voto(candidatoJuan, partidoJ, salta);
		Voto voto24 = new Voto(candidatoMauro, partidoM, salta);
		Voto voto25 = new Voto(candidatoMauro, partidoM, salta);
		junta.agregarVoto(voto1);
		junta.agregarVoto(voto2);
		junta.agregarVoto(voto3);
		junta.agregarVoto(voto4);
		junta.agregarVoto(voto5);
		junta.agregarVoto(voto6);
		junta.agregarVoto(voto7);
		junta.agregarVoto(voto8);
		junta.agregarVoto(voto9);
		junta.agregarVoto(voto10);
		junta.agregarVoto(voto11);
		junta.agregarVoto(voto12);
		junta.agregarVoto(voto13);
		junta.agregarVoto(voto14);
		junta.agregarVoto(voto15);
		junta.agregarVoto(voto16);
		junta.agregarVoto(voto17);
		junta.agregarVoto(voto18);
		junta.agregarVoto(voto19);
		junta.agregarVoto(voto20);
		junta.agregarVoto(voto21);
		junta.agregarVoto(voto22);
		junta.agregarVoto(voto23);
		junta.agregarVoto(voto24);
		junta.agregarVoto(voto25);
	}
	
	@Test
	public void cantidadDeVotosDeberiaSer25() {
		int valorEsperado = 25;
		int valorObtenido = junta.getCantidadDeVotos();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
		
	@Test
	public void candidatoMartinDeberiaTener7Votos() {
		int valorEsperado = 7;
		
		int valorObtenido = junta.contarVotosCandidato(candidatoMartin);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void juanDeberiaSerCandidatoGanadorNacional() {
		Candidato valorEsperado = candidatoJuan;
		
		Candidato valorObtenido = junta.candidatoGanadorNacional();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void partidoJenJujuyDeberiaTener4Votos() {
		int valorEsperado = 4;
		
		int valorObtenido = junta.contarVotosPartidoEnProvincia(jujuy, partidoJ);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void partidoMenSaltaDeberiaTener2Votos() {
		int valorEsperado = 2;
		
		int valorObtenido = junta.contarVotosPartidoEnProvincia(salta, partidoM);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void partidoJenSaltaDeberiaTener5Votos() {
		int valorEsperado = 5;
		
		int valorObtenido = junta.contarVotosPartidoEnProvincia(salta, partidoJ);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void partidoJDeberiaGanarEnSalta() {
		Partido valorEsperado = partidoJ;
		
		Partido valorObtenido = junta.partidoGanadorEnProvincia(salta);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void partidoMDeberiaGanarEnJujuy() {
		Partido valorEsperado = partidoM;
		
		Partido valorObtenido = junta.partidoGanadorEnProvincia(jujuy);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void partidoJDeberiaGanarEnBuenosAires() {
		Partido valorEsperado = partidoJ;
		
		Partido valorObtenido = junta.partidoGanadorEnProvincia(buenosAires);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
}
