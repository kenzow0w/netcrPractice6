package com.nc.edu.ta.VladislavVolodin.prN6;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;

public class MyEqualsListTest
{
    ArrayTaskList list1 = new ArrayTaskList();
    ArrayTaskList list2 = new ArrayTaskList();

    LinkedTaskList list3 = new LinkedTaskList();
    LinkedTaskList list4 = new LinkedTaskList();

    public MyEqualsListTest(){
    }

    @Test
    public void equalsArrayList() {
        list1.add(new Task("title", new Date()));
        list1.add(new Task("title2", new Date()));
        list1.add(new Task("title3", new Date()));
        list1.add(new Task("title4", new Date()));

        list2.add(new Task("title", new Date()));
        list2.add(new Task("title2", new Date()));
        list2.add(new Task("title3", new Date()));
        list2.add(new Task("title4", new Date()));

        assertEquals(list1, list2);
        assertEquals(list1.hashCode(), (list2.hashCode()));

    }

    @Test
    public void equalsLinkedList() {
        list3.add(new Task("title", new Date()));
        list3.add(new Task("title2", new Date()));
        list3.add(new Task("title3", new Date()));
        list3.add(new Task("title4", new Date()));

        list4.add(new Task("title", new Date()));
        list4.add(new Task("title2", new Date()));
        list4.add(new Task("title3", new Date()));
        list4.add(new Task("title4", new Date()));

        assertEquals(list3, list4);
        System.out.println(list3.hashCode());
        System.out.println(list4.hashCode());
//        assertEquals(list3.hashCode(), (list4.hashCode()));

    }

}
