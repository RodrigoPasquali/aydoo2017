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
		double precioProducto = 0;
		for(int i = 0; i < listaDeProductos.size(); i++){
			precioProducto = precioProducto + listaDeProductos.get(i).getPrecio();
		}
		double descuento = (precioProducto * getPorcentajeDescuento())/ 100;
		double precioFinal = precioProducto - descuento;
		return precioFinal;
	}

}
