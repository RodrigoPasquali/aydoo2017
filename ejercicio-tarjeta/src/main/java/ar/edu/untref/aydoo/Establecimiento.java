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
	private Sucursal sucursalConMasBeneficiosOtorgados;
	private int beneficiosOtorgados;
	private MailDeFelicitaciones mailDeFelicitaciones;

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
    
    public List<Sucursal> getListaDeSucursales(){
    	return this.listaSucursales;
    }
    
    public Sucursal getSucursalQueOtorgoMasBeneficios(){
    	this.sucursalConMasBeneficiosOtorgados = this.listaSucursales.get(0);
    	for (int i = 1; i < this.listaSucursales.size(); i++){
    		if(this.sucursalConMasBeneficiosOtorgados.getCantidadBeneficiosOtorgados() < this.listaSucursales.get(i).getCantidadBeneficiosOtorgados()){
    			this.sucursalConMasBeneficiosOtorgados = this.listaSucursales.get(i);
    		}
    	}
    	return this.sucursalConMasBeneficiosOtorgados;
    }
    
    public int getCantidadDeBeneficiosOtorgados(){
    	this.beneficiosOtorgados = 0;
    	for(int i = 0; i < this.listaSucursales.size(); i++){
    		this.beneficiosOtorgados = this.listaSucursales.get(i).getCantidadBeneficiosOtorgados() + this.beneficiosOtorgados;
    	}
    	return this.beneficiosOtorgados;
    }
    
    public void setMailDeFelicitaciones(MailDeFelicitaciones mail){
    	this.mailDeFelicitaciones = mail;
    }
    
    public MailDeFelicitaciones getMailDeFelicitacion(){
    	return this.mailDeFelicitaciones;
    }

}
