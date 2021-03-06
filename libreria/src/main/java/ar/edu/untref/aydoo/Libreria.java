package ar.edu.untref.aydoo;

//Tipo de objeto: Entitie
import java.util.LinkedList;
import java.util.List;

public class Libreria {
	
	List<Cliente> listaClientes = new LinkedList<Cliente>();
	List<Producto> listaProductos = new LinkedList<Producto>();
	private double gastosTotalDelMes;
	
	public double calcularMontoACobrar(String mes, Cliente cliente){
		this.listaProductos = cliente.obtenerListaProductos();
		for(int i = 0; i<this.listaClientes.size(); i++){
			if(this.listaClientes.get(i).obtenerNombre()  == cliente.obtenerNombre()){
				for(int j = 0; j< this.listaProductos.size(); j++){
					if(this.listaProductos.get(j).obtenerMes() == mes){
						this.gastosTotalDelMes = this.listaProductos.get(j).obtenerPrecio()*this.listaProductos.get(j).obtenerCantidad() + this.gastosTotalDelMes;
					}
				}
			}
		}
		return this.gastosTotalDelMes;
	}
	
	public void agregarCliente(Cliente cliente){
		this.listaClientes.add(cliente);
	}
	
	public List<Cliente> obtenerListaClientes(){
		return this.listaClientes;
	}
	
}
