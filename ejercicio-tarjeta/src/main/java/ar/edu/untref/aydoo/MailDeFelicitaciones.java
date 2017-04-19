package ar.edu.untref.aydoo;

public class MailDeFelicitaciones {
	
	private Establecimiento establecimiento;
	private String texto;
	
	public MailDeFelicitaciones(Establecimiento establecimiento){
		this.establecimiento = establecimiento;
	}

	public void setTexto(String texto){
		this.texto = texto;
	}
	
	public String getTexto(){
		return this.texto;
	}
	
}
