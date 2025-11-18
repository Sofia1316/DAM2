package ej4;

public class principal {

	public static void main(String[] args) {
		String app = "cmd";
		String[] ruta = {"/c", "dir", "/p"};
		generadorProceso lanzador = new generadorProceso();
		lanzador.ejecutar(app, ruta);
		System.out.println("realizado");
	}

}
