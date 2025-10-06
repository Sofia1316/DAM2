package ejerciciosCasa00;

import java.io.*;

public class ej3 {
	public static void main(String[] args) {
		String ruta = "C:\\Users\\DAM\\eclipse-workspace\\AccesoADatos\\txt\\Restaurants.csv";
		
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
            String linea = br.readLine();
            String[] cabeceras = linea.split(",");

            // Leemos el resto del fichero
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");

                // Emparejamos campo:valor
                for (int i = 0; i < cabeceras.length && i < valores.length; i++) {
                    System.out.println(cabeceras[i] + ": " + valores[i]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
