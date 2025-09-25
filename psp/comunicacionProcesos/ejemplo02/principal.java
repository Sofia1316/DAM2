package ej1;

public class principal {

	public static void main(String[] args) {
		String ruta = "ping " + "google.es";
		generarProceso lanzador = new generarProceso();
		lanzador.ejecutar(ruta);
		System.out.println("realizado");
	}

}
