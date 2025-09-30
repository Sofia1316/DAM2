package ej1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class generadorProceso {
	public void ejecutar(String ruta, String rutaDirectorio, String nombreEjecutable) {
		//List <String> nombreArgumentos = new ArrayList<>();
		File directorio = new File(rutaDirectorio);
		File ejecutable = new File(directorio, nombreEjecutable);
		
		ProcessBuilder pb/*clase para construir el proceso*/ = new ProcessBuilder(ejecutable.getAbsolutePath());
		
		// comand nombre del ejecutable
		//pb.command(nombreEjecutable);
		// nombre del directorio donde se encuentra
		pb.directory(directorio);
		
		try { // meter parte del código que debe de ir bien
			//Process proceso = pb.start(); // de aquí se obtiene el proceso
			pb.start();
		} catch(Exception e) {
			e.printStackTrace(); // si hay algún error, te saca la info (traza)
		}
	}
}
