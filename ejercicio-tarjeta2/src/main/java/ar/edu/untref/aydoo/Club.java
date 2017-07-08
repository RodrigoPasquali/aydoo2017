package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Club {
	
	private LinkedList<Cliente> listaClientes;
	private LinkedList<Establecimiento> listaEstablecimiento;

	public Club() {
		this.listaEstablecimiento = new LinkedList<Establecimiento>();
		this.listaClientes = new LinkedList<Cliente>();
	}
	
	public void agregarEstablecimiento(Establecimiento establciemiento) {
		this.listaEstablecimiento.add(establciemiento);
	}
	
	public void agregarCliente(Cliente cliente) {
		this.listaClientes.add(cliente);
	}

}
