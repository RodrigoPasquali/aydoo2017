package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Sucursal {
	
	private String nombreSucursal;
	private Establecimiento establecimientoAlQuePertenece;
	private List<Compra> listaDeVentas;

	public Sucursal(String nombre) {
		this.nombreSucursal = nombre;
		this.listaDeVentas = new LinkedList<Compra>();
	}
	
	public void esUnaSucursalDe(Establecimiento estableciemiento) {
		this.establecimientoAlQuePertenece = estableciemiento;
	}
	
	public Establecimiento getEstablecimientoAlQuePertenece() {
		return this.establecimientoAlQuePertenece;
	}
	
	public void agregarVenta(Compra compra) {
		this.listaDeVentas.add(compra);
	}
	
	public List<Compra> getListaDeVentas() {
		return this.listaDeVentas;
	}
	
	public int getCantidadDeVentasEnMes(Mes mes) {
		int ventasEnElMes = 0;
		for(int i = 0; i < getListaDeVentas().size(); i++) {
			Mes mesActual = getListaDeVentas().get(i).getMes();
			if(mes.equals(mesActual)){
			//if(mes == mesActual){
				ventasEnElMes++;
			}
		}
		return ventasEnElMes;
	}

}
