package ar.edu.untref.aydoo;

import java.io.FileWriter;

public class EscrituraDeArchivos {
	
	public void escribirArchivo(String directorio, String texto){
	
		FileWriter fichero = null;
        try
        {
            fichero = new FileWriter(directorio);
            fichero.write(texto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
        }
	}

}
