package ar.edu.untref.aydoo;

public class Promocion2x1 extends Beneficio{
	Beneficio descuento;
	String tipoDeBeneficioActual = "promocion2x1";

	public Promocion2x1(String tipoDeBeneficio, Establecimiento establecimiento) {
		super(tipoDeBeneficio, establecimiento);
		this.descuento = new Descuento(tipoDeBeneficio, establecimiento);
	}

	@Override
	public void obtenerBeneficio() {
		setSiguienteBeneficio(this.descuento);
		if(getTipoDeBeneficio().equals(this.tipoDeBeneficioActual)){
			
		} else {
			getSiguienteBeneficio().obtenerBeneficio();
		}
	}
	

}
