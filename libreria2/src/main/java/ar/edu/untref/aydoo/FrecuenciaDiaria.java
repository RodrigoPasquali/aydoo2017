package ar.edu.untref.aydoo;

public class FrecuenciaDiaria extends Frecuencia{
	int frecuenciaAlMes = 30;
	Frecuencia frecuenciaSiguiente;

	public FrecuenciaDiaria(String frecuencia) {
		super(frecuencia);
		this.frecuenciaSiguiente = new FrecuenciaMensual(frecuencia);
	}
	
	@Override
	public void inicializarFrecuenciaAlMes(String frecuencia) {
		setfrecuenciaSiguiente(this.frecuenciaSiguiente);
		if(frecuencia == this.getTipoDeFrecuencia()) {
			System.out.println("frecuencia diaria");
		} else {
			getDrecuenciaSiguiente().inicializarFrecuenciaAlMes(frecuencia);
		}
	}

	@Override
	public int getFrecuenciaAlMes(String frecuencia) {
		return this.frecuenciaAlMes;
	}

}
