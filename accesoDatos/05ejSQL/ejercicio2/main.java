package Conexion2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/nba";
		String usuario = "root";
		String password = "cfgs";

		boolean bandera = true;

		while (bandera) {
			System.out.println("\n --- MENU DE JUGADORES NBA --- ");
			System.out.println("1. Imprimir jugadores por letra");
			System.out.println("2. Peso medio de los jugadores");
			System.out.println("3. Mostrar jugadores por equipo");
			System.out.println("4. Insertar un jugador");
			System.out.println("5. Borrar jugadores");
			System.out.println("6. Fichar jugador a equipo");
			System.out.println("7. Insertar un partido");
			System.out.println("8. Estadísticas de jugadores");
			System.out.println("9. Salir del programa");
			System.out.print("Introduce la opción que quieras: ");
			int opcion = entrada.nextInt();
			entrada.nextLine();

			try (Connection conex = conexion_bbdd(url, usuario, password)) {
				switch (opcion) {
					case 1:
						ej1(conex);
						break;
					case 2:
						ej2(conex);
						break;
					case 3:
						ej3(conex);
						break;
					case 4:
						ej4(conex);
						break;
					case 5:
						ej5(conex);
						break;
					case 6:
						ej6(conex);
						break;
					case 7:
						ej7(conex);
						break;
					case 8:
						ej8(conex);
						break;
					case 9:
						System.out.println("Saliendo del programa...");
						bandera = false;
						break;
					default:
						System.out.println("Opción no válida");
				}
			} catch (SQLException | ClassNotFoundException e) {
				e.getMessage();
			}
		}
		entrada.close();
	}

	public static Connection conexion_bbdd(String url, String usuario, String password)
			throws SQLException, ClassNotFoundException {
		// 1. cargar el drive de la BD
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2. Crear la conexión
		Connection conexion = DriverManager.getConnection(url, usuario, password);
		System.out.println("Se ha conectado a la base de datos");

		return conexion;
	}

	public static void ej1(Connection conexion_bbdd) {
		try {

			// 3. Preparar la consulta con parámetro
			String consulta = "select * from jugadores where Nombre like ?";
			PreparedStatement sentencia = conexion_bbdd.prepareStatement(consulta);

			System.out.print("Introduce que letra quieres buscar: ");
			String respuesta = entrada.nextLine();

			// 4. Ejecutar la consulta
			sentencia.setString(1, respuesta + "%");
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultado
			while (resultado.next()) {
				int idUsuario = resultado.getInt("codigo");
				String nombre = resultado.getString("Nombre");
				String Procedencia = resultado.getString("Procedencia");
				String Altura = resultado.getString("Altura");
				int Peso = resultado.getInt("Peso");
				String Posicion = resultado.getString("Posicion");
				String Nombre_equipo = resultado.getString("Nombre_equipo");
				System.out.println("ID Usuario: " + idUsuario + " | Nombre: " + nombre + " | Procedencia: "
						+ Procedencia + " | Altura: " + Altura + " | Peso: " + Peso + " | Posición: " + Posicion
						+ " | Equipo: " + Nombre_equipo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * OPCIÓN 1 public static void ej2(String url, String usuario, String password)
	 * { try { // 1. cargar el drive de la BD
	 * Class.forName("com.mysql.cj.jdbc.Driver");
	 * 
	 * // 2. Crear la conexión Connection conexion =
	 * DriverManager.getConnection(url, usuario, password);
	 * System.out.println("Se ha conectado a la base de datos");
	 * 
	 * // 3. Preparar la consulta con parámetro String consulta =
	 * "select avg(Peso) from jugadores"; PreparedStatement sentencia =
	 * conexion.prepareStatement(consulta); ResultSet resultado =
	 * sentencia.executeQuery();
	 * 
	 * // 4. Mostrar resultado if (resultado.next()) { int pesoMedio =
	 * resultado.getInt("avg(Peso)");
	 * System.out.printf("El peso medio de los jugadores es: " + pesoMedio); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

	// OPCIÓN 2
	public static void ej2(Connection conexion_bbdd) {
		try {

			// 3. Preparar la consulta con parámetro
			String consulta = "select codigo from jugadores order by codigo desc limit 1";
			PreparedStatement sentencia = conexion_bbdd.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// 4. Mostrar resultado
			while (resultado.next()) {
				int idJugador = resultado.getInt("avg(Peso)");
				System.out.printf("El peso medio de los jugadores es: " + idJugador);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ej3(Connection conexion_bbdd) {
		try {

			// 3. Preparar la consulta con parámetro
			String consulta = "select * from jugadores where Nombre_equipo = ?";
			PreparedStatement sentencia = conexion_bbdd.prepareStatement(consulta);

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

	public static void ej4(Connection conexion_bbdd) {
		try {

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
			PreparedStatement sentencia = conexion_bbdd.prepareStatement(consulta);

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

	public static void ej5(Connection conexion_bbdd) {
		try {
			int lineas = 0;

			System.out.print("Introduce el id del jugador a eliminar: ");
			int respuesta = entrada.nextInt();

			// Como no hay borrado en cascada en la propia bbdd, lo borramos a mano
			String consultaManual = "select * from estadisticas where jugador = ?";
			PreparedStatement sentencia1 = conexion_bbdd.prepareStatement(consultaManual);
			sentencia1.setInt(1, respuesta);

			if (sentencia1.execute()) {
				String consultaBorradoEstadisticas = "delete from estadisticas where jugador = ?";
				PreparedStatement sentencia2 = conexion_bbdd.prepareStatement(consultaBorradoEstadisticas);
				sentencia2.setInt(1, respuesta);
				lineas = sentencia2.executeUpdate();
				sentencia2.close();
			}

			// 3. Preparar la consulta con parámetro
			String consulta3 = "delete from jugadores where codigo = ?";
			PreparedStatement sentencia3 = conexion_bbdd.prepareStatement(consulta3);
			sentencia3.setInt(1, respuesta);
			int filas = sentencia3.executeUpdate();
			sentencia3.close();

			if (filas > 0) {
				System.out.println("Jugador eliminado");
			} else {
				System.out.println("No existe un jugador con ese código");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ej6(Connection conexion_bbdd) {
		try {
			System.out.print("Introduce el código del jugador que quieres fichar: ");
			int codJugador = entrada.nextInt();
			entrada.nextLine();

			System.out.print("Introduce el nombre del nuevo equipo: ");
			String nuevoEquipo = entrada.nextLine();

			// 1. Comprobar que el jugador existe
			String consultaJugador = "select * from jugadores where codigo = ?";
			PreparedStatement stJugador = conexion_bbdd.prepareStatement(consultaJugador);
			stJugador.setInt(1, codJugador);
			ResultSet rsJugador = stJugador.executeQuery();

			if (!rsJugador.next()) {
				System.out.println("No existe un jugador con ese código");
				return;
			}

			// 2. Comprobar que el equipo existe
			String consultaEquipo = "select * from equipos where Nombre = ?";
			PreparedStatement stEquipo = conexion_bbdd.prepareStatement(consultaEquipo);
			stEquipo.setString(1, nuevoEquipo);
			ResultSet rsEquipo = stEquipo.executeQuery();

			if (!rsEquipo.next()) {
				System.out.println("El equipo indicado no existe.");
				return;
			}

			// 3. Actualizar el equipo del jugador
			String consultaUpdate = "update jugadores set Nombre_equipo = ? where codigo = ?";
			PreparedStatement stUpdate = conexion_bbdd.prepareStatement(consultaUpdate);
			stUpdate.setString(1, nuevoEquipo);
			stUpdate.setInt(2, codJugador);

			int filas = stUpdate.executeUpdate();

			if (filas > 0) {
				System.out.println("Jugador fichado en " + nuevoEquipo);
			} else {
				System.out.println("Error al fichar el jugador");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void ej7(Connection conexion_bbdd) {
		try {
			System.out.print("Introduce el código del partido: ");
			int codPartido = entrada.nextInt();
			entrada.nextLine();

			System.out.print("Introduce el equipo local: ");
			String local = entrada.nextLine();

			System.out.print("Introduce el equipo visitante: ");
			String visitante = entrada.nextLine();

			System.out.print("Introduce los puntos del equipo local: ");
			int puntosLocal = entrada.nextInt();

			System.out.print("Introduce los puntos del equipo visitante: ");
			int puntosVisitante = entrada.nextInt();
			entrada.nextLine();

			System.out.print("Introduce la temporada (ej: 2020-2021): ");
			String temporada = entrada.nextLine();

			// 1. Comprobar que no existe el partido
			String consultaExiste = "select * from partidos where codigo = ?";
			PreparedStatement stExiste = conexion_bbdd.prepareStatement(consultaExiste);
			stExiste.setInt(1, codPartido);
			ResultSet rsExiste = stExiste.executeQuery();

			if (rsExiste.next()) {
				System.out.println("Ya existe un partido con ese código.");
				return;
			}

			// 2. Comprobar equipos
			String consultaEquipo = "select * from equipos where Nombre = ?";
			PreparedStatement stLocal = conexion_bbdd.prepareStatement(consultaEquipo);
			stLocal.setString(1, local);
			ResultSet rsLocal = stLocal.executeQuery();

			PreparedStatement stVisit = conexion_bbdd.prepareStatement(consultaEquipo);
			stVisit.setString(1, visitante);
			ResultSet rsVisit = stVisit.executeQuery();

			if (!rsLocal.next() || !rsVisit.next()) {
				System.out.println("Uno de los equipos no existe.");
				return;
			}

			// 3. Insertar partido
			String consultaInsert = "insert into partidos (codigo, equipo_local, equipo_visitante, puntos_local, puntos_visitante, temporada) "
					+ "values (?, ?, ?, ?, ?, ?)";

			PreparedStatement stInsert = conexion_bbdd.prepareStatement(consultaInsert);
			stInsert.setInt(1, codPartido);
			stInsert.setString(2, local);
			stInsert.setString(3, visitante);
			stInsert.setInt(4, puntosLocal);
			stInsert.setInt(5, puntosVisitante);
			stInsert.setString(6, temporada);

			int filas = stInsert.executeUpdate();

			if (filas > 0) {
				System.out.println("Partido insertado correctamente.");
			} else {
				System.out.println("No se pudo insertar el partido.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void ej8(Connection conexion_bbdd) {
		try {
			System.out.print("Introduce el código del jugador: ");
			int codJugador = entrada.nextInt();
			entrada.nextLine();

			System.out.print("Introduce la temporada que quieres consultar: ");
			String temporada = entrada.nextLine();

			// 1. Consultar estadísticas
			String consulta = "select * from estadisticas where jugador = ? and temporada = ?";
			PreparedStatement st = conexion_bbdd.prepareStatement(consulta);
			st.setInt(1, codJugador);
			st.setString(2, temporada);

			ResultSet rs = st.executeQuery();

			if (!rs.next()) {
				System.out.println("Este jugador no tiene estadísticas en esa temporada.");
				return;
			}

			// 2. Mostrar datos
			System.out.println("\n--- ESTADÍSTICAS DEL JUGADOR " + codJugador + " (" + temporada + ") ---");
			System.out.println("Puntos por partido: " + rs.getDouble("Puntos_por_partido"));
			System.out.println("Asistencias: " + rs.getDouble("Asistencias"));
			System.out.println("Tapones: " + rs.getDouble("Tapones"));
			System.out.println("Rebotes: " + rs.getDouble("Rebotes"));
			System.out.println("Minutos jugados: " + rs.getDouble("Minutos"));
			System.out.println("Partidos jugados: " + rs.getInt("Partidos_jugados"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
