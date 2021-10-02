package com.nc.edu.ta.VladislavVolodin.prN6;

import java.util.Date;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Description class AbstractTaskList
 */
public abstract class AbstractTaskList implements Iterable<Task> {
    /**
     * Cunt of tasks
     */
    protected int size;

    @Override
    public Iterator<Task> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Task> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Task> spliterator() {
        return Iterable.super.spliterator();
    }

    /**
     * Add task
     *
     * @param task name task
     */
    public abstract void add(Task task);

    /**
     * Remove task
     *
     * @param task name task
     */
    public abstract void remove(Task task);

    /**
     * Return task by index
     *
     * @param index task position
     * @return task
     */
    public abstract Task getTask(int index);

    /**
     * Return count of tasks
     *
     * @return size task
     */
    public int size() {
        return size;
    }



}
