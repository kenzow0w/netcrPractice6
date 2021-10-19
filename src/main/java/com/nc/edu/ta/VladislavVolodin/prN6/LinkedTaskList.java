package com.nc.edu.ta.VladislavVolodin.prN6;


import java.io.*;
import java.util.Objects;

/**
 * Description class ArrayTaskList
 */

public class LinkedTaskList extends TaskList {
    private NodeTask head;
    /**
     * count number of tasks
     */
    private static int countTask = 0;


    /**
     * Description class NodeTask
     */
    private static class NodeTask implements Serializable {

        /**
         * task name
         */
        private Task task;

        /**
         * next node
         */
        private NodeTask next;

        /**
         * Constructor which creates a new node
         *
         * @param task task name
         * @param next next task
         */
        public NodeTask(Task task, NodeTask next) {
            this.task = task;
            this.next = next;
        }
    }


    /**
     * Constructor which counting tasks
     */
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
                        current = current.next;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedTaskList")
                .append("[");
        for (int i = 0; i < size(); i++) {
            sb.append(getTask(i));

            if (i == size() - 1) {
                return sb.append("]").toString();
            } else {
                sb.append(", ");
            }
        }
        return "[]";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedTaskList list = (LinkedTaskList) o;
        if (this.size != list.size)
            return false;
        NodeTask tmp1 = this.head;
        NodeTask tmp2 = list.head;
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(tmp1.task.getTitle(), tmp2.task.getTitle())) {
                return false;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        NodeTask next = head;
        if (next != null) {
            for (int i = 0; i < size; i++) {
                hashCode = 31 * hashCode + (next == null ? 0 : next.task.hashCode());
                next = next.next;
            }
        }
        return hashCode;
    }
}
