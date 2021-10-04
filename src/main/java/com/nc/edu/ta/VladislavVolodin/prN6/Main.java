package com.nc.edu.ta.VladislavVolodin.prN6;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Main class of the project
 */
public class Main {

    public static void main(String[] args) {
        List<Object> list = new LinkedList();
        list.add("title");
        list.add("title");
        list.add("title");

        list.hashCode();

        LinkedTaskList list3 = new LinkedTaskList();
        LinkedTaskList list4 = new LinkedTaskList();

        list3.add(new Task("title", new Date()));
        list3.add(new Task("title2", new Date()));
        list3.add(new Task("title3", new Date()));
        list3.add(new Task("title4", new Date()));

        list4.add(new Task("title", new Date()));
        list4.add(new Task("title2", new Date()));
        list4.add(new Task("title3", new Date()));
        list4.add(new Task("title4", new Date()));

        System.out.println(list3.hashCode());
        System.out.println(list4.hashCode());
    }
}
