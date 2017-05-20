package ar.edu.untref.aydoo;

//Tipo de objeto: Entitie
import java.util.LinkedList;
import java.util.List;

import javax.management.modelmbean.ModelMBeanNotificationBroadcaster;

import gherkin.formatter.MonochromeFormats;

public class Libreria {
	List<Cliente> listaClientes = new LinkedList<Cliente>();
	List<Producto> listaProductos = new LinkedList<Producto>();
	
	public double calcularMontoACobrar(Mes mes, Cliente cliente){
		double montoTotalDelMes = 0;
		List<Compra> comprasDelMes = cliente.obtenerComprasDeMes(mes);
		for(int i = 0; i < comprasDelMes.size(); i++){
			montoTotalDelMes = comprasDelMes.get(i).calcularPrecioCompra() + montoTotalDelMes;
		}
		return montoTotalDelMes;
	}
	
	public void agregarCliente(Cliente cliente){
		this.listaClientes.add(cliente);
	}
	
	public List<Cliente> obtenerListaClientes(){
		return this.listaClientes;
	}
	
}
