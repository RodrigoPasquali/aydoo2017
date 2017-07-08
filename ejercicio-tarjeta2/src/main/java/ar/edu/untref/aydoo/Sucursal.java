package ar.edu.untref.aydoo;

import java.util.List;

public class Sucursal {
	
	private String nombreSucursal;
	private Establecimiento establecimientoAlQuePertenece;

	public Sucursal(String nombre){
		this.nombreSucursal = nombre;
	}
	
	public void esUnaSucursalDe(Establecimiento estableciemiento){
		this.establecimientoAlQuePertenece = estableciemiento;
	}
	
	public Establecimiento getEstablecimientoAlQuePertenece(){
		return this.establecimientoAlQuePertenece;
	}

}
