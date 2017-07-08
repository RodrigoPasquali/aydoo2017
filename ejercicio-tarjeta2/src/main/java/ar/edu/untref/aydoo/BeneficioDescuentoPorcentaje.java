package ar.edu.untref.aydoo;

public class BeneficioDescuentoPorcentaje extends Beneficio{
	
	Beneficio beneficioSiguiente;

	public BeneficioDescuentoPorcentaje(String beneficio, Producto productoA, Producto productoB) {
		super(beneficio, productoA);
		this.beneficioSiguiente = new BeneficioPromocion2x1(getBeneficioIngresado(), getProductoA(), productoB);
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
	
	public double calcularDescuento(){
		double descuento = (getPrecioProductoA() * getPorcentajeDescuento())/ 100;
		System.out.println(descuento);
		double precioFinal = getPrecioProductoA() - descuento;
		return precioFinal;
	}

}
