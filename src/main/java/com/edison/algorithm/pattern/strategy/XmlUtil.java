package com.edison.algorithm.pattern.strategy;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

/**
 * @Description TODO
 * @Date 2020/3/10下午11:20
 * @Created by edsiongeng
 */
public class XmlUtil {

    public static Object getBean() {

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builderFactory = documentBuilderFactory.newDocumentBuilder();
            Document doc;
            doc = builderFactory.parse(new File("/Users/edsiongeng/IdeaProjects/day_day_algorithm/src/main/resources/config.xml"));

            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = classNode.getNodeValue();
            Class c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
