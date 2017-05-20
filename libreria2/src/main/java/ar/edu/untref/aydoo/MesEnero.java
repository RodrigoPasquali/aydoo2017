package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;

public class MesEnero extends Mes{
	private String mes = "enero";
	private List<Compra> listaDeCompraEnero;
	private MesAgosto mesAgosto;
	
	public MesEnero(String nombre){
		super(nombre);
		this.listaDeCompraEnero = new LinkedList<Compra>();
		this.mesAgosto = new MesAgosto(this.getNombreMes());
	}
	
	@Override
	public void inicializarListaDeComprasDeMes(String nombreMes) {
		setMesSiguiente(this.mesAgosto);
		if(this.mes == nombreMes) {
			System.out.println("Enero inicializado");
		} else {
			getMesSiguiente().inicializarListaDeComprasDeMes(nombreMes);
		}
	}

	@Override
	public void agregarCompra(Compra compra) {
		this.listaDeCompraEnero.add(compra);
	}

	@Override
	public List<Compra> getListaDeCompras() {
		return this.listaDeCompraEnero;
	}

}
