package ej1;

public class principal {

	public static void main(String[] args) {
		String ruta = "C:/Windows/System32/WindowsPowerShell/v1.0";
		String nombre = "powershell.exe";
		
		generadorProceso lanzador = new generadorProceso();
		//lanzador.ejecutar(ruta, nombre);
		
		System.out.println("Proceso ejecutado");
	}

}
