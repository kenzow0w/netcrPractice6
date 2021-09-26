package com.nc.edu.ta.VladislavVolodin.prN6;/*

import com.nc.edu.ta.VladislavVolodin.prN3.AbstractTaskList;
import com.nc.edu.ta.VladislavVolodin.prN6.Task;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Description class ArrayTaskList
 /*

public class LinkedTaskList extends AbstractTaskList {
    private NodeTask head;
    */
/**
     * count number of tasks
     *//*

    private static int countTask = 0;

    */
/**
     * Description class NodeTask
     *//*

    private static class NodeTask {
        */
/**
         * task name
         *//*

        private Task task;
        */
/**
         * next node
         *//*

        private NodeTask next;

        */
/**
         * Constructor which creates a new node
         *
         * @param task task name
         * @param next next task
         *//*

        NodeTask(Task task, NodeTask next) {
            this.task = task;
            this.next = next;
        }
    }

    */
/**
     * Constructor which counting tasks
     *//*

    public LinkedTaskList() {
        countTask++;
    }

    @Override
    public void add(Task task) {
        if (task == null) {
            throw new RuntimeException("Task equal null");
        } else {
            if (size == 0) {
                head = new NodeTask(task, null);
                size++;
            } else {
                NodeTask tmp = head;
                NodeTask newNode = new NodeTask(task, null);
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = newNode;
                size++;
            }
        }
    }

    @Override
    public void remove(Task task) {
        if (task != null) {
            if (size != 0) {
                while (task.equals(head.task)) {
                    head = head.next;
                    size--;
                }
                if (size != 0) {
                    NodeTask current = head;
                    NodeTask next = current.next;
                    while (next != null) {
                        if (task.equals(next.task)) {
                            current.next = next.next;
                            size--;
                        }
                        current = current == null ? null : current.next;
                        next = current == null ? null : current.next;
                    }
                }
            }
        } else {
            throw new RuntimeException("Task equal null");
        }
    }

    @Override
    public Task getTask(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        NodeTask tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.task;
    }

    @Override
    public Task[] incoming(int from, int to) {
        List<Task> listTasks = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Task task = getTask(i);
            if (task.isActive()) {
                if (task.isRepeated()) {
                    if (task.getRepeatInterval() != 0) {
                        for (int j = task.getStartTime(); j <= task.getEndTime(); j += task.getRepeatInterval()) {
                            if (j > from && j <= to) {
                                listTasks.add(task);
                                break;
                            }
                        }
                    }
                } else {
                    if (task.getTime() > from && task.getTime() <= to) {
                        listTasks.add(task);
                    }
                }
            }
        }
        return listTasks.toArray(Task[]::new);
    }
}
*/
