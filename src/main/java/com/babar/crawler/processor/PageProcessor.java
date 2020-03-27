package com.babar.crawler.processor;

import com.babar.crawler.entity.Page;
import com.babar.crawler.entity.Site;

public interface PageProcessor {

    public void process(Page page);

   
    public Site getSite();
}
