package ar.edu.untref.aydoo;

public class Partido {
	
	int votos = 0;
	String nombre;
	
	public Partido(String nombre){
		this.nombre = nombre;
	}
	
	public void sumarVoto(){
		this.votos++;
	}
	
	public int getVotos(){
		System.out.println("Cantidad de Votos de partido : " + this.nombre + " " + this.votos);
		return this.votos;
	}
	
	public String getNombre(){
		return this.nombre;
	}

}
