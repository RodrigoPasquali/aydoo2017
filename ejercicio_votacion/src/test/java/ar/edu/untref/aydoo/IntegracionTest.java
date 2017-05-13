package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
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
		Provincia buenosAires = new Provincia("Buenos Aires");
		Provincia salta = new Provincia("Salta");
		Provincia jujuy = new Provincia("Jujuy");
		JuntaElectoral junta = new JuntaElectoral();
		
	}
}
