package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Club {
	
	private List<Cliente> listaClientes;
	private List<Establecimiento> listaEstablecimiento;

	public Club() {
		this.listaEstablecimiento = new LinkedList<Establecimiento>();
		this.listaClientes = new LinkedList<Cliente>();
	}
	
	public void agregarEstablecimiento(Establecimiento establciemiento) {
		this.listaEstablecimiento.add(establciemiento);
	}
	
	public void agregarCliente(Cliente cliente) {
		this.listaClientes.add(cliente);
	}
	
	public List<Establecimiento> getEstablecimientos() {
		return this.listaEstablecimiento;
	}
	
	public Establecimiento obtenerEstablecimientoConMasBeneficiosOtorgados() {
		Establecimiento establecimientoGanador = getEstablecimientos().get(0);
		for(int i = 1; i < getEstablecimientos().size(); i++) {
			Establecimiento establecimientoActual = getEstablecimientos().get(i);
			if(establecimientoActual.getBeneficioOtorgados() > establecimientoGanador.getBeneficioOtorgados()){
				establecimientoGanador = establecimientoActual;
			}
		}
		return establecimientoGanador;
	}
	
	public Mail felicitarEstablecimientoConMasBeneficiosOtorgados(){
		Establecimiento estableciemientoGanador = obtenerEstablecimientoConMasBeneficiosOtorgados();
		String mensajeDeFelicitaciones = "Felicidades " + estableciemientoGanador.getNombre() + 
				"por ser el establecimiento que mas beneficios otorgo con la cantidad de " +
				estableciemientoGanador.getBeneficioOtorgados();
		Mail mailDeFelcitacion = new Mail(estableciemientoGanador);
		mailDeFelcitacion.setTexto(mensajeDeFelicitaciones);
		return mailDeFelcitacion;
	}

}
