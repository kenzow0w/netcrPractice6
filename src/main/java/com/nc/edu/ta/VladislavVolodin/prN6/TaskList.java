package com.nc.edu.ta.VladislavVolodin.prN6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description class TaskList
 */
public abstract class TaskList extends AbstractTaskList {


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"TaskListType[")
                .append(" \"");
//                .append(TaskList1 + ", ")
//                .append(TaskList2 + "]\"");
        return sb.toString();
    }

}
