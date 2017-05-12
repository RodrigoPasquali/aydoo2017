package ar.edu.untref.aydoo;

public class Voto {
	
	private Provincia provincia;
	private Candidato candidato;
	private Partido partido;
	
	public Voto(Candidato candidato, Partido partido, Provincia provincia){
		this.partido = partido;
		this.candidato = candidato;
		this.provincia = provincia;
	}
	
	public Provincia getProvincia(){
		return this.provincia;
	}
	
	public Partido getPartido(){
		return this.partido;
	}
	
	public Candidato getCandidato(){
		return this.candidato;
	}

}
