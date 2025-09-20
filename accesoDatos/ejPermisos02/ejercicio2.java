package ej2;

import java.io.FileReader;
import java.io.IOException;

public class ejercicio2 {

	public static void main(String[] args) {
		int totalChars = 0;
        int vocales = 0;
        String v = "aeiouAEIOU";

        try (FileReader fr = new FileReader("ejemplo.txt")) {
            int c;
            while ((c = fr.read()) != -1) {
                totalChars++;
                if (v.indexOf(c) != -1) {
                    vocales++;
                }
            }
            System.out.println("Total de caracteres: " + totalChars);
            System.out.println("Total de vocales: " + vocales);
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
