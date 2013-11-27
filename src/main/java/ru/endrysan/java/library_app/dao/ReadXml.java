package ru.endrysan.java.library_app.dao;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXml {
    
    private static final String fileXML = "location.xml";
    private static String returnloc;
    private static boolean returncache;
    /*
    private static void printDom(Node node) {
        
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            for (int i = 0 ; i < attributes.getLength(); i++) {
                Node attr = attributes.item(i);
                System.out.println("attr = \"" + attr.getNodeName()  + "\"" +
                        " value = \"" + attr.getTextContent().toString() + "\" ");
                
                if (attr.getNodeName().equals("users")) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!" + attr.getNodeValue());
                }
                
            }
        }

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(children.item(i));
        }
    }
    */
    public static String returnLocation(String entity, Node node) {
        
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            for (int i = 0 ; i < attributes.getLength(); i++) {
                Node attr = attributes.item(i);
                if (attr.getNodeName().equals(entity)) {
                    returnloc = attr.getNodeValue();
                }
                
            }
        }

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            returnLocation(entity, children.item(i));
        }
        return returnloc;
    }
    public static boolean returnCache(Node node) {
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            for (int i = 0 ; i < attributes.getLength(); i++) {
                Node attr = attributes.item(i);
                if (attr.getNodeName().equals("useCache")) {
                    returncache = Boolean.parseBoolean(attr.getNodeValue());
                }
                
            }
        }

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            returnCache(children.item(i));
        }
        return returncache;
    }
    public static void main(String[] args){
        
        Document doc = null;
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(fileXML);
            
//            System.out.println(returnLocation("users", doc.getFirstChild()));
            System.out.println(returnCache(doc.getFirstChild()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
