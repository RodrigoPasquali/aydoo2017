package ar.edu.untref.aydoo;

public class VerificadorDeArgumentos {
	
	private String formato;
	private String orden;
	private String outPutFile = null;
	
	public void verificarFormato(String[] cadena){
		this.formato = "--format=pretty";
		String aux;
		for (int i = 0; i<cadena.length; i++){
			int resultado = cadena[i].indexOf("--format=");        
	        if(resultado != -1) {
	        	aux = cadena[i].toLowerCase();
				if(aux.equals("--format=pretty")){
					this.formato = "--format=pretty";
				}else if(aux.equals("--format=quiet")){
					this.formato = "--format=quiet";
				}else{
					throw new ExcepcionFormatoInvalido();
				}
	        }
		}
	}
	
	public void verificarOrden(String[] cadena){
		this.orden = "--sort=asc";
		String aux;
		for (int i = 0; i<cadena.length; i++){
			int resultado = cadena[i].indexOf("--sort=");        
	        if(resultado != -1) {
	        	aux = cadena[i];
				if(aux.equals("--sort=asc")){
					this.orden = "--sort=asc";
				}else if(aux.equals("--sort=desc")){
					this.orden = "--sort=desc";
				}else{
					throw new ExcepcionOrdenInvalido();
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
					throw new ExcepcionOutPutFileInvalido();
				}
	        }
		}
	}
	
	public boolean verificarSiArgumentosEsNumero(String cadena){
		try{
   			Integer.parseInt(cadena);
   			return true;
       	} catch (NumberFormatException nfe){
       		throw new ExcepcionNumeroInvalido();
   		}
   }
	
	public String getFormato(){
		return this.formato;
	}
	
	public String getOrden(){
		return this.orden;
	}

	public String getOutPutFile(){
		return this.outPutFile;
	}
	
}
