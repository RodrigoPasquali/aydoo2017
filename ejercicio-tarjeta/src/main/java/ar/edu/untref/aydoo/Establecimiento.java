package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nicopaez on 4/12/17.
 */
public class Establecimiento {
    private final String nombre;
    //private DescuentoParaTarjetaPremium descuentoPremium;
    private DescuentoParaTarjetaPremium descuentoTarjetaPremium;
    private DescuentoParaTarjetaClassic	descuentoTartetaClassic;
	private List<Sucursal> listaSucursales = new LinkedList<Sucursal>();
	private Tarjeta tarjetaClassic;
	private Tarjeta tarjetaPremium;

    public Establecimiento(String nombre) {
        this.nombre = nombre;
    }

    public void setDescuentoPremium(DescuentoParaTarjetaPremium descuento){
        this.descuentoTarjetaPremium = descuento;
    }

    public DescuentoParaTarjetaPremium getDescuentoPremium(){
        return descuentoTarjetaPremium;
    }
    
    public void setDescuentoClassic(DescuentoParaTarjetaClassic descuento){
    	this.descuentoTartetaClassic = descuento;
    }
    
    public DescuentoParaTarjetaClassic getDescuentoParaTarjetaClassic(){
    	return descuentoTartetaClassic;
    }
     
    public String getNombre() {
        return nombre;
    }
    
    public void agregarSucursales(Sucursal sucursal){
    	this.listaSucursales.add(sucursal);
    }
    
    public List<Sucursal> obtenerListaDeSucursales(){
    	return this.listaSucursales;
    }

}
