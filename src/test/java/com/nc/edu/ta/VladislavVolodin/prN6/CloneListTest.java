/*
package com.nc.edu.ta.VladislavVolodin.prN6;


import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;
import static com.nc.edu.ta.VladislavVolodin.prN6.Utils.*;

public class CloneListTest extends AbstractTaskListTest {

    public CloneListTest(Class<? extends TaskList> tasksClass) {
        super(tasksClass);
    }
    
    @Test
    public void testClone() throws CloneNotSupportedException {
        Task[] elements = { task("A"), task("B"), task("C") };
        for (Task task : elements)
            tasks.add(task);
        
        TaskList clone = (TaskList) tasks.clone();
        
        assertEquals(getTitle(), tasks.size(), clone.size());
        
        Iterator<Task> i = tasks.iterator(), j = clone.iterator();
        while (i.hasNext())
            assertEquals(getTitle(), i.next(), j.next());
            
        assertNotSame(getTitle(), tasks, clone);
        
        clone.add(task("D"));
        assertEquals(getTitle(), clone.size() - 1, tasks.size());
        
        clone.remove(task("B"));
        assertContains(getTitle(), elements, tasks);
    }
}
*/

