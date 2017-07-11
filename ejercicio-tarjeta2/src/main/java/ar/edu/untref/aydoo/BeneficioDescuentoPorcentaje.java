package ar.edu.untref.aydoo;

import java.util.List;

public class BeneficioDescuentoPorcentaje extends Beneficio{
	
	Beneficio beneficioSiguiente;
	private List<Producto> listaDeProductos;

	public BeneficioDescuentoPorcentaje(String beneficio, List<Producto> productos, Tarjeta tarjeta) {
		super(beneficio, productos, tarjeta);
		this.beneficioSiguiente = new BeneficioPromocion2x1(beneficio, productos, tarjeta);
		this.listaDeProductos = productos;
	}

	@Override
	public double aplicarBeneficio() {
		setBeneficioSiguiente(this.beneficioSiguiente);
		if(getBeneficioIngresado().equals("descuento")) {
			return calcularDescuento();
		} else {
			return this.getBeneficioSiguiente().aplicarBeneficio();
		}
	}
	
	private double calcularDescuento(){
		double precioProducto = this.listaDeProductos.get(0).getPrecio();
		double descuento = (precioProducto * getPorcentajeDescuento())/ 100;
		System.out.println(descuento);
		double precioFinal = precioProducto - descuento;
		return precioFinal;
	}

}
