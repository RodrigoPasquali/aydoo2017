package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JuntaElectoral {
	private List<Voto> votos;
	private List<Partido> listaDePartidos;
	private List<Candidato> listaDeCandidatos;
	private List<Provincia> listaDeProvincias;
	private Candidato candidatoNacional;
	private Partido partidoGanador;
	Map<Candidato, Integer> votosDeCandidatosNacional;
	
	public JuntaElectoral(){
		this.votos = new LinkedList<Voto>();
		this.listaDeCandidatos = new LinkedList<Candidato>();
		this.listaDePartidos = new LinkedList<Partido>();
		this.listaDeProvincias = new LinkedList<Provincia>();
		this.votosDeCandidatosNacional = new HashMap<>();
	}
	
	public void agregarVoto(Voto voto) {
		this.votos.add(voto);
	}
	
	public int getCantidadDeVotos(){
		return this.votos.size();
	}
	
	public void agregarPartido(Partido partido) {
		this.listaDePartidos.add(partido);
	}
	
	public void agregarCandidato(Candidato candidato) {
		this.listaDeCandidatos.add(candidato);
	}
	
	public void agregarProvincia(Provincia provincia) {
		this.listaDeProvincias.add(provincia);
	}
	
	public List<Partido> getPartidos(){
		return this.listaDePartidos;
	}
	
	public List<Candidato> getCandidatos(){
		return this.listaDeCandidatos;
	}
	public List<Provincia> getPronvincias(){
		return this.listaDeProvincias;
	}
	
	public void contarVotosDeCandidatos(){
		for(int v = 0; v < this.votos.size(); v++){
			this.votos.get(v).getCandidato().sumarVoto();
		}
	}
	
	public int getVotosDeCandidato(Candidato candidato){
		int i = 0;
		while(!this.votos.get(i).getCandidato().equals(candidato)){
			i++;
		}
		return this.votos.get(i).getCandidato().getVotos();
	}
	
	public Candidato getcandidatoGanadorNacional(){
		this.candidatoNacional = this.votos.get(0).getCandidato();
		for(int c = 0; c < this.votos.size(); c++){
			if(this.candidatoNacional.getVotos() < this.votos.get(c).getCandidato().getVotos()){
				this.candidatoNacional = this.votos.get(c).getCandidato();
			}
		}
		return this.candidatoNacional;
	}	
}
