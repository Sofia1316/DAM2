package Conexion;

import java.sql.*;

public class main {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mydb";
		String usuario = "root";
		String password = "cfgs";
		try {
			//1. cargar el drive de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Crear la conexión
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Se ha conectado a la base de datos");
			
			//3. Crear un statement
			Statement sentencia = conexion.createStatement();
			String consulta = "select * from usuario where idUSUARIO=1 or 1=1";
			ResultSet resultado = sentencia.executeQuery(consulta);
			
			// Mostrar resultado
			while(resultado.next()) {
				int idUsuario = resultado.getInt("idUSUARIO");
				String nombre = resultado.getString("Nombre");;
				Date fecha = resultado.getDate("fecha");
				String genero = resultado.getString("Género");;
				System.out.println("idUsuario: " + idUsuario + " - nombre " + nombre + " - fecha " + fecha + " - genero " + genero);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
