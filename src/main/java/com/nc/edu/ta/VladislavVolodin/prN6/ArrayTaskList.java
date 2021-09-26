/*
package com.nc.edu.ta.VladislavVolodin.prN6;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

*/
/**
 * Description class ArrayTaskList
 *//*


public class ArrayTaskList extends AbstractTaskList {

    */
/**
     * default task size
     *//*


    private static final int DEFAULT_TASK_SIZE = 10;
    */
/**
     *
     *//*


    private static final int GROW_TASK_SIZE = DEFAULT_TASK_SIZE * 2;
    */
/**
     * title prefix constant
     *//*


    private final String TITLE = "[EDUCTR] [TA]";

    */
/**
     * count number of tasks
     *//*


    private static int countTask = 0;

    */
/**
     * tasks list
     *//*


    private Task[] tasks;


    */
/**
     * Constructor which creates a new task list
     *
     * @param tasks tasks list
     *//*


    public ArrayTaskList(Task[] tasks) {
        this.tasks = tasks;
        countTask++;
    }


    */
/**
     * Constructor which adds DEFUALT_TASK_SIZE to task list
     *//*


    public ArrayTaskList() {
        this(new Task[DEFAULT_TASK_SIZE]);
    }


    */
/**
     * @param task name task
     * @throws RuntimeException throw task equals null
     *//*


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


    */
/**
     * @param task name task
     * @throws RuntimeException throw task equals null
     *//*


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


    */
/**
     * @param index task number
     * @return task
     *//*


    public Task getTask(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        } else
            return tasks[index];
    }


    */
/**
     * @param from start notification time
     * @param to   end notification time
     * @return task list
     *//*


    @Override
    public Task[] incoming(Date from, Date to) {
        List<Task> listTasks = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Task task = tasks[i];
            if (task.isActive()) {
                if (task.isRepeated()) {
                    if (task.getRepeatInterval() != 0) {
                        for (Date j = task.getStartTime(); j.after(task.getEndTime()); j += task.getRepeatInterval()) {
                            if (j > from && j <= to) {
                                listTasks.add(task);
                                break;
                            }
                        }
                    }
                } else {
                    if (task.getTime() > from.getTime() && task.getTime() <= to.getTime()) {
                        listTasks.add(task);
                    }
                }
            }
        }
        return listTasks.toArray(Task[]::new);
    }
}
*/
