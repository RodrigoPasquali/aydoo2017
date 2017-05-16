package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Partido {
	private String nombre;
	private List<Candidato> listaDeCandidatos = new LinkedList<Candidato>();
	
	public Partido(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarCandidato(Candidato candidato) {
		this.listaDeCandidatos.add(candidato);
	}
	
	public List<Candidato> getListaCandidato() {
		return this.listaDeCandidatos;
	}
}
