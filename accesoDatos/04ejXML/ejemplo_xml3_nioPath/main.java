package ejemplo_nio_path;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

public class main {
	// lectura con la clase files de java.nio
	public static void LeerFiles() {
		// los parámetros pueden ser la URL o la ruta
		Path ruta = Paths.get("planetas.txt");
		try {
			// Leo todo el contenido del fichero
			System.out.println("TODO EL CONTENIDO");
			String contenido = Files.readString(ruta);
			System.out.println(contenido);
			
			// Para leer línea por línea
			System.out.println("LINEA POR LINEA");
			List <String> listaContenido = Files.readAllLines(ruta);
			for(String linea : listaContenido) {
				System.out.println(linea);
			}
		} catch(IOException e) {
			e.getMessage();
		}
	}
	
	// escritura con la clase files de java.nio
	public static void EscribirFiles() {
		Path ruta = Paths.get("FicheroEscritura.txt");
		try {
			String contenido = "Holap ";
			Files.write(ruta, contenido.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND); // no se puede escribir directamente, hay que escribir los bytes
		} catch(IOException e) {
			e.getMessage();
		}
	}
	
	// copiar un archivo en otro
	public static void CopiarFiles() {
		Path rutaOrigen = Paths.get("FicheroEscritura.txt");
		Path rutaDestino = Paths.get("FicheroCopia.txt");
		
		try {
			Files.copy(rutaOrigen, rutaDestino, StandardCopyOption.REPLACE_EXISTING);
		} catch(IOException e) {
			e.getMessage();
		}
	}
	
	// listar los archivos en general
	public static void listarContenidos() {
		// path.of = path.get
		Path directorio = Path.of(".");
		try {
			Stream <Path> flujo = Files.list(directorio);
			flujo.forEach(archivo -> System.out.println(archivo.getFileName()));
		} catch(IOException e) {
			e.getMessage();
		}
	}
	
	// lee las propiedades de un archivo
	public static void PropiedadesFichero() {
		Path ruta = Path.of("primos.txt");
		System.out.println("Fichero existe: " + Files.exists(ruta));
		System.out.println("Fichero es directorio: " + Files.isDirectory(ruta));
	}
	
	// borrar un fichero
	public static void BorrarFichero() {
		Path ruta = Path.of("primos.txt");
		try {
			Files.deleteIfExists(ruta);
		} catch(IOException e) {
			e.getMessage();
		}
	}
	
	public static void main(String[] args) {
		LeerFiles();
		EscribirFiles();
		CopiarFiles();
		listarContenidos();
		PropiedadesFichero();
		BorrarFichero();
	}

}
