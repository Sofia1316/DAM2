package LopezdelSastreSofia;

import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class frutas {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			File ficheroXML = new File("frutas.xml"); 
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			Document doc = docBuilder.parse(ficheroXML);
			doc.getDocumentElement().normalize();

			NodeList lista = doc.getElementsByTagName("fruta");
			int cantidad = lista.getLength();

			int opcion;
			do {
				System.out.println("1. Filtrar por precio");
				System.out.println("2. Filtrar por nutriente");
				System.out.println("3. Enseñar todo");
				System.out.println("0. Salir");
				System.out.print("Elige una opción: ");
				opcion = entrada.nextInt();
				entrada.nextLine(); 

				switch (opcion) {
					case 1:
						System.out.print("Introduce un precio tope (por ejemplo 12,0): ");
						double tope = entrada.nextDouble();
						entrada.nextLine();
						System.out.print("En que orden lo quieres ver (mayor, menor o igual): ");
						String orden = entrada.nextLine();
	
						for (int i = 0; i < cantidad; i++) {
							Node nodo = lista.item(i);
	
							if (nodo.getNodeType() == Node.ELEMENT_NODE) {
								Element fruta = (Element) nodo;
								String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
								String tipo = fruta.getElementsByTagName("tipo").item(0).getTextContent();
								String color = fruta.getElementsByTagName("color").item(0).getTextContent();
								String origen = fruta.getElementsByTagName("origen").item(0).getTextContent();
								double precio = Double.parseDouble(fruta.getElementsByTagName("precio").item(0).getTextContent());
								String temporada = fruta.getElementsByTagName("temporada").item(0).getTextContent();
								String nutrientes = fruta.getElementsByTagName("nutrientes").item(0).getTextContent();
	
								boolean mostrar = false; // marcamos el marcador en false
								switch (orden) {
								case "mayor":
									mostrar = precio > tope; // ponemos como true ene l caso de que sea el precio mayor al tope
									break;
								case "menor":
									mostrar = precio < tope;
									break;
								case "igual":
									mostrar = precio == tope;
									break;
								default:
									System.out.println("no válido");
								}
								mostrarFruta(nombre, tipo, color, origen, precio, temporada, nutrientes);
							}
						}
						break;
	
					case 2: 
						System.out.print("Introduce un nutriente a buscar: ");
						String nb= entrada.nextLine();
	
						for (int i = 0; i < cantidad; i++) {
							Node nodo = lista.item(i);
	
							if (nodo.getNodeType() == Node.ELEMENT_NODE) {
								Element fruta = (Element) nodo;
								String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
								String tipo = fruta.getElementsByTagName("tipo").item(0).getTextContent();
								String color = fruta.getElementsByTagName("color").item(0).getTextContent();
								String origen = fruta.getElementsByTagName("origen").item(0).getTextContent();
								double precio = Double.parseDouble(fruta.getElementsByTagName("precio").item(0).getTextContent());
								String temporada = fruta.getElementsByTagName("temporada").item(0).getTextContent();
								String nutrientes = fruta.getElementsByTagName("nutrientes").item(0).getTextContent();
	
								if (nutrientes.contains(nb)) {
									mostrarFruta(nombre, tipo, color, origen, precio, temporada, nutrientes);
								}
							}
						}
					break;
					case 3: 
						for (int i = 0; i < cantidad; i++) {
							Node nodo = lista.item(i);
							if (nodo.getNodeType() == Node.ELEMENT_NODE) {
								Element fruta = (Element) nodo;
								String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
								String tipo = fruta.getElementsByTagName("tipo").item(0).getTextContent();
								String color = fruta.getElementsByTagName("color").item(0).getTextContent();
								String origen = fruta.getElementsByTagName("origen").item(0).getTextContent();
								double precio = Double.parseDouble(fruta.getElementsByTagName("precio").item(0).getTextContent());
								String temporada = fruta.getElementsByTagName("temporada").item(0).getTextContent();
								String nutrientes = fruta.getElementsByTagName("nutrientes").item(0).getTextContent();
	
								mostrarFruta(nombre, tipo, color, origen, precio, temporada, nutrientes);
							}
						}
					break;
					default:
						System.out.println("Saliendo");
				}
			} while (opcion != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mostrarFruta(String nombre, String tipo, String color, String origen, double precio, String temporada, String nutrientes) {
		System.out.println("Nombre: " + nombre);
		System.out.println("Tipo: " + tipo);
		System.out.println("Color: " + color);
		System.out.println("Origen: " + origen);
		System.out.println("Precio: " + precio);
		System.out.println("Temporada: " + temporada);
		System.out.println("Nutrientes: " + nutrientes);
	}
}
