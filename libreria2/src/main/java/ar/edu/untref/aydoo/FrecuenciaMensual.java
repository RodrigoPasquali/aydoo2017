package ar.edu.untref.aydoo;

public class FrecuenciaMensual extends Frecuencia{

	private Frecuencia frecuenciaSiguiente;
	private int frecuenciaAlMes = 1;

	public FrecuenciaMensual(String frecuencia) {
		super(frecuencia);
		this.frecuenciaSiguiente = new FrecuenciaQuincenal(frecuencia);
	}
	
	@Override
	public void inicializarFrecuenciaAlMes(String frecuencia) {
		setfrecuenciaSiguiente(this.frecuenciaSiguiente);
		if(frecuencia == this.getTipoDeFrecuencia()) {
			System.out.println("frecuencia mensual");
		} else {
			getDrecuenciaSiguiente().inicializarFrecuenciaAlMes(frecuencia);
		}
	}

	@Override
	public int getFrecuenciaAlMes(String frecuencia) {
		return this.frecuenciaAlMes ;
	}
}
