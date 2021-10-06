/**
 * @File POJOSample.java
 * @package com.ilhsk.xml
 * @Description 
 * @Modification Information
 * @ProjectName  NetmarbleNeo Project
 * @Author ilhsk
 * @Since 2021. 10. 5.
 * @Copyright Copyright (c) 2021 NetmarbleNeo, Corp. All Rights Reserved.
 */
package com.ilhsk.xml;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class POJOSample 
{ 
    public static void main(String[] args) throws ParserConfigurationException,
    SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("sample.xml"));
        List<Employee> employees = new ArrayList<Employee>();
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                String firstname = elem.getElementsByTagName("firstname")
                        .item(0).getChildNodes().item(0).getNodeValue();
                String lastname = elem.getElementsByTagName("lastname").item(0)
                        .getChildNodes().item(0).getNodeValue();
                Double salary = Double.parseDouble(elem.getElementsByTagName("salary")
                        .item(0).getChildNodes().item(0).getNodeValue());
                employees.add(new Employee(firstname, lastname, salary));
            }
        }
        for (Employee empl: employees)
            System.out.println(empl.toString());
    }
}
class Employee {
    private String Firstname;
    private String Lastname;
    private double salary;
    public Employee(String Firstname, String Lastname, double salary) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "[" + Firstname + ", " + Lastname + ", "+ salary + "]";
    }
}