package com.nc.edu.ta.VladislavVolodin.prN6;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Main class of the project
 */
public class Main {

    public static void main(String[] args) {

//        ArrayTaskList list1 = new ArrayTaskList();
//
//
//        list1.add(new Task("task1", new Date()));
//        list1.add(new Task("task2", new Date()));
//        list1.add(new Task("task3", new Date()));
//        list1.add(new Task("task4", new Date()));
//
//
//        System.out.println(list1.toString());

        LinkedTaskList list3 = new LinkedTaskList();
        LinkedTaskList list4 = new LinkedTaskList();


        Date dateStart = new Date();
        list3.add(new Task("title", dateStart));
        list3.add(new Task("title2", dateStart));
        list3.add(new Task("title3", dateStart));
        list3.add(new Task("title4", dateStart));

        list4.add(new Task("title", dateStart));
        list4.add(new Task("title2", dateStart));
        list4.add(new Task("title3", dateStart));
        list4.add(new Task("title4", dateStart));

        System.out.println(list3.hashCode());
        System.out.println(list4.hashCode());
    }
}
