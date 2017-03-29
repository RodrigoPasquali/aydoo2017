package ar.edu.untref.aydoo;

public class Voto {
	
	String provincia;
	String candidato;
	String partido;
	
	public Voto(String candidato, String partido, String provincia){
		this.partido = partido;
		this.candidato = candidato;
		this.provincia = provincia;
	}
	
	public String getProvincia(){
		return this.provincia;
	}
	
	public String getPartido(){
		return this.partido;
	}
	
	public String getCandidato(){
		return this.candidato;
	}

}
