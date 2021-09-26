package com.nc.edu.ta.VladislavVolodin.prN6;

import java.util.ArrayList;
import java.util.List;

/**
 * Description class TaskList
 */
public class TaskList extends AbstractTaskList {

    public TaskList() {
        List<Task> taskList = new ArrayList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"TaskListType[")
                .append(" \"");
//                .append(TaskList1 + ", ")
//                .append(TaskList2 + "]\"");
        return sb.toString();
    }

    @Override
    public void add(Task task) {
        if (task == null) {
            throw new RuntimeException("task equals null");
        }
    }

    @Override
    public void remove(Task task) {

    }

    @Override
    public Task getTask(int index) {
        return null;
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public Task[] incoming(int from, int to) {
        return new Task[0];
    }
}
