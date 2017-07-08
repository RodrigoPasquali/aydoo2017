package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Cliente {

	private String mailCliente;
	private String nombreCliente;
	private Tarjeta tarjetaCliente;
	private List<Compra> listaDeCompra;

	public Cliente(String nombre, String mail) {
		this.nombreCliente = nombre;
		this.mailCliente = mail;
		this.listaDeCompra = new LinkedList<Compra>();
	}
	
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjetaCliente = tarjeta;
	}
	
	public Tarjeta getTarjeta() {
		return this.tarjetaCliente;
	}
	
	public void registrarCompra(Compra compra) {
		this.listaDeCompra.add(compra);
	}
	
	public List<Compra> getListaDeCompras() {
		return this.listaDeCompra;
	}
}
