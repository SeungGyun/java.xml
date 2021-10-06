/**
 * @File JDOM2Sample.java
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
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.SAXException;

public class JDOM2Sample 
{ 
    public static void main(String[] args) throws ParserConfigurationException,
    SAXException, IOException {
        try {
            File inputFile = new File("sample.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            System.out.println("Root element :" + document.getRootElement().getName());
            Element classElement = document.getRootElement();

            List<Element> studentList = classElement.getChildren();
            System.out.println("----------------------------");

            for (int temp = 0; temp < studentList.size(); temp++) {    
                Element student = studentList.get(temp);
                System.out.println("\nCurrent Element :" 
                        + student.getName());
                System.out.println("First Name : "
                        + student.getChild("firstname").getText());
                System.out.println("Last Name : "
                        + student.getChild("lastname").getText());
                System.out.println("Salary : "
                        + student.getChild("salary").getText());
            }
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
