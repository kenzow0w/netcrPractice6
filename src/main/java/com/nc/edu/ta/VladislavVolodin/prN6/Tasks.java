package com.nc.edu.ta.VladislavVolodin.prN6;

import java.util.*;

import static com.sun.tools.sjavac.Util.set;

public class Tasks {

    /**
     * Return task list in a set interval
     *
     * @param from start notification time
     * @param to   end notification time
     * @return task list
     */
    public static List<Task> incoming(List<Task> tasks, Date from, Date to) {
        List<Task> resultList = new ArrayList<>();
        for (Task tmp : tasks) {
            if (tmp.isActive()) {
                if (tmp.isRepeated()) {
                    if (tmp.getRepeatInterval() != 0) {
                        for (Date j = tmp.getStartTime(); j.compareTo(tmp.getEndTime()) <= 0; j = new Date(j.getTime() + (tmp.getRepeatInterval() * 1000L))) {
                            if (j.compareTo(from) > 0 && j.compareTo(to) <= 0) {
                                resultList.add(tmp);
                                break;
                            }
                        }
                    }
                } else {
                    Date date = tmp.getTime();
                    if (date.compareTo(from) > 0 && date.compareTo(to) <= 0) {
                        resultList.add(tmp);
                    }
                }
            }
        }
        return resultList;
    }


    public static SortedMap<Date, Set<Task>> timeline(List<Task> tasks, Date from, Date to) {
        TreeMap<Date, Set<Task>> result = new TreeMap<>();
        from = new Date(from.getTime() + 1);
        for (Date j = from; j.compareTo(to) <= 0; j = new Date(j.getTime() + (60 * 60 * 1000L))) {
            Set<Task> setTasks = new HashSet<>(incoming(tasks, j));
            result.put(j, setTasks);
        }

        return result;
    }


    public static List<Task> incoming(List<Task> tasks, Date point) {
        List<Task> resultList = new ArrayList<>();
        for (Task tmp : tasks) {
            if (tmp.isActive()) {
                if (tmp.isRepeated()) {
                    if (tmp.getRepeatInterval() != 0) {
                        for (Date j = tmp.getStartTime(); j.compareTo(tmp.getEndTime()) <= 0; j = new Date(j.getTime() + (tmp.getRepeatInterval() * 1000L))) {
                            if (j.compareTo(point) == 0) {
                                resultList.add(tmp);
                                break;
                            }
                        }
                    }
                } else {
                    Date date = tmp.getTime();
                    if (date.compareTo(point) == 0) {
                        resultList.add(tmp);
                    }
                }
            }
        }
        return resultList;
    }


}



