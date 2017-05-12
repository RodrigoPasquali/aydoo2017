package ar.edu.untref.aydoo;

public class Provincia {
	
	String nombre;
	int votos = 0;
	//int votosJ = 0;
	//int votosM = 0;
	//String partidoGanador;

	
	public Provincia(String provincia){
		this.nombre = provincia;
	}
	
	public void sumarVoto(){
		this.votos++;
	}
	
	public int getVotos(){
		System.out.println("Cantidad de votos de Provincia : " + this.nombre + " " +this.votos);
		return this.votos;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	/*
	public void sumarVotoAPartido(Partido partido){
		if(partido.getNombre() == "J"){
			this.votosJ++;
		}else if(partido.getNombre() == "M"){
			this.votosM++;
		}
	}
	*/
	
	/*
	public String partidoGanadorEnlaProvincia(){
		this.partidoGanador = "J";
		if(this.votosJ < this.votosM){
			this.partidoGanador = "M";
		}
		System.out.println("En la provincia de " + this.nombre + " es " + this.partidoGanador);
		return this.partidoGanador;
	}
	*/
}
