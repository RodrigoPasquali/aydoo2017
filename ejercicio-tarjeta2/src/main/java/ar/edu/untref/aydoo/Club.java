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
	
	public Establecimiento obtenerEstablecimientoConMasBeneficiosOtorgadosEnMes(Mes mes) {
		Establecimiento establecimientoGanador = getEstablecimientos().get(0);
		for(int i = 1; i < getEstablecimientos().size(); i++) {
			Establecimiento establecimientoActual = getEstablecimientos().get(i);
			if(establecimientoActual.getCantidadBeneficioOtorgadosEnMes(mes) > establecimientoGanador.getCantidadBeneficioOtorgadosEnMes(mes)){
				establecimientoGanador = establecimientoActual;
			}
		}
		return establecimientoGanador;
	}
	
	public Mail felicitarEstablecimientoConMasBeneficiosOtorgadosEnMes(Mes mes){
		Establecimiento estableciemientoGanador = obtenerEstablecimientoConMasBeneficiosOtorgadosEnMes(mes);
		String mensajeDeFelicitaciones = "Felicidades " + estableciemientoGanador.getNombre() + 
				" por ser el establecimiento que mas beneficios otorgo con la cantidad de " +
				estableciemientoGanador.getCantidadBeneficioOtorgadosEnMes(mes) + " en el mes de " + mes+ "!";
		Mail mailDeFelcitacion = new Mail();
		mailDeFelcitacion.setTexto(mensajeDeFelicitaciones);
		return mailDeFelcitacion;
	}
	
	public Sucursal obtenerSucursalQueAtendioMasClientesEnMes(Mes mes) {
		Sucursal sucursalGanadora = getEstablecimientos().get(0).getSucursalQueAtendioMasClientesEnMes(mes);
		for(int i = 1; i < getEstablecimientos().size(); i++) {
			Sucursal sucursalActual = getEstablecimientos().get(i).getSucursalQueAtendioMasClientesEnMes(mes);
			if(sucursalGanadora.getCantidadDeVentasEnMes(mes) < sucursalActual.getCantidadDeVentasEnMes(mes)) {
				sucursalGanadora = sucursalActual;
			}
		}
		return sucursalGanadora;
	}
	
	public Mail enviarRegaloASucursalQueAtendioMasClientesEnElMes(Mes mes) {
		Sucursal sucursalGanadora = obtenerSucursalQueAtendioMasClientesEnMes(mes);
		String mensajeDeFelicitaciones = "Felicidades " + sucursalGanadora.getNombre() + 
				" por ser la sucursal ganadora del regalo del mes de " + mes + 
				" por ser la sucursal que mas cliente atendio con la cantidad de " +
				sucursalGanadora.getCantidadDeVentasEnMes(mes) + "!";
		Mail mailDeFelcitacion = new Mail();
		mailDeFelcitacion.setTexto(mensajeDeFelicitaciones);
		return mailDeFelcitacion;
	}

}
