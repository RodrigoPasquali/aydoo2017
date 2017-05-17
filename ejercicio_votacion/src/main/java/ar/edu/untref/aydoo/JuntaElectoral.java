package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class JuntaElectoral {
	private List<Voto> votos;
	private List<Partido> listaDePartidos;
	private List<Candidato> listaDeCandidatos;
	private List<Provincia> listaDeProvincias;
	
	public JuntaElectoral() {
		this.votos = new LinkedList<Voto>();
		this.listaDeCandidatos = new LinkedList<Candidato>();
		this.listaDePartidos = new LinkedList<Partido>();
		this.listaDeProvincias = new LinkedList<Provincia>();
	}
	
	public void agregarVoto(Voto voto) {
		this.votos.add(voto);
	}
	
	public int getCantidadDeVotos() {
		return this.votos.size();
	}
	
	public void agregarCandidatos(){
		Candidato candidatoAgregado;
		for(int i = 0; i < this.votos.size(); i++){
			candidatoAgregado = this.votos.get(i).getCandidato();
			if(!this.listaDeCandidatos.contains(candidatoAgregado)){
				this.listaDeCandidatos.add(candidatoAgregado);
			}
		}
	}
	
	public void agregarPartido(Partido partido) {
		this.listaDePartidos.add(partido);
	}
	
	public void agregarProvincia(Provincia provincia) {
		this.listaDeProvincias.add(provincia);
	}
	
	public List<Partido> getPartidos() {
		return this.listaDePartidos;
	}
	
	public List<Candidato> getCandidatos() {
		return this.listaDeCandidatos;
	}
	
	public List<Provincia> getPronvincias() {
		return this.listaDeProvincias;
	}
		
	public int contarVotosCandidato(Candidato candidato) {
		int cantidadVotos = 0;
		for(int i = 0; i < this.votos.size(); i++){
			Candidato candidatoActual = this.votos.get(i).getCandidato();
			if(candidatoActual.equals(candidato)) {
				cantidadVotos++;
			}
		}
		return cantidadVotos;
	}

	public Candidato candidatoGanadorNacional() {
		Candidato candidatoGanador = this.votos.get(0).getCandidato();
		int cantidadVotosCandidatoGanador = contarVotosCandidato(candidatoGanador);
		for(int i = 1; i < this.votos.size(); i++) {
			Candidato candidatoActual = this.votos.get(i).getCandidato();
			int cantidadVotosCandidatoActual = contarVotosCandidato(candidatoActual);
			if(cantidadVotosCandidatoGanador < cantidadVotosCandidatoActual) {
				candidatoGanador = candidatoActual;
			}
		}
		return candidatoGanador;
	}
	
	public int contarVotosPartidoEnProvincia(Provincia provincia, Partido partido) {
		int cantidadVotos = 0;
		Provincia provinciaActual;
		Partido partidoActual;
		for(int i = 0; i < this.votos.size(); i++) {
			provinciaActual = this.votos.get(i).getProvincia();
			partidoActual = this.votos.get(i).getPartido();
			if(provincia.equals(provinciaActual)  && partido.equals(partidoActual)) {
				cantidadVotos++;
			}
		}
		return cantidadVotos;
	}
	
	public Partido partidoGanadorEnProvincia(Provincia provincia) {
		Partido partidoGanador = provincia.getListaDePartidos().get(0);
		int votosPartidoGanador = contarVotosPartidoEnProvincia(provincia, partidoGanador);
		Partido partidoActual;
		int votosPartidoActual;
		for(int i = 1; i < provincia.getListaDePartidos().size(); i++) {
			partidoActual = provincia.getListaDePartidos().get(i);
			votosPartidoActual = contarVotosPartidoEnProvincia(provincia, partidoActual);
			if(votosPartidoGanador < votosPartidoActual) {
				partidoGanador = partidoActual;
			}
		}
		return partidoGanador;
	}	
}
