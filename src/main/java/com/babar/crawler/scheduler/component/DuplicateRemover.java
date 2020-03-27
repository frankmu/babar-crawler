package com.babar.crawler.scheduler.component;

import com.babar.crawler.entity.Request;
import com.babar.crawler.entity.Task;

public interface DuplicateRemover {

    public boolean isDuplicate(Request request, Task task);
 
    public void resetDuplicateCheck(Task task);
    
    public int getTotalRequestsCount(Task task);
}