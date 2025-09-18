package centroSoft;

import java.util.Scanner;

public class centro {

	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		
		Administración admin1 = new Administración(12345678, "Pepe", "ap1", 1000, "ade", 5);
		Administración admin2 = new Administración(987654321, "Pepa", "ap2", 5000, "derecho", 14);
		
		Directivo direct1 = new Directivo(123456789, "Carlos", "Alonso", 1500, false, false);
		Directivo direct2 = new Directivo(987654321, "Carla", "Flores", 3000, true, true);
		
		Profesor prof1 = new Profesor(12345, "Javier", "Masegosa", 40000, 3, true);
		Profesor prof2 = new Profesor(456789, "Julia", "Garrido", 2000, 4, false);
		
		Modulo mod1 = new Modulo("BBDD", 20, prof2, false);
		Modulo mod2 = new Modulo("Nubles", 2, prof1, true);
		
		Alumno alum1 = new Alumno(123, "Carl", "Grimes", "10/10/2000", true, false, mod2);
		Alumno alum2 = new Alumno(456, "Daryl", "Dixon", "13/07/1990", true, true, mod1);
		
		Profesor[] prof = {prof1, prof2};
		Administración[] admin = {admin1, admin2};
		Directivo[] direct = {direct1, direct2};
		Modulo[] modul = {mod1, mod2};
		Alumno[] alum = {alum1, alum2};
		
		System.out.println("PROFESORES");
		for(Profesor Profesor: prof) {
			System.out.println(Profesor.toString());
		}
		
		System.out.println("ADMINS");
		for(Administración Administración : admin) {
			System.out.println(Administración.toString());
		}
		
		System.out.println("DIRECTIVOS");
		for(Directivo Directivo : direct) {
			System.out.println(Directivo.toString());
		}
		
		System.out.println("MÓDULOS");
		for(Modulo Modulo : modul) {
			System.out.println(Modulo.toString());
		}
		
		System.out.println("ALUMNOS");
		for(Alumno Alumno : alum) {
			System.out.println(Alumno.toString());
		}

		entrada.close();
	}

}
