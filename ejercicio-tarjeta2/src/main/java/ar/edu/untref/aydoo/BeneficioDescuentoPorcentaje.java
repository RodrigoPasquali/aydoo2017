package ar.edu.untref.aydoo;

import java.util.List;

public class BeneficioDescuentoPorcentaje extends Beneficio{
	
	Beneficio beneficioSiguiente;
	private List<Producto> listaDeProductos;

	public BeneficioDescuentoPorcentaje(String beneficio, Tarjeta tarjeta) {
		super(beneficio, tarjeta);
		this.beneficioSiguiente = new BeneficioPromocion2x1(beneficio, tarjeta);
	}

	@Override
	public double aplicarBeneficio() {
		setBeneficioSiguiente(this.beneficioSiguiente);
		if(getBeneficioIngresado().equals("descuento")) {
			return calcularDescuento();
		} else {
			getBeneficioSiguiente().setProductos(getProductos());
			return this.getBeneficioSiguiente().aplicarBeneficio();
		}
	}
	
	private double calcularDescuento(){
		this.listaDeProductos = getProductos();
		double precioProducto = this.listaDeProductos.get(0).getPrecio();
		double descuento = (precioProducto * getPorcentajeDescuento())/ 100;
		System.out.println(descuento);
		double precioFinal = precioProducto - descuento;
		return precioFinal;
	}

}
