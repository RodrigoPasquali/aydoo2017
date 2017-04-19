package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Club {
	
	private String nombreDelClub;
	
	public Club(String nombre){
		this.nombreDelClub = nombre;
	}

	List<Establecimiento> listaDeEstablecimientos = new LinkedList<Establecimiento>();
	Establecimiento establecimientoConMasBeneficios;
	private Sucursal sucursalQueOtorgoMasBeneficios;
	
	public void agregarEstablecimientos(Establecimiento establecimiento){
		this.listaDeEstablecimientos.add(establecimiento);
	}
	
	public List<Establecimiento> getListaDeEstablecimientos(){
		return this.listaDeEstablecimientos;
	}
	
	public Establecimiento getEstablecimientoQueOtorgoMasBeneficios(){
		this.establecimientoConMasBeneficios = this.listaDeEstablecimientos.get(0);
		for(int i=1; i < this.listaDeEstablecimientos.size(); i++){
			if(this.establecimientoConMasBeneficios.getCantidadDeBeneficiosOtorgados() < this.listaDeEstablecimientos.get(i).getCantidadDeBeneficiosOtorgados()){
				this.establecimientoConMasBeneficios = this.listaDeEstablecimientos.get(i);
			}
		}
		return this.establecimientoConMasBeneficios;
	}
	
	public void enviarMaildeFelicitaciones(MailDeFelicitaciones mail){
		this.establecimientoConMasBeneficios.setMailDeFelicitaciones(mail);
	}
	
	public Sucursal getSucursalQueOtorgoMasBeneficios(){
		this.sucursalQueOtorgoMasBeneficios = this.listaDeEstablecimientos.get(0).getSucursalQueOtorgoMasBeneficios();
		for(int i = 1; i <  this.listaDeEstablecimientos.size(); i++){
			if(this.sucursalQueOtorgoMasBeneficios.getCantidadBeneficiosOtorgados() < this.listaDeEstablecimientos.get(i).getSucursalQueOtorgoMasBeneficios().getCantidadBeneficiosOtorgados()){
				this.sucursalQueOtorgoMasBeneficios = this.listaDeEstablecimientos.get(i).getSucursalQueOtorgoMasBeneficios();
			}
		}
		return this.sucursalQueOtorgoMasBeneficios;
	}
	
}
