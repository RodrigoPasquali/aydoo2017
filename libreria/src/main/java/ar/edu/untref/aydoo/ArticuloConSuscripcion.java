package src.main.java.ar.edu.untref.aydoo;

public abstract class ArticuloConSuscripcion extends Producto {
	
	public int frecuenciaPublicacionMensual;
	public boolean suscripcionAnual;
	public double precioConDescuento;
	public double precio;

	public ArticuloConSuscripcion(String nombre, double precio, int frecuenciaPublicacionMensual, boolean suscripcionAnual, String mes, int cantidad){
		super(nombre, precio, mes, cantidad);
		this.frecuenciaPublicacionMensual = frecuenciaPublicacionMensual;
		this.suscripcionAnual = suscripcionAnual;
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
	
	@Override
	public double obtenerPrecio(){
		return this.aplicarDescuentoPorSuscripcionEnUnMes();
	}
	
}