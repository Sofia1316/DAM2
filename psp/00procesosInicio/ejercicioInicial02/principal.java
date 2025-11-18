package ej3;

public class principal {

	public static void main(String[] args) {
		String ruta = "ipconfig";
		String [] parámetros = {"/all"};
		
		generadorProceso lanzador = new generadorProceso();
		
		lanzador.ejecutar(ruta, parámetros);
		System.out.println("Proceso ejecutado");
	}

}
