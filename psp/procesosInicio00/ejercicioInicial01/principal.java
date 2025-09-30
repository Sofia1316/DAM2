package ej2;

public class principal {

	public static void main(String[] args) {
		String ruta = "ipconfig";
		
		generadorProceso lanzador = new generadorProceso();
		
		lanzador.ejecutar(ruta);
		System.out.println("Proceso ejecutado");
	}

}
