package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class MesAgosto extends Mes{	
	private String mesAgosto = "agosto";
	private List<Compra> listaDeCompraAgosto;

	public MesAgosto(String nombre){
		super(nombre);
		this.listaDeCompraAgosto = new LinkedList<Compra>();
	}
	
	@Override
	public void inicializarListaDeComprasDeMes(String nombreMes) {
		if(this.mesAgosto == nombreMes) {
			System.out.println("Agosto Inicializado");
		} else {
			//Tirar Excpecion
			System.out.println("Ingrese mes valido");
		}
	}

	@Override
	public void agregarCompra(Compra compra) {
		this.listaDeCompraAgosto.add(compra);
	}

	@Override
	public String getNombreMes() {
		return this.mesAgosto;
	}

	@Override
	public List<Compra> getListaDeCompras() {
		return this.listaDeCompraAgosto;
	}

	
}