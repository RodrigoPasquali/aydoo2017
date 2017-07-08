package ar.edu.untref.aydoo;

import Excepciones.ExpecionBeneficioInvalido;
import Excepciones.ExpecionFaltaProducto;

public class BeneficioPromocion2x1 extends Beneficio {
	
	private Producto precioProductoB = null;

	public BeneficioPromocion2x1(String beneficio, Producto productoA) {
		super(beneficio, productoA);
	}

	@Override
	public double aplicarBeneficio() throws ExpecionBeneficioInvalido {
		if(getBeneficioIngresado().equals("2x1")) {
			return calcular2x1();
		} else {
	        throw new ExpecionBeneficioInvalido();
	    }
	}
		
	public void setProductoB(Producto productoB){
		this.precioProductoB = productoB;
	}
	
	public double getPrecioProductoB() {
		double precioProductoB = this.precioProductoB.getPrecio();
		return precioProductoB;
	}
	
	public double calcular2x1() {
		if(this.precioProductoB.equals(null)){
			throw new ExpecionFaltaProducto();
		}
		double precioFinal = getPrecioProductoA() + getPrecioProductoB();
		double precioMasAlto = getPrecioProductoA();
		if(getPrecioProductoA() < getPrecioProductoB()){
			precioMasAlto = getPrecioProductoB();
		}
		if(precioMasAlto > 100) {
			precioFinal = precioMasAlto;
		}
		return precioFinal;
	}

}
