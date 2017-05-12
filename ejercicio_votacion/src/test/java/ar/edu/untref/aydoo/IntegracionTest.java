package ar.edu.untref.aydoo;

import org.junit.Test;

public class IntegracionTest {

	@Test
	public void candidatoGanadorDeberiaSerJuan(){
		Candidato candidatoJuan = new Candidato("Juan");
		Candidato candidatoJose = new Candidato("Jose");
		Candidato candidatoMauro = new Candidato("Mauro");
		Candidato candidatoMartin = new Candidato("Martin");
		Partido partidoJ = new Partido("J");
		Partido partidoM = new Partido("M");
		partidoJ.agregarCandidato(candidatoJose);
		partidoJ.agregarCandidato(candidatoJuan);
		partidoM.agregarCandidato(candidatoMartin);
		partidoM.agregarCandidato(candidatoMauro);
		Provincia BuenosAires = new Provincia("Buenos Aires");
		Provincia Salta = new Provincia("Salta");
		Provincia Jujuy = new Provincia("Jujuy");
		JuntaElectoral junta = new JuntaElectoral();
		
	}
}
