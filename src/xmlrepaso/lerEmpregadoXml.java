package xmlrepaso;
import java.io.File;

import javax.xml.parsers.*;

import org.w3c.dom.*;


public class lerEmpregadoXml {
	public static void main(String[] args){
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse("empregados.xml");
			doc.getDocumentElement().normalize();
			System.out.println("Elemento Raiz: "+ doc.getDocumentElement().getNodeName());
			//Lista de nodos empleado
			NodeList n1=doc.getElementsByTagName("empleado");
			for(int i=0;i<n1.getLength();i++){
				Node empleado= n1.item(i);//obtenemos un nodo empleado
				if(empleado.getNodeType()==Node.ELEMENT_NODE){//comprobamos si es del tipo elemeto
					Element elemento = (Element) empleado;
					Element eid = (Element)elemento.getElementsByTagName("id").item(0);
					Element eap = (Element)elemento.getElementsByTagName("apelido").item(0);
					Element edp = (Element)elemento.getElementsByTagName("dep").item(0);
					Element esa = (Element)elemento.getElementsByTagName("salario").item(0);
					Text textoId = (Text)eid.getChildNodes().item(0);
					Text textoAp = (Text)eap.getChildNodes().item(0);
					Text textoDp = (Text) edp.getChildNodes().item(0);
					Text textoSa = (Text) esa.getChildNodes().item(0);
					//System.out.println(textoId);
					System.out.println("Empregado: "+"id: "+textoId.getNodeValue()+", Apelido: "+ textoAp.getNodeValue()+ ", Departamento: "+textoDp.getNodeValue()+ " ,Salario: "+textoSa.getNodeValue());
					//System.out.println("Empleado: "+ eid.getTextContent());
				}//End if
			}//End for

		}catch (Exception ex){
			System.out.println("No se puede encontrar el archivo");
		}
	}//main
}//class
