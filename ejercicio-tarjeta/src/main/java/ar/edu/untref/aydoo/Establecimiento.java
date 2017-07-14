package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Establecimiento {
	
	private String nombreEstablecimiento;
	private List<Sucursal> listaDeSucursales;
	private List<Beneficio> listaDeBeneficios;
	
	public Establecimiento(String nombre) {
		this.nombreEstablecimiento = nombre;
		this.listaDeSucursales = new LinkedList<Sucursal>();
		this.listaDeBeneficios = new LinkedList<Beneficio>();
	}
	
	public String getNombre() {
		return this.nombreEstablecimiento;
	}
	
	public void agregarSucursal(Sucursal sucursal) {
		this.listaDeSucursales.add(sucursal);
	}
	
	public void agregarBeneficio(Beneficio beneficio) { 
		this.listaDeBeneficios.add(beneficio);
	}
	
	public List<Sucursal> getSucursales() {
		return this.listaDeSucursales;
	}
	
	public List<Beneficio> getBeneficiosParaTarjeta(Tarjeta tarjeta) {
		List<Beneficio> listaDeBeneficiosConTarjetaSeleccionada = new LinkedList<Beneficio>();
		int i = 0;
		int j = 0;
		while(i < this.listaDeBeneficios.size()) {
			Beneficio beneficioActual = this.listaDeBeneficios.get(i);
			if(tarjeta.equals(beneficioActual.getTarjeta())) {
				listaDeBeneficiosConTarjetaSeleccionada.add(j, beneficioActual);
				j++;
			}
			i++;
		}
		return listaDeBeneficiosConTarjetaSeleccionada;
	}
	
	public int getCantidadBeneficioOtorgadosEnMes(Mes mes) {
		int cantidadBeneficios = 0;
		for(int i = 0; i < getSucursales().size(); i++) {
			Sucursal sucursalActual = getSucursales().get(i);
			cantidadBeneficios = cantidadBeneficios + sucursalActual.getCantidadDeVentasEnMes(mes);
		}
		return cantidadBeneficios;
	}
	
	public Sucursal getSucursalQueAtendioMasClientesEnMes(Mes mes) {
		Sucursal sucursalQueMasAtendio = getSucursales().get(0);
		for(int i = 1; i < getSucursales().size(); i++) {
			Sucursal sucursalActual = getSucursales().get(i);
			if(sucursalQueMasAtendio.getCantidadDeVentasEnMes(mes) < sucursalActual.getCantidadDeVentasEnMes(mes)) {
				sucursalQueMasAtendio = sucursalActual;
			}
		}
		return sucursalQueMasAtendio;
	}
	
}
