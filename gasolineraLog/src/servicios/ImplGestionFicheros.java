package servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ImplGestionFicheros implements InterfazGestionFicheros {

	@Override
	public void escrituraFichero(String rutaFichero,String mensaje) {
		
		FileWriter fichero = null;
		PrintWriter pw = null;

		try {

			fichero = new FileWriter(rutaFichero,true);	
			pw = new PrintWriter(fichero);

			pw.printf("\n %s",mensaje);			
		 } catch (IOException ioe) {
			pw.println("[ERROR] - FICHERO NO ENCONTRARO: " + fichero + "\n" + ioe);
	     } finally {
	    	 try {
	    		 if (null != fichero)
	        		   fichero.close();
	          }catch (IOException ioe2){ 
	        	  pw.println("[ERROR] - ERROR AL CERRAR FICHERO: " + fichero + "\n" + ioe2);
		      }
	       }	
	}

}
