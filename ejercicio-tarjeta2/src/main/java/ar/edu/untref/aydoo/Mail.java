package ar.edu.untref.aydoo;

public class Mail {
	
	private Establecimiento establecimientoAFelicitar;
	private String textoDelMail;

	public Mail(Establecimiento establecimiento) {
		this.establecimientoAFelicitar = establecimiento;
	}
	
	public void setTexto(String texto) { 
		this.textoDelMail = texto;
	}
	
	public String getTexto() {
		return this.textoDelMail;
	}

}
