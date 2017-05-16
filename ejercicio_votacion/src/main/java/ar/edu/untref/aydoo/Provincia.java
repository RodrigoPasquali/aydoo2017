package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Provincia {
	String nombre;
	List<Partido> listaDePartidos = new LinkedList<Partido>();
	
	public Provincia(String provincia) {
		this.nombre = provincia;
	}
	
	public List<Partido> getListaDePartidos() {
		return this.listaDePartidos;
	}
	
	public void agregarPartido(Partido partido) {
		this.listaDePartidos.add(partido);
	}
}
