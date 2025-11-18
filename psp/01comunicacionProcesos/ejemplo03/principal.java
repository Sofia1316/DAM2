package ej3;

public class principal {

	public static void main(String[] args) {
		String ruta = "C:\\Users\\DAM\\Desktop\\hola.txt";
		String exe = "notepad";
		generadorProceso lanzador = new generadorProceso();
		lanzador.ejecutaryDestruir(ruta, exe);
		
		System.out.println("Proceso ejecutado");
	}

}
