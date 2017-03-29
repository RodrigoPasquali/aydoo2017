package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class ContadorDeVotos {
	
	Partido partidoJ;
	Partido partidoM;
	Provincia jujuy;
	Provincia salta;
	Provincia bunenosAires;
	Candidato juan;
	Candidato jose;
	Candidato mauro;
	Candidato martin;
	ContadorDeVotos contadorDeVotos;
	
	String candidatoGanardor;
	String partidoGanadorEnLaProvincia;

	List<Candidato> listaCandidatos;
	List<Provincia> listaProvincias;
	List<Partido> listaPartidos;
	
	
	public ContadorDeVotos(){
		this.partidoJ = new Partido("J");
		this.partidoM = new Partido("M");
		this.jujuy = new Provincia("Jujuy");
		this.salta = new Provincia("Salta");
		this.bunenosAires = new Provincia("Buenos Aires");
		this.jose = new Candidato("Jose");
		this.juan = new Candidato("Juan");
		this.martin = new Candidato("Martin");
		this.mauro = new Candidato("Mauro");
		this.listaCandidatos = new LinkedList<Candidato>();
		listaCandidatos.add(jose);
		listaCandidatos.add(juan);
		listaCandidatos.add(martin);
		listaCandidatos.add(mauro);
		this.listaProvincias = new LinkedList<Provincia>();
		listaProvincias.add(bunenosAires);
		listaProvincias.add(jujuy);
		listaProvincias.add(salta);
		this.listaPartidos = new LinkedList<Partido>();
		listaPartidos.add(partidoJ);
		listaPartidos.add(partidoM);
		
		//this.contadorDeVotos = new ContadorDeVotos();
	}
			
	
	public void contarVotos(List<Voto> listaVotos){
		//this.contadorDeVotos.contarVotosCandidatos(listaVotos);
		//this.contadorDeVotos.contarVotosPartido(listaVotos);
		//this.contadorDeVotos.contarVotosProvincia(listaVotos);
		this.contarVotosCandidatos(listaVotos);
		this.contarVotosPartido(listaVotos);
		this.contarVotosProvincia(listaVotos);
	}

	public void contarVotosCandidatos(List<Voto> listaVotos){
		for(int i = 0; i < listaVotos.size();i++){
			if(listaVotos.get(i).getCandidato() == "Juan"){
				this.juan.sumarVoto();
			}else if(listaVotos.get(i).getCandidato() == "Jose" ){
				this.jose.sumarVoto();
			}else if(listaVotos.get(i).getCandidato() == "Martin" ){
				this.martin.sumarVoto();
			}else if(listaVotos.get(i).getCandidato() == "Mauro" ){
				this.mauro.sumarVoto();
			}
		}
	}
	
	private void contarVotosProvincia(List<Voto> listaVotos){
		for(int i = 0; i < listaVotos.size();i++){
			if(listaVotos.get(i).getProvincia() == "Salta"){
				this.salta.sumarVoto();
			}else if(listaVotos.get(i).getProvincia() == "Jujuy"){
				this.jujuy.sumarVoto();
			}else if(listaVotos.get(i).getProvincia() == "Buenos Aires"){
				this.bunenosAires.sumarVoto();
			}
		}
	}
	
	private void contarVotosPartido(List<Voto> listaVotos){
		for(int i = 0; i < listaVotos.size(); i++){
			if(listaVotos.get(i).getPartido() == "M"){
				this.partidoM.sumarVoto();
			}else if(listaVotos.get(i).getPartido() == "J"){
				this.partidoJ.sumarVoto();
			}
		}
	}
	
	public void contarVotosPorPartidoEnProvincias(List<Voto> listaVotos){
		for(int i = 0; i < listaVotos.size(); i++){
			if(listaVotos.get(i).getPartido() == "M"){
				for(int j = 0; j < listaVotos.size(); j++){
					if(listaVotos.get(j).getProvincia() == "Salta"){
						this.salta.sumarVotoAPartido(partidoM);
					}else if(listaVotos.get(j).getProvincia() == "Jujuy"){
						this.jujuy.sumarVotoAPartido(partidoM);
					}else if(listaVotos.get(j).getProvincia() == "Buenos Aires"){
						this.bunenosAires.sumarVotoAPartido(partidoM);
					}
				}
			}else if(listaVotos.get(i).getPartido() == "J"){
				for(int z = 0; z < listaVotos.size(); z++){
					if(listaVotos.get(z).getProvincia() == "Salta"){
						this.salta.sumarVotoAPartido(partidoJ);
					}else if(listaVotos.get(z).getProvincia() == "Jujuy"){
						this.jujuy.sumarVotoAPartido(partidoJ);
					}else if(listaVotos.get(z).getProvincia() == "Buenos Aires"){
						this.bunenosAires.sumarVotoAPartido(partidoJ);
					}
				}
			}
		}
	}
	
	public void mostrarVotos(){
		this.juan.getVotos();
		this.bunenosAires.getVotos();
		this.jose.getVotos();
		this.martin.getVotos();
		this.mauro.getVotos();
		this.salta.getVotos();
		this.jujuy.getVotos();
		this.partidoJ.getVotos();
		this.partidoM.getVotos();
	}
	
	public String candidatoGanadorNacional(){
		this.candidatoGanardor = this.listaCandidatos.get(0).getNombre();
		int votosGanador = 0;
		for(int i = 0; i < this.listaCandidatos.size(); i++){
			if(votosGanador < this.listaCandidatos.get(i).getVotos()){
				votosGanador = this.listaCandidatos.get(i).getVotos();
				this.candidatoGanardor = this.listaCandidatos.get(i).getNombre();
			}
		}
		System.out.println("El Candidato ganador es  " + this.candidatoGanardor + " con " + votosGanador);
		return this.candidatoGanardor;
	}
	
	public String partidoGanadorEnlaProvincia(String nombreProvincia){
		String partidoGanador = "no se";
		if(nombreProvincia == "Salta"){
			partidoGanador = this.salta.partidoGanadorEnlaProvincia();
		}else if(nombreProvincia == "Jujuy"){
			partidoGanador = this.jujuy.partidoGanadorEnlaProvincia();
		}else if(nombreProvincia == "Buenos Aires"){
			partidoGanador = this.bunenosAires.partidoGanadorEnlaProvincia();
		}
		return partidoGanador;
	}
	
	/*
	public String partidoGanadorEnUnaProvincia(String nombreProvincia, List<Voto> listaVotos){
		this.partidoGanadorEnLaProvincia = this.listaPartidos.get(0).getNombre();
		int votosGanador = 0;
		for(int i = 0; i < listaVotos.size(); i++){
			if(listaVotos.get(i).getProvincia() == nombreProvincia){
				for(int j = 0; j < this.listaPartidos.size(); j++){
					if(votosGanador < this.listaPartidos.get(j).getVotos()){
						votosGanador = this.listaPartidos.get(j).getVotos();
						this.partidoGanadorEnLaProvincia = this.listaPartidos.get(j).getNombre();
					}
				}
			}
		}
		System.out.println("El partido " + this.partidoGanadorEnLaProvincia + " gano en "  + nombreProvincia);
		return this.partidoGanadorEnLaProvincia;
	}
	/*
	 * 
	 */
	
	
	
}
