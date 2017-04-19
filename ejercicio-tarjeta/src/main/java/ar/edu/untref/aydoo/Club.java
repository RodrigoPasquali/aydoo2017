package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Club {

	List<Establecimiento> listaDeEstablecimientos = new LinkedList<Establecimiento>();
	
	public void agregarEstablecimientos(Establecimiento establecimiento){
		this.listaDeEstablecimientos.add(establecimiento);
	}
	
	public List<Establecimiento> getListaDeEstablecimientos(){
		return this.listaDeEstablecimientos;
	}
	
}
