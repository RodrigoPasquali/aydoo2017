package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class MesAgosto extends Mes{	
	private String mes = "agosto";
	private List<Compra> listaDeCompra;

	public MesAgosto(String nombre){
		super(nombre);
		this.listaDeCompra = new LinkedList<Compra>();
	}
	
	@Override
	public void agregarCompra(String nombreMes, Compra compra) {
		if(this.mes == nombreMes) {
			this.listaDeCompra.add(compra);
		} else {
			this.mesSiguiente.agregarCompra(nombreMes, compra);
		}
	}

	@Override
	public String getNombreMes() {
		return this.mes;
	}
}