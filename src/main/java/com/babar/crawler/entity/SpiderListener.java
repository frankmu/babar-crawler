package com.babar.crawler.entity;

public interface SpiderListener {

    public void onSuccess(Request request);

    public void onError(Request request);
}
