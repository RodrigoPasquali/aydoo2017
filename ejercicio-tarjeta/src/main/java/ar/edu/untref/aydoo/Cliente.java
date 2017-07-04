package ar.edu.untref.aydoo;

/**
 * Created by nicopaez on 4/12/17.
 */
public class Cliente {
    private final String nombre;
    private String email;
	private Tarjeta tarjeta;

    public Cliente(String nombre, String email) {
        this.email = email;
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setTarjeta(Tarjeta tarjeta) {
    	if(this.tarjeta.equals(null)) {
        	this.tarjeta = tarjeta;
    	} else {
    	//Excepciones que posee una tarjeta
    	}
    }
    
    public Tarjeta getTarjeta(){
    	return this.tarjeta;
    }

}
