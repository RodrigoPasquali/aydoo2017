package ar.edu.untref.aydoo;

public abstract class Beneficio {
	private Beneficio siguiente;
	private String tipoDeBeneficio;

	public Beneficio(String tipoDeBeneficio, Establecimiento establecimiento) {
		String tipoBenedicioMiniscula = tipoDeBeneficio.toLowerCase();
		this.tipoDeBeneficio = tipoBenedicioMiniscula;
	}
	
	public void setSiguienteBeneficio(Beneficio beneficio){
		this.siguiente = beneficio;
	}
	
	public Beneficio getSiguienteBeneficio(){
		return this.siguiente;
	}
	
	public abstract void obtenerBeneficio();

	public String getTipoDeBeneficio() {
		return tipoDeBeneficio;
	}
	
}
