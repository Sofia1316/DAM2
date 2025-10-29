package Conexion2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class main {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/nba";
		String usuario = "root";
		String password = "cfgs";

		System.out.println("1. Imprimir jugadores por letra");
		System.out.println("2. Peso medio de los jugadores");
		System.out.println("3. Mostrar jugadores por equipo");
		System.out.println("4. Insertar un jugador");
		System.out.print("Introduce la opción que quieras: ");
		int opcion = entrada.nextInt();
		entrada.nextLine();

		switch (opcion) {
		case 1:
			ej1(url, usuario, password);
			break;
		case 2:
			ej2(url, usuario, password);
			break;
		case 3:
			ej3(url, usuario, password);
			break;
		case 4:
			ej4(url, usuario, password);
			break;
		}
		entrada.close();
	}

	public static void ej1(String url, String usuario, String password) {
		try {
			// 1. cargar el drive de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Crear la conexión
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Se ha conectado a la base de datos");

			// 3. Preparar la consulta con parámetro
			String consulta = "select * from jugadores where Nombre like ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			System.out.print("Introduce que letra quieres buscar: ");
			String respuesta = entrada.nextLine();

			// 4. Ejecutar la consulta
			sentencia.setString(1, respuesta + "%");
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultado
			while (resultado.next()) {
				int idUsuario = resultado.getInt("codigo");
				String nombre = resultado.getString("Nombre");
				;
				String Procedencia = resultado.getString("Procedencia");
				;
				String Altura = resultado.getString("Altura");
				;
				int Peso = resultado.getInt("Peso");
				String Posicion = resultado.getString("Posicion");
				;
				String Nombre_equipo = resultado.getString("Nombre_equipo");
				;
				System.out.println("ID Usuario: " + idUsuario + " | Nombre: " + nombre + " | Procedencia: "
						+ Procedencia + " | Altura: " + Altura + " | Peso: " + Peso + " | Posición: " + Posicion
						+ " | Equipo: " + Nombre_equipo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ej2(String url, String usuario, String password) {
		try {
			// 1. cargar el drive de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Crear la conexión
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Se ha conectado a la base de datos");

			// 3. Preparar la consulta con parámetro
			String consulta = "select avg(Peso) from jugadores";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// 4. Mostrar resultado
			if (resultado.next()) {
				int pesoMedio = resultado.getInt("avg(Peso)");
				System.out.printf("El peso medio de los jugadores es: " + pesoMedio);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ej3(String url, String usuario, String password) {
		try {
			// 1. cargar el drive de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Crear la conexión
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Se ha conectado a la base de datos");

			// 3. Preparar la consulta con parámetro
			String consulta = "select * from jugadores where Nombre_equipo = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			System.out.print("Introduce el equipo que quieres buscar: ");
			String respuesta = entrada.nextLine();

			// 4. Ejecutar la consulta
			sentencia.setString(1, respuesta);
			ResultSet resultado3 = sentencia.executeQuery();

			// 6. Mostrar resultados
			System.out.println("\nJUGADORES DEL EQUIPO " + respuesta);
			boolean encontrado = false;

			while (resultado3.next()) {
				encontrado = true;
				int idUsuario = resultado3.getInt("codigo");
				String nombre = resultado3.getString("Nombre");
				String procedencia = resultado3.getString("Procedencia");
				String altura = resultado3.getString("Altura");
				int peso = resultado3.getInt("Peso");
				String posicion = resultado3.getString("Posicion");
				String nombreEquipo = resultado3.getString("Nombre_equipo");

				System.out.println("ID Usuario: " + idUsuario + " | Nombre: " + nombre + " | Procedencia: "
						+ procedencia + " | Altura: " + altura + " | Peso: " + peso + " | Posición: " + posicion
						+ " | Equipo: " + nombreEquipo);
			}

			if (!encontrado) {
				System.out.println("No se encontraron jugadores para ese equipo.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ej4(String url, String usuario, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Se ha conectado a la base de datos");
	
			System.out.print("Introduce el código del jugador: ");
			int codigo = entrada.nextInt();
			entrada.nextLine(); // limpiar buffer
	
			System.out.print("Introduce el nombre del jugador: ");
			String nombre = entrada.nextLine();
	
			System.out.print("Introduce la procedencia: ");
			String procedencia = entrada.nextLine();
	
			System.out.print("Introduce la altura (ej: 2.05): ");
			String altura = entrada.nextLine();
	
			System.out.print("Introduce el peso (en kg): ");
			int peso = entrada.nextInt();
			entrada.nextLine();
	
			System.out.print("Introduce la posición: ");
			String posicion = entrada.nextLine();
	
			System.out.print("Introduce el nombre del equipo: ");
			String nombreEquipo = entrada.nextLine();
	
			// 4. Preparar la sentencia SQL
			String consulta = "INSERT INTO jugadores (codigo, Nombre, Procedencia, Altura, Peso, Posicion, Nombre_equipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
	
			// 5. Asignar valores
			sentencia.setInt(1, codigo);
			sentencia.setString(2, nombre);
			sentencia.setString(3, procedencia);
			sentencia.setString(4, altura);
			sentencia.setInt(5, peso);
			sentencia.setString(6, posicion);
			sentencia.setString(7, nombreEquipo);
	
			// 6. Ejecutar la sentencia
			int filasAfectadas = sentencia.executeUpdate();
	
			if (filasAfectadas > 0) {
				System.out.println("Jugador insertado");
			} else {
				System.out.println("No se ha podido insertar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
