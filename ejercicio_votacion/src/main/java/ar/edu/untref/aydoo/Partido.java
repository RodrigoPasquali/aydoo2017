package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Partido {
	private int votos = 0;
	private String nombre;
	private List<Candidato> listaDeCandidatos = new LinkedList<Candidato>();
	
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
	
	public void agregarCandidato(Candidato candidato){
		this.listaDeCandidatos.add(candidato);
	}
	
	public List<Candidato> getListaCandidato(){
		return this.listaDeCandidatos;
	}

}
