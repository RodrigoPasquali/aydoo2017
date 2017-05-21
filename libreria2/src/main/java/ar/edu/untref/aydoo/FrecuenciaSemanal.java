package ar.edu.untref.aydoo;

public class FrecuenciaSemanal extends Frecuencia {
	private int frecuenciaAlMes = 2;

	public FrecuenciaSemanal(String frecuencia) {
		super(frecuencia);
	}
	
	@Override
	public void inicializarFrecuenciaAlMes(String frecuencia) {
		if(frecuencia == this.getTipoDeFrecuencia()) {
			System.out.println("frecuencia quincenal");
		} else {
			System.out.println("Frcuenci Invalida");
		}
	}

	@Override
	public int getFrecuenciaAlMes(String frecuencia) {
		return this.frecuenciaAlMes;
	}
}
