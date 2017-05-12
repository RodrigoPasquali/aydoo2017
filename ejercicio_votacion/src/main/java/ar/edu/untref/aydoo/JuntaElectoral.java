package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class JuntaElectoral {
	private List<Voto> votos = new LinkedList<Voto>();
	private Candidato candidatoNacional;
	
	public void agregarVoto(Voto voto) {
		this.votos.add(voto);
	}
	
	public Candidato obtenerCandidatoConMasVotosNacional() {
		return this.candidatoNacional;
	}
	
	public void calcularCandidatoConMasVotosNacional() {
		this.candidatoNacional = this.votos.get(0).getCandidato();
		for(int i = 1; i < this.votos.size(); i++) {
			
		}
	}

}
