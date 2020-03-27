package com.babar.crawler.downloader;

import com.babar.crawler.entity.Page;
import com.babar.crawler.entity.Request;
import com.babar.crawler.entity.Task;

public interface Downloader {

  
    public Page download(Request request, Task task);

    public void setThread(int threadNum);
}
