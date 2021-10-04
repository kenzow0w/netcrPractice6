package com.nc.edu.ta.VladislavVolodin.prN6;

import java.util.Objects;

/**
 * Description class ArrayTaskList
 */
public class ArrayTaskList extends TaskList {


    /**
     * default task size
     */
    private static final int DEFAULT_TASK_SIZE = 10;

    /**
     *
     */
    private static final int GROW_TASK_SIZE = DEFAULT_TASK_SIZE * 2;

    /**
     * title prefix constant
     */
    private final String TITLE = "[EDUCTR] [TA]";


    /**
     * count number of tasks
     */
    private static int countTask = 0;


    /**
     * tasks list
     */
    private Task[] tasks;


    /**
     * Constructor which adds DEFUALT_TASK_SIZE to task list
     */
    public ArrayTaskList() {
        tasks = new Task[10];
    }


    /**
     * @param task name task
     * @throws RuntimeException throw task equals null
     */
    @Override
    public void add(Task task) throws RuntimeException {
        if (task == null) {
            throw new RuntimeException("task equals null");
        } else {
            if (tasks.length > size) {
                tasks[size] = task;
                size++;
            } else {
                int newSize = tasks.length + GROW_TASK_SIZE;
                Task[] temp = new Task[newSize];
                for (int i = 0; i < tasks.length; i++) {
                    temp[i] = tasks[i];
                }
                temp[size] = task;
                tasks = temp;
                size++;
            }
        }
    }


    /**
     * @param task name task
     * @throws RuntimeException throw task equals null
     */
    @Override
    public void remove(Task task) throws RuntimeException {
        if (task == null) {
            throw new RuntimeException("task equals null");
        } else {
            for (int i = 0; i < size; i++) {
                if (tasks[i].equals(task)) {
                    tasks[i] = null;
                    size--;
                }
            }
            for (int i = 0; i < size; i++) {
                if (tasks[i] == null) {
                    for (int j = i + 1; j < tasks.length - 1; j++) {
                        tasks[j - 1] = tasks[j];
                        tasks[j] = null;
                    }
                }
            }
        }
    }


    /**
     * @param index task number
     * @return task
     */
    public Task getTask(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        } else
            return tasks[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayTaskList")
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
        if (o == null && getClass() != o.getClass()) return false;
        ArrayTaskList list = (ArrayTaskList) o;
        if (this.size != list.size) return false;
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(this.tasks[i], list.tasks[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (Task tmp : this.tasks) {
            hashCode = 31 * hashCode + (tmp == null ? 0 : tmp.hashCode());
        }
        return hashCode;

    }
}
