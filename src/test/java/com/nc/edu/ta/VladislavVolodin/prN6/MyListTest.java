package com.nc.edu.ta.VladislavVolodin.prN6;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class MyListTest {

    ArrayTaskList list1 = new ArrayTaskList();
    ArrayTaskList list2 = new ArrayTaskList();

    LinkedTaskList list3 = new LinkedTaskList();
    LinkedTaskList list4 = new LinkedTaskList();


    @Test
    public void equalsArrayList() {
        Date dateStart = new Date();
        list1.add(new Task("title", dateStart));
        list1.add(new Task("title2", dateStart));
        list1.add(new Task("title3", dateStart));
        list1.add(new Task("title4", dateStart));

        list2.add(new Task("title", dateStart));
        list2.add(new Task("title2", dateStart));
        list2.add(new Task("title3", dateStart));
        list2.add(new Task("title4", dateStart));

        assertEquals(list1, list2);
        assertEquals(list1.hashCode(), (list2.hashCode()));

    }

    @Test
    public void equalsLinkedList() {
        Date dateStart = new Date();
        list3.add(new Task("title", dateStart));
        list3.add(new Task("title2", dateStart));
        list3.add(new Task("title3", dateStart));
        list3.add(new Task("title4", dateStart));

        list4.add(new Task("title", dateStart));
        list4.add(new Task("title2", dateStart));
        list4.add(new Task("title3", dateStart));
        list4.add(new Task("title4", dateStart));

        assertEquals(list3, list4);
        assertEquals(list3.hashCode(), list4.hashCode());
    }


    @Test
    public void cloneArrayList() {
        Date dateStart = new Date();
        list1.add(new Task("title", dateStart));
        list1.add(new Task("title2", dateStart));
        list1.add(new Task("title3", dateStart));
        list1.add(new Task("title4", dateStart));

        list2 = (ArrayTaskList) list1.clone();

        assertEquals(list1, list2);
        assertEquals(list1.size(), list2.size());
        assertEquals(list1.hashCode(), list2.hashCode());

        for (int i = 0; i < list1.size; i++) {
            assertEquals(list1.getTask(i), list2.getTask(i));
        }
        assertNotSame(list1, list2);
    }


    @Test
    public void cloneLinkedList() {
        Date dateStart = new Date();
        list3.add(new Task("title", dateStart));
        list3.add(new Task("title2", dateStart));
        list3.add(new Task("title3", dateStart));
        list3.add(new Task("title4", dateStart));

        list4 = (LinkedTaskList) list3.clone();

        assertEquals(list3, list4);
        assertEquals(list3.size(), list4.size());
        assertEquals(list3.hashCode(), list4.hashCode());

        for (int i = 0; i < list3.size; i++) {
            assertEquals(list3.getTask(i), list4.getTask(i));
        }
        assertNotSame(list3, list4);

    }
}
