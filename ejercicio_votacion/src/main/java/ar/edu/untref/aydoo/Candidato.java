package ar.edu.untref.aydoo;

public class Candidato {
	
	String nombre;
	int votos = 0;

	public Candidato(String nombre){
		this.nombre = nombre;
	}
	
	public void sumarVoto(){
		this.votos++;
	}
		
	public int getVotos(){
		return this.votos;
	}
	
	public String getNombre(){
		return this.nombre;
	}

}
