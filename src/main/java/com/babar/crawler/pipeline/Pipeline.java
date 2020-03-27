package com.babar.crawler.pipeline;

import com.babar.crawler.entity.ResultItems;
import com.babar.crawler.entity.Task;

/**
 * @see ConsolePipeline
 * @see FilePipeline
 */
public interface Pipeline {

    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     * @param task task
     */
    public void process(ResultItems resultItems, Task task);
}
