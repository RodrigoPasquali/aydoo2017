package ar.edu.untref.aydoo;

/**
 * Created by nicopaez on 4/12/17.
 */
public class Sucursal {
    private final String nombre;
    private int cantidadBeneficiosOtorgados;
    private Establecimiento establecimiento;
	private Regalo regaloObtenido;

    public Sucursal(String nombre, Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getCantidadBeneficiosOtorgados() {
        return cantidadBeneficiosOtorgados;
    }

    /*
    public double aplicarDescuento(int valorBruto, Tarjeta tarjeta) {
        DescuentoParaTarjetaPremium descuento = establecimiento.getDescuentoPremium();
        return  descuento.aplicarDescuento(valorBruto);
    }
    */

    public void registrarCompra() {
        cantidadBeneficiosOtorgados++;
    }

	public void setRegalo(Regalo regalo) {
		this.regaloObtenido = regalo;
	}
	
	public Regalo getRegalo(){
		return this.regaloObtenido;
	}
}
