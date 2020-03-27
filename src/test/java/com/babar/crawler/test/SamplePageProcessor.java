package com.babar.crawler.test;

import com.babar.crawler.Spider;
import com.babar.crawler.entity.Page;
import com.babar.crawler.entity.Site;
import com.babar.crawler.pipeline.FilePipeline;
import com.babar.crawler.pipeline.Pipeline;
import com.babar.crawler.processor.PageProcessor;

public class SamplePageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(0);

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://www.meizitu.com/\\w+/\\w+)").all());
        page.addTargetRequests(page.getHtml().links().regex("(https://www.meizitu.com/\\w+)").all());
        page.putField("image", page.getHtml().xpath("//img/@src"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
    		Pipeline pipeline = new FilePipeline("/data/meizi/");
        Spider.create(new SamplePageProcessor()).addPipeline(pipeline).addUrl("https://www.meizitu.com").thread(5).run();
    }
}
