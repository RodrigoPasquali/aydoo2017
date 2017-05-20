package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public abstract class Mes {
	public Mes mesSiguiente;
	private String nombreMes;
	
	public Mes(String nombre){
		this.nombreMes = nombre.toLowerCase();
	}
	
	public Mes getMesSiguiente() {
		return mesSiguiente;
	}

	public void setMesSiguiente(Mes mesSiguiente) {
		this.mesSiguiente = mesSiguiente;
	}
	
	public String getNombreMes(){
		return this.nombreMes;
	}

	public abstract void agregarCompra(String nombreMes, Compra compra);
}
