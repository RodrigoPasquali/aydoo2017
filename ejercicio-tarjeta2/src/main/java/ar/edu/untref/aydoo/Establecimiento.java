package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Establecimiento {
	
	private String nombreEstablecimiento;
	private List<Sucursal> listaDeSucursales;
	private List<Beneficio> listaDeBeneficios;
	
	public Establecimiento(String nombre){
		this.nombreEstablecimiento = nombre;
		this.listaDeSucursales = new LinkedList<Sucursal>();
		this.listaDeBeneficios = new LinkedList<Beneficio>();
	}
	
	public void agregarSucursal(Sucursal sucursal){
		this.listaDeSucursales.add(sucursal);
	}
	
	public void agregarBeneficio(Beneficio beneficio){
		this.listaDeBeneficios.add(beneficio);
	}
	
	public List<Beneficio> getBeneficiosParaTarjeta(Tarjeta tarjeta){
		List<Beneficio> listaDeBeneficiosConTarjetaSeleccionada = new LinkedList<Beneficio>();
		int i = 0;
		while(i < this.listaDeBeneficios.size()) {
			Beneficio beneficioActual = this.listaDeBeneficios.get(i);
			if(tarjeta.equals(beneficioActual.getTarjeta())) {
				listaDeBeneficiosConTarjetaSeleccionada.add(beneficioActual);
			}
			i++;
		}
		return listaDeBeneficiosConTarjetaSeleccionada;
	}
	
}
