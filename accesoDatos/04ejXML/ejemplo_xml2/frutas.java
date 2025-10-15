package ejemplo_xml2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class frutas {

	public static void main(String[] args) {
		try {
			File ficheroXML = new File("frutas.xml");
			
			// crear el documento como en memoria caché
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			
			// pasear el documento, creando un fichero temporal y ahí haré mi instancia xml
			Document doc = docBuilder.parse(ficheroXML);
			
			// esto normaliza el documento eliminando los saltos de línea y espacios en blanco
			doc.getDocumentElement().normalize();
			
			NodeList lista = doc.getElementsByTagName("fruta"); // ponemos el mismo nombre que viene en el xml
			int cantidad = lista.getLength();
			
			//int[] precios = null;
			
			// recorrer la lista de nodos
			for(int i = 0; i < cantidad; i++) {
				Node nodo = lista.item(i);
				
				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element fruta = (Element) nodo;
					String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
					String tipo = fruta.getElementsByTagName("tipo").item(0).getTextContent();
					String color = fruta.getElementsByTagName("color").item(0).getTextContent();
					String origen = fruta.getElementsByTagName("origen").item(0).getTextContent();
					String precio = fruta.getElementsByTagName("precio").item(0).getTextContent();
					int precioCast = Integer.parseInt(precio);
					String temporada = fruta.getElementsByTagName("temporada").item(0).getTextContent();
					String nutrientes = fruta.getElementsByTagName("nutrientes").item(0).getTextContent();
					
					System.out.println("Nombre: " + nombre);
					System.out.println("Tipo: " + tipo);
					System.out.println("Color: " + color);
					System.out.println("Origen: " + origen);
					System.out.println("Precio: " + precio);
					System.out.println("Temporada: " + temporada);
					System.out.println("Nutrientes: " + nutrientes);
					
					//precios[i] = precioCast;
				}
				
				/*
				for(int j = 0; j < cantidad; j++) {
					if(precios[j] < precios[j+1]) {
						precios[j] = precios[1];
						System.out.println("Orden de precios: ");
					}
				}*/
			}
		} catch(Exception e) {
			e.getStackTrace();
		}

	}

}
