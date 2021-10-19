package com.nc.edu.ta.VladislavVolodin.prN6;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Main class of the project
 */
public class Main {

    public static void main(String[] args) {

        Task task = new Task();

        Document doc;
        try {
            doc = getDocument();
        } catch (Exception e) {
            System.out.println("Open parsing error " + e.toString());
            return;
        }

        //Название первого тега - tasks
        Node tasksNode = doc.getFirstChild();
        System.out.println("tasks: " + tasksNode.getNodeName());

        List<Task> taskList = new ArrayList();

        //Дочерний тег от первого - task
        NodeList tasksChild = tasksNode.getChildNodes();
        String mainName = null;
        int count = 1;
        for (int i = 0; i < tasksChild.getLength(); i++) {

            if (tasksChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            String title = "";
            Date startDate = task.getTime();
            System.out.println("task" + count + " " + tasksChild.item(i).getNodeName());
            count++;

            switch (tasksChild.item(i).getNodeName()) {
                case "title": {
                    title = tasksChild.item(i).getTextContent();
                }
                case "startDate": {
//                    startDate = tasksChild.item(i).getTextContent();
                }
            }

        }
    }
    //если элемент NODE то вывод на экран


    private static Document getDocument() throws Exception {
        File file = new File("TaskList.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }
}

