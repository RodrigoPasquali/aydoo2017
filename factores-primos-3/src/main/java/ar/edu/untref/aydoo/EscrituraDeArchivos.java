package ar.edu.untref.aydoo;

import java.io.FileWriter;

public class EscrituraDeArchivos {
	
	public static void main(String[] args){
		
		EscrituraDeArchivos escritor = new EscrituraDeArchivos();
		escritor.escribirArchivo("salida.txt", "Hola como andas? " + "\r\n" + "Bien");
	
	}
	
	public void escribirArchivo(String directorio, String texto){
		//File fichero = new File(sFichero);
		/* 
		if (fichero.exists()){
			}
		*/
		FileWriter fichero = null;
       // PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(directorio);
            //pw = new PrintWriter(fichero);
            //pw.println(texto);
            fichero.write(texto);
			
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}

}
