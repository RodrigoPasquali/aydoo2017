package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

//Tipo de objeto: Entitie
public class Cliente {
	
	private String nombre;
	private String direccion;
	private int telefono;
	List<Compra> listaDeCompras;
	List<Mes> meses;

	public Cliente(String nombre, String direccion, int telefono){
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.listaDeCompras = new LinkedList<Compra>();
		this.meses = new LinkedList<Mes>();
	}

	public String obtenerNombre() {
		return nombre;
	}

	public void cambiarNombre(String nombre) {
		this.nombre = nombre;
	}

	public String obtenerDireccion() {
		return direccion;
	}

	public void cambiarDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int obtenerTelefono() {
		return telefono;
	}

	public void cambiarTelefono(int telefono) {
		this.telefono = telefono;
	}

	
	public void agregarCompra(Compra compra, Mes mes){
		//agregarMes(mes);
		for(int i = 0; i < this.meses.size(); i++){
			Mes mesActual = this.meses.get(i);
			if(mes.getNombreMes().equals(mesActual.getNombreMes())){
				this.meses.get(i).agregarCompra(mes.getNombreMes(), compra);
			}
		}
		mes.agregarCompra(mes.getNombreMes(), compra);
	}
	
	public void agregarMes(Mes mes){
		if(!this.meses.contains(mes)){
			this.meses.add(mes);
		}
	}
	
	public List<Mes> getMeses(){
		return this.meses;
	}
	
	public List<Compra> obtenerComprasDeMes(Mes mes){
		List<Compra> listaDeCompras = new LinkedList<Compra>();
		for(int i = 0; i < this.meses.size(); i++){
			Mes mesActual = this.meses.get(i);
			if(mes.equals(mesActual)){
				listaDeCompras = mesActual.getListaDeCompras();
			}
		}
		return listaDeCompras;
	}
	
	/*
	public List<Compra> obtenerListaDeComprasDeMes(Mes mes){
		for(int i = 0; i < this.l)
		return this.listaDeCompras;
	}
	*/
	
}
