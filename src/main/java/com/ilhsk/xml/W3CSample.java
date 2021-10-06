/**
 * @File W3CSample.java
 * @package com.ilhsk.xml
 * @Description
 * @Modification Information
 * @ProjectName NetmarbleNeo Project
 * @Author ilhsk
 * @Since 2021. 10. 5.
 * @Copyright Copyright (c) 2021 NetmarbleNeo, Corp. All Rights Reserved.
 */
package com.ilhsk.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @Auth ilhsk
 * @Description
 * 
 *              <pre></pre>
 */
public class W3CSample {

	/**
	 * @Auth ilhsk ilhsk@nm-neo.com
	 * @Create_Date 2021. 10. 5.
	 * @Description
	 * 
	 *              <pre></pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException {

		String path = System.getProperty("user.dir");
		System.out.println("Working Directory = " + path);
		try {
			File file = new File("sample.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();
			System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
			NodeList nList = document.getElementsByTagName("employee");
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Employee id : " + eElement.getAttribute("id"));
					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
