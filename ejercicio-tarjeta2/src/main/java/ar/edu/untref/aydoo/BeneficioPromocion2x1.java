package ar.edu.untref.aydoo;

import java.util.List;

import Excepciones.ExcepcionBeneficioInvalido;
import Excepciones.ExcepcionFaltaProducto;

public class BeneficioPromocion2x1 extends Beneficio {
	
	private List<Producto> listaDeProductos;
	
	public BeneficioPromocion2x1(String beneficio, Tarjeta tarjeta) {
		super(beneficio, tarjeta);
	}

	@Override
	public double aplicarBeneficio() throws ExcepcionBeneficioInvalido {
		if(getBeneficioIngresado().equals("2x1")) {
			return calcular2x1();
		} else {
	        throw new ExcepcionBeneficioInvalido();
	    }
	}
	
	public double calcular2x1() {
		this.listaDeProductos = getProductos();
		if(this.listaDeProductos.size() < 2){
			throw new ExcepcionFaltaProducto();
		}
		double precioProductoA = this.listaDeProductos.get(0).getPrecio();
		double precioProductoB = this.listaDeProductos.get(1).getPrecio();
		double precioFinal = precioProductoA + precioProductoB;
		double precioMasAlto = precioProductoA;
		if(precioProductoA < precioProductoB){
			precioMasAlto = precioProductoB;
		}
		if(precioMasAlto >= 100) {
			precioFinal = precioMasAlto;
		}
		return precioFinal;
	}

}
