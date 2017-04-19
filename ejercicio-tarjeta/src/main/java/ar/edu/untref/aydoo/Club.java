package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Club {

	List<Establecimiento> listaDeEstablecimientos = new LinkedList<Establecimiento>();
	Establecimiento establecimientoConMasBeneficios;
	
	public void agregarEstablecimientos(Establecimiento establecimiento){
		this.listaDeEstablecimientos.add(establecimiento);
	}
	
	public List<Establecimiento> getListaDeEstablecimientos(){
		return this.listaDeEstablecimientos;
	}
	
	public Establecimiento getEstablecimientoQueOtorgoMasBeneficios(){
		this.establecimientoConMasBeneficios = this.listaDeEstablecimientos.get(0);
		for(int i=1; i < this.listaDeEstablecimientos.size(); i++){
			if(this.establecimientoConMasBeneficios.getCantidadDeBeneficiosOtorgados() < this.listaDeEstablecimientos.get(i).getCantidadDeBeneficiosOtorgados()){
				this.establecimientoConMasBeneficios = this.listaDeEstablecimientos.get(i);
			}
		}
		return this.establecimientoConMasBeneficios;
	}
	
}
