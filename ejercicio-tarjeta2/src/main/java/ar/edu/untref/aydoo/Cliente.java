package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import javax.management.monitor.MonitorNotification;

import Excepciones.ExpcepcionUnaSolaTarjeta;

public class Cliente {

	private String mailCliente;
	private String nombreCliente;
	private Tarjeta tarjetaCliente;
	private List<Compra> listaDeCompra;

	public Cliente(String nombre, String mail) {
		this.nombreCliente = nombre;
		this.mailCliente = mail;
		this.listaDeCompra = new LinkedList<Compra>();
		this.tarjetaCliente = null;
	}
	
	public void setTarjeta(Tarjeta tarjeta) {
		if(this.tarjetaCliente == null) {
			this.tarjetaCliente = tarjeta;
		} else {
			throw new ExpcepcionUnaSolaTarjeta();
		}
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
	
	public double getMontoGastadoEnMes(Mes mes) { 
		double montoGastado = 0;
		for(int i = 0; i < getListaDeCompras().size(); i++) {
			Mes mesActual = getListaDeCompras().get(i).getMes();
			if(mes.equals(mesActual)) {
				montoGastado = getListaDeCompras().get(i).getPrecioProductosConBeneficio();
			}
		}
		return montoGastado;
	}
	
	public double getDescuentosObtenidosEnMes(Mes mes) {
		double montoAhorradoTotal = 0;
		for(int i = 0; i < getListaDeCompras().size(); i++) {
			Compra compraActual = getListaDeCompras().get(i);
			if(compraActual.getMes().equals(mes)) {
				double montoAhorradoActual =  compraActual.getPrecioProductosSinBeneficio() - compraActual.getPrecioProductosConBeneficio();
				montoAhorradoTotal = montoAhorradoTotal + montoAhorradoActual;
			}	
		}
		return montoAhorradoTotal;
	}
	
}
