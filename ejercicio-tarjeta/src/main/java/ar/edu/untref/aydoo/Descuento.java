package ar.edu.untref.aydoo;

public class Descuento extends Beneficio {
	private int porcentajeDescuento;

	public Descuento(String tipoDeBeneficio, Establecimiento establecimiento) {
		super(tipoDeBeneficio, establecimiento);
        //this.porcentajeDescuento = porcentajeDescuento;
        //this.setPorcentajeDeDescuento(porcentajeDescuento);
	}
	
	public void setPorcentajeDeDescuento(int porcentaje){
		this.porcentajeDescuento = porcentaje;
	}
	
	public int getPorcentajeDeDescuento(){
		return this.porcentajeDescuento;
	}

	@Override
	public void obtenerBeneficio() {
		// TODO Auto-generated method stub
		
	}

}
