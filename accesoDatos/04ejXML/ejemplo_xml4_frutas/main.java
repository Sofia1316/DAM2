package ejemplo_xml3;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class main {
	
	public static int posicion(double precio, ArrayList<Fruta> Frutas) {
		int posicion = -1;
		double valorAnterior = 0;
		
		for(int i = 0; i < Frutas.size(); i++) {
			if(Frutas.get(i).getPrecio() == precio) {
				posicion = i;
			} else {
				if(valorAnterior > Frutas.get(i).getPrecio()) {
					posicion = i - 1;
				}
			}
			valorAnterior = Frutas.get(i).getPrecio();
		}
		
		return posicion;
	}

	public static void main(String[] args) {
		ArrayList <Fruta> listaFrutas = new ArrayList<>();
		try {
			File ficheroXML = new File("frutas.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docB = dbf.newDocumentBuilder();
			
			Document doc = docB.parse(ficheroXML);
			doc.getDocumentElement().normalize();
			
			NodeList lista = doc.getElementsByTagName("fruta");
			int longuitud = lista.getLength();
			
			for(int i = 0; i < longuitud; i++) {
				Node nodo = lista.item(i);
				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element fruta = (Element) nodo;
					ArrayList<String> nutrientes = new ArrayList<>(); 
					Fruta piezafruta = new Fruta(
							fruta.getElementsByTagName("nombre").item(0).getTextContent(),
							fruta.getElementsByTagName("tipo").item(0).getTextContent(),
							fruta.getElementsByTagName("color").item(0).getTextContent(),
							fruta.getElementsByTagName("origen").item(0).getTextContent(),
							fruta.getElementsByTagName("temporada").item(0).getTextContent(),
							Double.valueOf(fruta.getElementsByTagName("precio").item(0).getTextContent())
						);
					NodeList listaNutrientes = fruta.getElementsByTagName("nutriente");
					for(int j = 0; j < listaNutrientes.getLength(); j++) {
						nutrientes.add(listaNutrientes.item(j).getTextContent());
						listaFrutas.add(piezafruta);
					}
					piezafruta.setNutrientes(nutrientes);
				}
				// indicar el campo de la clase
				listaFrutas.sort(Comparator.comparing(Fruta::getPrecio));
			}
			for(Fruta elemento: listaFrutas) {
				System.out.println(elemento.toString());
				ArrayList <String> nutrientes = elemento.getNutrientes();
				for(String nutriente : nutrientes) {
					System.out.println(nutriente);
				}
			}
		} catch(Exception e) {
			e.getMessage();
		}
	}

}
