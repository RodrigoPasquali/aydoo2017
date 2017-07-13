package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import Excepciones.ExcepcionClienteNoUtilizoTarjeta;

public class ClubBeneficios {
	
	private List<Cliente> listaClientes;
	private List<Establecimiento> listaEstablecimiento;

	public ClubBeneficios() {
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
	
	public Establecimiento getEstablecimientoConMasBeneficiosOtorgadosEnMes(Mes mes) {
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
		Establecimiento estableciemientoGanador = getEstablecimientoConMasBeneficiosOtorgadosEnMes(mes);
		String mensajeDeFelicitaciones = "Felicidades " + estableciemientoGanador.getNombre() + 
				" por ser el establecimiento que mas beneficios otorgo con la cantidad de " +
				estableciemientoGanador.getCantidadBeneficioOtorgadosEnMes(mes) + " en el mes de " + mes+ "!";
		Mail mailDeFelcitacion = new Mail();
		mailDeFelcitacion.setTexto(mensajeDeFelicitaciones);
		return mailDeFelcitacion;
	}
	
	public Sucursal getSucursalQueAtendioMasClientesEnMes(Mes mes) {
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
		Sucursal sucursalGanadora = getSucursalQueAtendioMasClientesEnMes(mes);
		String mensajeDeFelicitaciones = "Felicidades " + sucursalGanadora.getNombre() + 
				" por ser la sucursal ganadora del regalo del mes de " + mes + 
				" por ser la sucursal que mas cliente atendio con la cantidad de " +
				sucursalGanadora.getCantidadDeVentasEnMes(mes) + "!";
		Mail mailDeFelcitacion = new Mail();
		mailDeFelcitacion.setTexto(mensajeDeFelicitaciones);
		return mailDeFelcitacion;
	}
	
	private String getNombreProductos(List<Producto> productos) {
		String nombreProductos = "";
		for(int i = 0; i < productos.size(); i++) {
			String productoActual = productos.get(i).getNombre();
			nombreProductos = nombreProductos + productoActual;
		}
		return nombreProductos;
	}
	
	public String generarReporteDeAhorrosDeClienteEnMes(Cliente cliente, Mes mes) {
		List<Compra> listaDeCompras = cliente.getListaDeCompras();
		String reporte = "...Reporte de ahorros obtenidos por " + cliente.getNombre() + " con la tarjeta del club en el mes de " + mes + "... \r\n"
				+ "Establecimiento | Producto Comprado  | Precio Habitual | Precio Con Beneficio | Beneficio \r\n";
		for(int i = 0; i < listaDeCompras.size(); i++) {
			Compra compraActual = listaDeCompras.get(i);
			if(compraActual.getMes().equals(mes)) {
				String establecimiento = compraActual.getSucursal().getEstablecimientoAlQuePertenece().getNombre();
				List<Producto> listaProductos = compraActual.getListaProductosComprados();
				String nombreDeProductos = getNombreProductos(listaProductos);
				double precioSinBeneficio = compraActual.getPrecioProductosSinBeneficio();
				double precioConBeneficio = compraActual.getPrecioProductosConBeneficio();
				String beneficioOtorgado = compraActual.getBeneficio();
				reporte = reporte + establecimiento + " | " + nombreDeProductos + " | " + precioSinBeneficio + " | " + 
						precioConBeneficio + " | " + beneficioOtorgado + " \r\n" ;
			} else {
				throw new ExcepcionClienteNoUtilizoTarjeta();
			}
		}
		return reporte;
	}

}
