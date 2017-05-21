package ar.edu.untref.aydoo;

public class FrecuenciaQuincenal extends Frecuencia {
	private Frecuencia frecuenciaSiguiente;
	private int frecuenciaAlMes = 2;

	public FrecuenciaQuincenal(String frecuencia) {
		super(frecuencia);
		this.frecuenciaSiguiente = new FrecuenciaSemanal(frecuencia);
	}
	
	@Override
	public void inicializarFrecuenciaAlMes(String frecuencia) {
		setfrecuenciaSiguiente(this.frecuenciaSiguiente);
		if(frecuencia == this.getTipoDeFrecuencia()) {
			System.out.println("frecuencia quincenal");
		} else {
			getDrecuenciaSiguiente().inicializarFrecuenciaAlMes(frecuencia);
		}
	}

	@Override
	public int getFrecuenciaAlMes(String frecuencia) {
		return this.frecuenciaAlMes;
	}
}
