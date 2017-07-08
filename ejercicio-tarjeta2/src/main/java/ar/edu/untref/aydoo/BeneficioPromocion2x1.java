package ar.edu.untref.aydoo;

import Excepciones.ExpecionBeneficioInvalido;
import Excepciones.ExpecionFaltaProducto;

public class BeneficioPromocion2x1 extends Beneficio {
	
	private Producto productoB;

	public BeneficioPromocion2x1(String beneficio, Producto productoA, Producto productoB) {
		super(beneficio, productoA);
		this.productoB = productoB;
	}

	@Override
	public double aplicarBeneficio() throws ExpecionBeneficioInvalido {
		if(getBeneficioIngresado().equals("2x1")) {
			return calcular2x1();
		} else {
	        throw new ExpecionBeneficioInvalido();
	    }
	}
	
	public double calcular2x1() {
		if(this.productoB == null){
			throw new ExpecionFaltaProducto();
		}
		double precioProductoB = this.productoB.getPrecio();
		double precioFinal = getPrecioProductoA() + precioProductoB;
		double precioMasAlto = getPrecioProductoA();
		if(getPrecioProductoA() < precioProductoB){
			precioMasAlto = precioProductoB;
		}
		if(precioMasAlto >= 100) {
			precioFinal = precioMasAlto;
		}
		return precioFinal;
	}

}
