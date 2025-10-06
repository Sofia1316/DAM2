package EjsAccesoDirecto;

import java.io.*;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
Se tiene un programa que escribe los números de la serie de fibonacci en un
fichero binario, ese programa pide al usuario el número de números a
generar mientras los genera los escribe en un fichero binario y luego permite
recuperar el número de la serie calculado según la posición.
*/
public class ej1_fibo {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Introduce hasta qué num quieres la serie: ");
		int limite = entrada.nextInt(); 
		
		try {
			File fichero = new File("fiboEjs.dat");
			fichero.createNewFile();
			RandomAccessFile raf = new RandomAccessFile(fichero, "rw");
			
			int a = 0; // 4 bytes
			int b = 1; // 4 bytes
			int siguiente = a + b;
			
			raf.writeInt(a);
			raf.writeInt(b);
			
			for(int i = 3; i <= limite; i++) {
				raf.writeInt(siguiente);
				a = b;
				b = siguiente;
				siguiente = a + b;
			}
			
			System.out.println("Dime una posición: ");
			int posicion = entrada.nextInt();
			posicion = posicion - 1;
			raf.seek(posicion * 4);
			
			System.out.println(raf.readInt());
			raf.close();
			
		} catch(IOException e) {
			e.getStackTrace();
		}
	
	}

}
