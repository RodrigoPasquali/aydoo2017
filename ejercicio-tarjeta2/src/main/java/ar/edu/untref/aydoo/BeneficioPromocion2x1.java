package ar.edu.untref.aydoo;

import java.util.List;

import Excepciones.ExpecionBeneficioInvalido;
import Excepciones.ExpecionFaltaProducto;

public class BeneficioPromocion2x1 extends Beneficio {
	
	private List<Producto> listaDeProductos;
	
	public BeneficioPromocion2x1(String beneficio, List<Producto> productos, Tarjeta tarjeta) {
		super(beneficio, productos, tarjeta);
		this.listaDeProductos = productos;
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
		if(this.listaDeProductos.size() < 2){
			throw new ExpecionFaltaProducto();
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
