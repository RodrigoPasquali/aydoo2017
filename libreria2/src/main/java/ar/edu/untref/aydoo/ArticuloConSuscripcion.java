package ar.edu.untref.aydoo;

//Tipo de objeto: Value Object
public abstract class ArticuloConSuscripcion{
	
	private int frecuenciaPublicacionMensual;
	private boolean suscripcionAnual;
	private double precioConDescuento;
	private double precio;

	public ArticuloConSuscripcion(String nombre, String tipoDeProducto, double precio){
		this.precio = precio;
	}
	
	public void ponerPeriodicidad(int periocidad){
		this.frecuenciaPublicacionMensual = periocidad;
	}
	
	public int obtenerPeriodicidad(){
		return this.frecuenciaPublicacionMensual;
	}
	
	public boolean tieneSuscripcionAnual(){
		return this.suscripcionAnual;
	}
	
	public double aplicarDescuentoPorSuscripcionEnUnMes() {
		this.precioConDescuento = this.precio;
		if(this.suscripcionAnual){
			this.precioConDescuento = (this.precio - this.precio*0.2) * this.frecuenciaPublicacionMensual;
			return this.precioConDescuento;
		}else{
			System.out.println("No posee descuentos por Inscripcion Anual");
		}
		return this.precioConDescuento;
	}
	
	/*
	@Override
	public double obtenerPrecio(){
		return this.aplicarDescuentoPorSuscripcionEnUnMes();
	}
	*/
	
}