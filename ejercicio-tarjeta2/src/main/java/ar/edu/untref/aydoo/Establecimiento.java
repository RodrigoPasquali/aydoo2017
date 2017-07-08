package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

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
	
}
