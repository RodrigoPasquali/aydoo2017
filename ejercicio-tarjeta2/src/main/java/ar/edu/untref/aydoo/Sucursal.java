package ar.edu.untref.aydoo;

import java.util.List;

public class Sucursal {
	
	private String nombreSucursal;
	private Establecimiento establecimientoAlQuePertenece;
	private int cantidadDeClienteAtendidos;

	public Sucursal(String nombre) {
		this.nombreSucursal = nombre;
		this.cantidadDeClienteAtendidos = 0;
	}
	
	public void esUnaSucursalDe(Establecimiento estableciemiento) {
		this.establecimientoAlQuePertenece = estableciemiento;
	}
	
	public Establecimiento getEstablecimientoAlQuePertenece() {
		return this.establecimientoAlQuePertenece;
	}
	
	public void sumarClienteAtendido() {
		this.cantidadDeClienteAtendidos = this.cantidadDeClienteAtendidos++;
		this.establecimientoAlQuePertenece.sumarBeneficoOtorgado();
	}

}
