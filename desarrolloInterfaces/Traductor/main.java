package Traductor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class main {

	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		/* OPCIÓN MANUAL
		URL direccion = new URL("https://www.spanishdict.com/translate/alfombra");
	
		String palabraTraducida;
		
		String html = obtenerHTML(direccion);
		System.out.println(html);
		
		palabraTraducida = cortarHtml(html);*/
		
		// OPCIÓN CON LIBRERÍA JSOUP
		System.out.print("Introduce una palabra en inglés: ");
		String ingles = entrada.nextLine();
		
		String web = "https://www.spanishdict.com/translate/" + ingles;
		Document document = Jsoup.connect(web).get(); // el document es el de nodes
		Element palabra = document.select("div#quickdef1-en a.tCur1iYh").get(0);
		String resultado = palabra.html().toUpperCase();
		System.out.println(resultado);
		
	}

/*
	private static String obtenerHTML(URL direccion) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(direccion.openStream())); // para hacer una lectura del html del URL
		String inputLine, codigo = "";
		
		while((inputLine=in.readLine()) != null) {
			codigo+=inputLine; // te guardas todo el html en codigo
		}
		in.close();
		return codigo;
	}

	private static String cortarHtml(String html) {
		int inicio, puntoFinal1, puntoFinal2;
		inicio = html.indexOf("?langFrom=en\" class=\"tCur1iYh\">"); //34 caracteres en total
		
		// OPCIÓN 1; crear una subcadena y buscar desde ahí
		String trozo = html.substring(inicio);
		puntoFinal1 = strozo.indexOf("</a>");
		
		// OPCIÓN 2; buscar en la misma cadena pero desde el punto anteriormente calculado
		puntoFinal2 = html.indexOf("</a>", inicio);
		
		String result1 = html.substring(inicio+31, inicio+puntoFinal1);
		String result2 = html.substring(inicio+31, inicio+puntoFinal2);
		
		return result2;
	}
*/
}
