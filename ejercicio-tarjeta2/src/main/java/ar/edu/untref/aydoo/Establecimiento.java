package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Establecimiento {
	
	private String nombreEstablecimiento;
	private List<Sucursal> listaDeSucursales;
	private List<Beneficio> listaDeBeneficios;
	private int cantidadBeneficioOtorgado;
	
	public Establecimiento(String nombre) {
		this.nombreEstablecimiento = nombre;
		this.listaDeSucursales = new LinkedList<Sucursal>();
		this.listaDeBeneficios = new LinkedList<Beneficio>();
		this.cantidadBeneficioOtorgado = 0;
	}
	
	public void agregarSucursal(Sucursal sucursal) {
		this.listaDeSucursales.add(sucursal);
	}
	
	public void agregarBeneficio(Beneficio beneficio) { 
		this.listaDeBeneficios.add(beneficio);
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
	
	public void sumarBeneficoOtorgado() {
		this.cantidadBeneficioOtorgado = this.cantidadBeneficioOtorgado++;
	}
	
	public int getBeneficioOtorgados() {
		return this.cantidadBeneficioOtorgado;
	}
	
}
