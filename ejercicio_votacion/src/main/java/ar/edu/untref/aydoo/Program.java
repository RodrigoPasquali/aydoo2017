package ar.edu.untref.aydoo;

import java.util.List;

public class Program {
    public static final void main(String arg[]){
    	
    	Voto voto1 = new Voto("Juan","J","Buenos Aires");
        Voto voto2 = new Voto("Juan","J","Buenos Aires");
        Voto voto3 = new Voto("Juan","J","Buenos Aires");
        Voto voto4 = new Voto("Juan","J","Salta");
        Voto voto5 = new Voto("Jose","J","Jujuy");
        Voto voto6 = new Voto("Juan","J","Jujuy");
        Voto voto7 = new Voto("Martin","M","Jujuy");
        Voto voto8 = new Voto("Martin","M","Jujuy");
        Voto voto9 = new Voto("Martin","M","Jujuy");
        Voto voto10 = new Voto("Mauro","M","Jujuy");
        
        Urna urna = new Urna();
        urna.ponerVoto(voto1);
        urna.ponerVoto(voto2);
        urna.ponerVoto(voto3);
        urna.ponerVoto(voto4);
        urna.ponerVoto(voto5);
        urna.ponerVoto(voto6);
        urna.ponerVoto(voto7);
        urna.ponerVoto(voto8);
        urna.ponerVoto(voto9);
        urna.ponerVoto(voto10);
        
        ContadorDeVotos contadorDeVotos = new ContadorDeVotos();
       
        contadorDeVotos.contarVotos(urna.getListaVotos());
        
        contadorDeVotos.mostrarVotos();
            	
        contadorDeVotos.candidatoGanadorNacional();
        
        contadorDeVotos.contarVotosPorPartidoEnProvincias(urna.getListaVotos());
        
        contadorDeVotos.partidoGanadorEnlaProvincia("Jujuy");
        
        contadorDeVotos.partidoGanadorEnlaProvincia("Salta");

        contadorDeVotos.partidoGanadorEnlaProvincia("Buenos Aires");


    }
}
