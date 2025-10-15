package ejemplo_xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class main {

	public static void main(String[] args) {
		try {
			File ficheroXML = new File("persona.xml");
			
			// crear el documento como en memoria caché
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			
			// pasear el documento, creando un fichero temporal y ahí haré mi instancia xml
			Document doc = docBuilder.parse(ficheroXML);
			
			// esto normaliza el documento eliminando los saltos de línea y espacios en blanco
			doc.getDocumentElement().normalize();
			
			NodeList lista = doc.getElementsByTagName("persona");
			int cantidad = lista.getLength();
			
			// recorrer la lista de nodos
			for(int i = 0; i < cantidad; i++) {
				Node nodo = lista.item(i);
				
				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element persona = (Element) nodo;
					String nombre = persona.getElementsByTagName("nombre").item(0).getTextContent();
					String edad = persona.getElementsByTagName("edad").item(0).getTextContent();
					String ciudad = persona.getElementsByTagName("ciudad").item(0).getTextContent();
					
					System.out.println("La persona " + nombre + " con edad " + edad + " es de " + ciudad);
				}
			}
		} catch(Exception e) {
			e.getStackTrace();
		}

	}

}
