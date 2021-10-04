package com.nc.edu.ta.VladislavVolodin.prN6;

import static com.nc.edu.ta.VladislavVolodin.prN6.Utils.assertContains;
import static com.nc.edu.ta.VladislavVolodin.prN6.Utils.task;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

public class MyEqualsListTest {
    ArrayTaskList list1 = new ArrayTaskList();
    ArrayTaskList list2 = new ArrayTaskList();

    LinkedTaskList list3 = new LinkedTaskList();
    LinkedTaskList list4 = new LinkedTaskList();

    public MyEqualsListTest() {
    }

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
        assertEquals(list1.hashCode(), list2.hashCode());
    }


    @Test
    public void cloneArrayList2() {
        ArrayTaskList tasks = new ArrayTaskList();
        Task[] elements = {task("A"), task("B"), task("C")};
        for (Task task : elements)
            tasks.add(task);

        TaskList clone = (TaskList) tasks.clone();

        assertEquals(tasks.size(), clone.size());

        for (int i = 0; i < tasks.size; i++) {
            assertEquals(tasks.getTask(i), clone.getTask(i));
        }
        assertNotSame(tasks, clone);
    }
}
