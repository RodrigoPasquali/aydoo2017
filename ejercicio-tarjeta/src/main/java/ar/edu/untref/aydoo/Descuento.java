package ar.edu.untref.aydoo;

public class Descuento extends Beneficio {

	private int porcentajeDescuento;
	final Integer NUMERO_CIEN = 100;

	public Descuento(int porcentajeDescuento, Establecimiento establecimiento) {
        this.porcentajeDescuento = porcentajeDescuento;
        this.setPorcentajeDeDescuento(porcentajeDescuento);
	}
	
	public void setPorcentajeDeDescuento(int porcentaje){
		this.porcentajeDescuento = porcentaje;
	}
	
	public int getPorcentajeDeDescuento(){
		return this.porcentajeDescuento;
	}
	
	/*
	public double aplicarDescuento(int valorBruto) {
	    return valorBruto - valorBruto * porcentajeDescuento / NUMERO_CIEN;
    }
	*/
}
