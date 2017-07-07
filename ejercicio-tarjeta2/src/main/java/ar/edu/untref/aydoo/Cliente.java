package ar.edu.untref.aydoo;

public class Cliente {

	private String mailCliente;
	private String nombreCliente;
	private Tarjeta tarjetaCliente;

	public Cliente(String nombre, String mail) {
		this.nombreCliente = nombre;
		this.mailCliente = mail;
	}
	
	public void setTarjeta(Tarjeta tarjeta){
		this.tarjetaCliente = tarjeta;
	}
	
	public Tarjeta getTarjeta() {
		return this.tarjetaCliente;
	}
	
	public void registrarCompra(Compra compra, Sucursal sucursal){
	}
}
