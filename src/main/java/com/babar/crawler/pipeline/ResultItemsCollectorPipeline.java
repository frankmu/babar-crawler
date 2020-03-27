package com.babar.crawler.pipeline;

import java.util.ArrayList;
import java.util.List;

import com.babar.crawler.entity.ResultItems;
import com.babar.crawler.entity.Task;


public class ResultItemsCollectorPipeline implements CollectorPipeline<ResultItems> {

    private List<ResultItems> collector = new ArrayList<ResultItems>();

    @Override
    public synchronized void process(ResultItems resultItems, Task task) {
        collector.add(resultItems);
    }

    @Override
    public List<ResultItems> getCollected() {
        return collector;
    }
}
