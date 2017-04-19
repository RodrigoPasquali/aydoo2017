package ar.edu.untref.aydoo;

public class DescuentoParaTarjetaClassic extends Descuento {

	public DescuentoParaTarjetaClassic(int porcentajeDescuento, Establecimiento establecimiento) {
		super(porcentajeDescuento, establecimiento);
		establecimiento.setDescuentoClassic(this);
		// TODO Auto-generated constructor stub
	}

	
}
