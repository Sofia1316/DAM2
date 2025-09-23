package ej3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class generadorProceso{
	public void ejecutar(String ruta, String[] args) {
		List<String> nombreArgumentos = new ArrayList<>();
		
		if(ruta == null || ruta.isEmpty()) {
			System.out.println("Falta el nombre del comando");
			System.exit(1);
		}
		
		nombreArgumentos.add(ruta);
		for(int i = 0; i < args.length; i++) {
			nombreArgumentos.add(args[i]);
		}
		
		ProcessBuilder pb = new ProcessBuilder();
		pb.command(nombreArgumentos);
		// llamada a inheritIO() --> hace que el proceso herede la entrada/salida estándar del proceso padre
		// así podemos ver el resultado del comando
		pb.inheritIO();
		
		try {
			Process proceso = pb.start(); // inicio el proceso
			int codigoRetorno = proceso.waitFor(); // el código retorno no se guarda hasta que se haga el proceso
			System.out.println("$$$$$$$$$$$$$$$$");
			System.out.println("El comando devuelve: " + codigoRetorno);
			System.out.println("$$$$$$$$$$$$$$$$");
			
			if(codigoRetorno==0) {
				System.out.println("Ejecución correcta");
			} else {
				System.out.println("Ejecución con errores");
			}
		} catch(IOException e) {
			System.out.println("Error durante la ejecución del comando");
			System.out.println("INFORMACIÓN ADICIONAL");
			e.printStackTrace();
			System.exit(2);
		}
		catch(InterruptedException e) {
			System.err.println("Proceso interrumpido");
			System.exit(3);
		}
	}
}
