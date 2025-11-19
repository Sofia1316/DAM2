package Traductor_dividido;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Operaciones {
	
	static Scanner entrada = new Scanner(System.in);
	
	public static String traducir(String ingles) throws IOException {		
		String web = "https://www.spanishdict.com/translate/" + ingles;
		Document document = Jsoup.connect(web).get(); // el document es el de nodes
		Element palabra = document.select("div#quickdef1-en a.tCur1iYh").get(0);
		String resultado = palabra.html().toUpperCase();
	
		return resultado;
	}
}
