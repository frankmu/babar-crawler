package com.babar.crawler.pipeline;

import java.util.Map;

import com.babar.crawler.entity.ResultItems;
import com.babar.crawler.entity.Task;

public class ConsolePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("get page: " + resultItems.getRequest().getUrl());
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println(entry.getKey() + ":\t" + entry.getValue());
        }
    }
}
