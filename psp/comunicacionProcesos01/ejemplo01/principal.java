package ej1;

public class principal {

	public static void main(String[] args) {
		String ruta = "notepad";
		
		generadorProceso lanzador = new generadorProceso();
		lanzador.ejecutaryDestruir(ruta);
		
		System.out.println("Proceso ejecutado");
	}

}
