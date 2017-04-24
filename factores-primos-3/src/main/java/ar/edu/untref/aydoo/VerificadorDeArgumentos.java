package ar.edu.untref.aydoo;

public class VerificadorDeArgumentos {
	
	private String formato;
	private String orden;
	private String outPutFile;
	
	/*nose si voy a usar esto
	public void verificar(String[] argumentos){
		if(this.verificarSiArgumentosEsNumero(argumentos[0])){			
				//}
		}
			//debe lanzar excepcion que primer argumento debe ser un numero natural
	}
	*/
	
	
	//falta poner lo que pasa cuando no lo encuentra
	public void verificarFormato(String[] cadena){
		this.formato = "--format=quiet";
		for (int i = 0; i<cadena.length; i++){
			int resultado = cadena[i].indexOf("--format=");        
	        if(resultado != -1) {
				cadena[i].toLowerCase();
				if(cadena[i].equals("--format=quiet")){
					this.formato = "--format=quiet";
				}else if(cadena[i].equals("--format=quiet")){
					this.formato = "--format=quiet";
				}else{
					//devuelve la expecion por formato invalido
				}
	        }
		}
	}
	
	public void verificarOrden(String[] cadena){
		this.orden = "--sort=asc";
		for (int i = 0; i<cadena.length; i++){
			int resultado = cadena[i].indexOf("--sort=");        
	        if(resultado != -1) {
				if(cadena[i].equals("--sort=asc")){
					this.orden = "--sort=asc";
				}else if(cadena[i].equals("--sort=desc")){
					this.orden = "--sort=desc";
				}else{
					//devuelve exepcion por orden invalido
				}
	        }
		}
	}
	
	public void verificarOutputFile(String[] cadena){
		for (int i = 0; i<cadena.length; i++){
			int resultado = cadena[i].indexOf("--output-file=");        
	        if(resultado != -1) {
	        	String aux = cadena[i].substring(14);
	        	if(aux.endsWith(".txt")){
					this.outPutFile = aux;
				}else{
					//devuelve exepcion por outPut invalido
				}
	        }
		}
	}
	
	public boolean verificarSiArgumentosEsNumero(String cadena){
		try{
   			Integer.parseInt(cadena);
   			return true;
       	} catch (NumberFormatException nfe){
       		System.out.println("El 1 elemento debe ser un numero natural");
       		return false;
   		}
   }

}
