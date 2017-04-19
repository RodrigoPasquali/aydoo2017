package ar.edu.untref.aydoo;

/**
 * Created by nicopaez on 4/12/17.
 */
public class DescuentoParaTarjetaPremium extends Descuento {

    public DescuentoParaTarjetaPremium(int porcentajeDescuento, Establecimiento establecimiento) {
		super(porcentajeDescuento, establecimiento);
        establecimiento.setDescuentoPremium(this);
    }

    /*
    public double aplicarDescuento(int valorBruto) {
        return valorBruto - valorBruto * porcentajeDescuento / 100;
    }
    */
}
