package ejercicios00;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ej1ap4 {
	static Scanner entrada = new Scanner(System.in);
	
	public static void visualizar(ArrayList<String> palabra, ArrayList<Integer> veces) {
		int i = 0;
		while(i<palabra.size()) {
			System.out.println(palabra.get(i) + ": " + veces.get(i));
			i++;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> palabra = new ArrayList<>();
		ArrayList<Integer> veces = new ArrayList<>();
		
		try(BufferedReader ficheroFrutas = new BufferedReader(new FileReader("C:/Users/DAM/eclipse-workspace/AccesoADatos/txt/frutas.txt"))){
			String linea;
			while((linea=ficheroFrutas.readLine()) != null) {
				// en cada linea tenemos una palabra, igualar todas las palabras
				String fruta = linea.trim().toLowerCase();
				
				// si existe no devuelve la posición si no -1
				int indice = palabra.indexOf(fruta);
				
				if(indice == -1) {
					// primera vez que encuentro una palabra
					palabra.add(fruta);
					veces.add(1);
				} else {
					// palabra está en el array e incremento las veces 
					int cantidad = veces.get(indice)+1;
					veces.set(indice, cantidad);
				}
				
			}
			visualizar(palabra,veces);
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
