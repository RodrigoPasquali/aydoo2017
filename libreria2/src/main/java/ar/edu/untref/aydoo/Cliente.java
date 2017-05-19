package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

//Tipo de objeto: Entitie
public class Cliente {
	
	private String nombre;
	private String direccion;
	private int telefono;
	List<Compra> listaDeCompras;

	public Cliente(String nombre, String direccion, int telefono){
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.listaDeCompras = new LinkedList<Compra>();
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

	
	public void comprar(Compra compra){
		this.listaDeCompras.add(compra);
	}
	
	public List<Compra> obtenerListaDeCompras(){
		return this.listaDeCompras;
	}
	
}
