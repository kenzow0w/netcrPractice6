package com.nc.edu.ta.VladislavVolodin.prN6;

import java.io.*;
import java.util.Date;
import java.util.Objects;



/**
 * Description class Task
 *
 * @author Vladislav Volodin
 */

public class Task implements Cloneable, Serializable {
    /**
     * task name
     */
    private String title;
    /**
     * time interval to repeat the task
     */
    private int repeat;
    /**
     * activity indicator of the task
     */
    private boolean active;
    /**
     * start notification time
     */
    private Date dateStart;
    /**
     * end notification time
     */
    private Date dateEnd;

    /**
     * Constructor for single task
     *
     * @param title     task name
     * @param dateStart start notification time
     */
    public Task(String title, Date dateStart) {
        this(title, dateStart, dateStart, 0);
        titleException(title);
        myExceptionForNonRepeated(dateStart);
    }

    /**
     * Constructor for repeating tasks
     *
     * @param title     task name
     * @param dateStart start notification time
     * @param dateEnd   end notification time
     * @param repeat    time interval to repeat the task
     */
    public Task(String title, Date dateStart, Date dateEnd, int repeat) {
        this.title = title;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.repeat = repeat;
        titleException(title);
        myExceptionForRepeated(dateStart, dateEnd, repeat);
    }

    public Task() {

    }

    /**
     * @param dateStart nptification time
     * @param dateEnd   end notification time
     * @param repeat    time interval to repeat the task
     * @throws RuntimeException start, end, repeat no less zero and no more end
     */
    private void myExceptionForRepeated(Date dateStart, Date dateEnd, int repeat) {
        if (dateStart == null || dateEnd == null || repeat < 0 || dateStart.getTime() > dateEnd.getTime()) {
            throw new RuntimeException("date equals null");
        }
    }


    /**
     * Get task name
     *
     * @param title task name
     */
    public void setTitle(String title) {

        this.title = title;
        titleException(title);
    }

    /**
     * @param title task name
     * @throws RuntimeException name task equals null
     */
    private void titleException(String title) {
        if (title == null || title.equals("")) {
            throw new RuntimeException("add task name");
        }
    }

    /**
     * Method to return task name
     *
     * @return task name
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method to return activity indicator
     *
     * @return activity indicator of the task
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Method get activity indicator of the task
     *
     * @param active activity indicator of the task
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Method get notification time
     *
     * @param date start notification time of the task
     */
    public void setTime(Date date) {
        setTime(date, date, 0);
        myExceptionForNonRepeated(date);
    }

    /**
     * Constructor for repeating tasks
     *
     * @param dateStart start notification time
     * @param dateEnd   end notification time
     * @param repeat    time interval to repeat the task
     */
    public void setTime(Date dateStart, Date dateEnd, int repeat) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.repeat = repeat;
        myExceptionForRepeated(dateStart, dateEnd, repeat);

    }

    /**
     * @param dateStart task notification time
     * @throws RuntimeException time no less zero
     */
    private void myExceptionForNonRepeated(Date dateStart) throws RuntimeException {
        if (dateStart == null)
            throw new IndexOutOfBoundsException("time no less zero");
    }

    /**
     * Method to return start notification time
     *
     * @return start notification time
     */
    public Date getTime() {
        return dateStart;
    }

    /**
     * Method to return start notification time
     *
     * @return start notification time
     */
    public Date getStartTime() {
        return dateStart;
    }

    /**
     * Method to return end notification time
     *
     * @return end notification time
     */
    public Date getEndTime() {
        return dateEnd;
    }

    /**
     * Method to return notification time
     *
     * @return time interval to repeat the task
     */
    public int getRepeatInterval() {
        return repeat;
    }


    /**
     * Method checked repeat of the task
     *
     * @return time interval to repeat the task
     */
    public boolean isRepeated() {
        return repeat != 0;
    }

    /**
     * Method to check task activity and next notification time
     *
     * @param dateNextTime current time
     * @return next notification time or -1 if task is not active or notification is not expected
     */
    public Date nextTimeAfter(Date dateNextTime) {
        myExceptionForNonRepeated(dateNextTime);
        Date result = null;

        if (dateNextTime.after(dateEnd)) {
            return null;
        }
        if (isActive())
            if (isRepeated()) {  //TODO!!
                for (Date tmp = dateStart; tmp.compareTo(dateEnd) <= 0; tmp = new Date(tmp.getTime() + (repeat * 1000L))) {
                    if (tmp.compareTo(dateNextTime) > 0) {
                        result = tmp;
                        break;
                    }
                }
            } else {
                if (dateNextTime.before(dateStart)) {
                    result = dateStart;
                }
            }
        return result;
    }


    /**
     * Method to return task name
     *
     * @return to return task description
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Task ")
                .append("\"")
                .append(title)
                .append("\"");
        if (!isActive()) {
            sb.append(" is inactive");
        } else {
            if (!isRepeated()) {
                sb.append(" at ")
                        .append(dateStart);
            } else {
                sb.append(" from ")
                        .append(dateStart)
                        .append(" to ")
                        .append(dateEnd)
                        .append(" every ")
                        .append(repeat)
                        .append(" seconds");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Task task = (Task) o;
        return
                Objects.equals(getStartTime(), task.getStartTime())
                        && Objects.equals(getEndTime(), task.getEndTime())
                        && ((Task) o).getRepeatInterval() == task.getRepeatInterval()
                        && isActive() == task.isActive()
                        && Objects.equals(title, task.title);
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * title.hashCode();
        result = prime * result + (getStartTime().hashCode() * prime);
        result = prime * result + (getTime().hashCode() * prime);
        result = prime * result + (getEndTime().hashCode() * prime);
        result = prime * result + (getRepeatInterval() * prime);
        result = prime * result + Boolean.hashCode(active);
        return result;
        // return Objects.hash(title, start, end, repeat, active);
    }

    public Task clone() throws CloneNotSupportedException {
//        taskClone.title = this.title;
//        taskClone.dateStart = this.dateStart;
//        taskClone.dateEnd = this.dateEnd;
//        taskClone.repeat = this.repeat;
//        return taskClone;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(baos);
            ous.writeObject(this);
            ous.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);

            return (Task) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new CloneNotSupportedException();
        }
    }
}


