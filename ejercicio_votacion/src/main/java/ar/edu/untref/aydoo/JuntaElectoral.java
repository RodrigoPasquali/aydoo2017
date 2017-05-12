package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class JuntaElectoral {
	private List<Voto> votos = new LinkedList<Voto>();
	private List<Partido> listaDePartidos = new LinkedList<Partido>();
	private List<Candidato> listaDeCandidatos = new LinkedList<Candidato>();
	private List<Provincia> listaDeProvincias = new LinkedList<Provincia>();
	private Candidato candidatoNacional;
	
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
	
	public List<Partido> getPartidos(){
		return this.listaDePartidos;
	}
	
	public List<Candidato> getCandidatos(){
		return this.listaDeCandidatos;
	}
	public List<Provincia> getPronvincias(){
		return this.listaDeProvincias;
	}
	
	public void agregarProvincia(Provincia provincia) {
		this.listaDeProvincias.add(provincia);
	}
	
	public Candidato obtenerCandidatoConMasVotosNacional() {
		return this.candidatoNacional;
	}
	
	public void calcularCandidatoConMasVotosNacional() {
		this.candidatoNacional = this.votos.get(0).getCandidato();
		for(int i = 1; i < this.votos.size(); i++) {
			
		}
	}
	
	public void contarVotos(){
		for(int i = 0; i < this.votos.size(); i++){
			for(int c = 0; c < this.votos.size(); i++){
				
			}
		}
	}
	
	private void contarVotosDeCandidatos(){
		for(int c = 0; c < this.listaDeCandidatos.size(); c++){
			for(int v = 0; v < this.votos.size(); v++){
				if(this.listaDeCandidatos.get(c).equals(this.votos.get(v).getCandidato())){
					this.listaDeCandidatos.get(c).sumarVoto();
				}
			}
		}
			
	}

}
