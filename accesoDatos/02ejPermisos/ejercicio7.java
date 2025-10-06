package ej2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio7 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		try (FileWriter fw = new FileWriter("registroDeUsuario.txt")) {
            while (true) {
                System.out.print("Introduce una frase: ");
                String frase = entrada.nextLine();
                if (frase.equalsIgnoreCase("fin")) break;
                fw.write(frase + "\n");
            }
            System.out.println("Archivo creado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        entrada.close();

	}

}
