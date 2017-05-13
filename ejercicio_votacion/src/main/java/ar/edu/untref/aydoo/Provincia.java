package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Provincia {
	String nombre;
	int votos = 0;
	List<Partido> listaDePartidos = new LinkedList<Partido>();
	
	public Provincia(String provincia) {
		this.nombre = provincia;
	}
	
	public void sumarVoto() {
		this.votos++;
	}
	
	public int getVotos() {
		System.out.println("Cantidad de votos de Provincia : " + this.nombre + " " +this.votos);
		return this.votos;
	}	
	
	public void sumarVotoAPartido(Partido partido) {
		int i = 0;
		while(!this.listaDePartidos.equals(partido)) {
			i++;
		}
		this.listaDePartidos.get(i).sumarVoto();
	}
	
	public List<Partido> getListaDePartidos(){
		return this.listaDePartidos;
	}
}
