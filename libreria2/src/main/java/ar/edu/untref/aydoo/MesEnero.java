package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;

public class MesEnero extends Mes{
	private String mes = "enero";
	private List<Compra> listaDeCompra;
	private MesAgosto mesAgosto;
	
	public MesEnero(String nombre){
		super(nombre);
		this.listaDeCompra = new LinkedList<Compra>();
		this.mesAgosto = new MesAgosto(this.getNombreMes());
	}

	@Override
	public void agregarCompra(String nombreMes, Compra compra) {
		this.setMesSiguiente(this.mesAgosto);
		if(this.mes == nombreMes) {
			this.listaDeCompra.add(compra);
		} else {
			this.mesSiguiente.agregarCompra(nombreMes, compra);
		}
	}
	

}
