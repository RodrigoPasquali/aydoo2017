package ar.edu.untref.aydoo;

import Excepciones.ExcepcionPocentajeDescuentoInvalido;

public class BeneficioDescuentoPorcentaje extends Beneficio{
	
	Beneficio beneficioSiguiente;
	private int porcentajeDescuento;

	public BeneficioDescuentoPorcentaje(String beneficio, Producto productoA) {
		super(beneficio, productoA);
		this.beneficioSiguiente = new BeneficioPromocion2x1(getBeneficioIngresado(), getProductoA());
	}

	@Override
	public double aplicarBeneficio() {
		setBeneficioSiguiente(this.beneficioSiguiente);
		if(getBeneficioIngresado().equals("CLASSIC")) {
			return calcularDescuento();
		} else {
			return this.getBeneficioSiguiente().aplicarBeneficio();
		}
	}
	
	public void setPorcentajeDescuento(int porcentaje){
		if(porcentaje < 5 || porcentaje > 100){
			throw new ExcepcionPocentajeDescuentoInvalido();
		}
		this.porcentajeDescuento = porcentaje;
	}
	
	public int getPorcentajeDescuento(){
		return this.porcentajeDescuento;
	}
	
	public double calcularDescuento(){
		double descuento = getPrecioProductoA() * getPorcentajeDescuento();
		double precioFinal = getPrecioProductoA() - descuento;
		return precioFinal;
	}

}
