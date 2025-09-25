package ej1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class generarProceso {
	public void ejecutar(String ruta) {
		Runtime rt = Runtime.getRuntime();
		Process proceso = null;
		String line;
		
		try {
			proceso = rt.exec(ruta); // el hijo y hago la comunicación con proceso
			/*la cinta es el bufferReader y el input es como meter los datos de entrada*/
			BufferedReader br =  new BufferedReader(new InputStreamReader(proceso.getInputStream()));
		
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		if(proceso != null) {
			proceso.destroy();
		}
				
		try {
			proceso.waitFor();
		} catch(InterruptedException e) {
			System.exit(-1);
		}
		System.exit(0);
	}
}
