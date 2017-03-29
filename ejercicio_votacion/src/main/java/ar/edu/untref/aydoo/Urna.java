package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Urna {
	
	List<Voto> listaVoto = new LinkedList<Voto>();
	
	public void ponerVoto(Voto voto){
		this.listaVoto.add(voto);
	}
	
	public List<Voto> getListaVotos(){
		return this.listaVoto;
	}

}
