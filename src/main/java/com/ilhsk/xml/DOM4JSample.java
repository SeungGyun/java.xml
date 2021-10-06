/**
 * @File DOM4JSample.java
 * @package com.ilhsk.xml
 * @Description 
 * @Modification Information
 * @ProjectName  NetmarbleNeo Project
 * @Author ilhsk
 * @Since 2021. 10. 5.
 * @Copyright Copyright (c) 2021 NetmarbleNeo, Corp. All Rights Reserved.
 */
package com.ilhsk.xml;

/**
 * @Auth ilhsk
 * @Description 
 * <pre></pre>   
 */
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

public class DOM4JSample 
{ 
    public static void main(String[] args) throws ParserConfigurationException,
    SAXException, IOException {
        try {
            File inputFile = new File("sample.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read( inputFile );
            System.out.println("Root element :" + document.getRootElement().getName());
            Element classElement = document.getRootElement();
            List<Node> nodes = document.selectNodes("company/employee");
            System.out.println("----------------------------");
            for (Node node : nodes) {
                System.out.println("\nCurrent Element :"
                        + node.getName());
                System.out.println("First Name : "
                        + node.selectSingleNode("firstname").getText());
                System.out.println("Last Name : "
                        + node.selectSingleNode("lastname").getText());
                System.out.println("Salary : "
                        + node.selectSingleNode("salary").getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}