package ej1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class generadorProceso {
	public void ejecutaryDestruir(String ruta) {
		Process proceso = null;
		ProcessBuilder pb = new ProcessBuilder(ruta);
		
		try {
			proceso = pb.start();
			System.out.println("Se ha lanzado el proceso");
			System.out.println("El proceso padre esperará a que el hijo termine");
		} catch(IOException e) {
			e.getMessage();
		}
		
		try {
			proceso.waitFor();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(proceso.exitValue());
		} catch(IllegalThreadStateException e) {
			System.out.println(e);
		}
		
		if(proceso != null) {
			proceso.destroy();
			System.out.println("Se ha destruido");
		}
		
	}
}
