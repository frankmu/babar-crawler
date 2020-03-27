# babar-crawler

Light-weight crawler which is similar to [scrapy](https://scrapy.org/) in python. [Architecture overview](https://docs.scrapy.org/en/0.22/topics/architecture.html) for scrpay

## Main Components
- **Downloader**: Download the actual webpage through any http client, e.g. `CloseableHttpClient`
- **Scheduler**: Maintain a request queue and push/poll request into it
- **Pipeline**: Once download finished, the result will be passing to `Pipeline` for custom operation
- **Spider**: Integrate all the components together

## Data Flow
```java
void processRequest(Request request) {
    Page page = downloader.download(request, this);
    pageProcessor.process(page);
    for (Request request : page.getTargetRequests()) {
        scheduler.push(request, this);
    }
    if (!page.getResultItems().isSkip()) {
        for (Pipeline pipeline : pipelines) {
            pipeline.process(page.getResultItems(), this);
        }
    }
}
```
- Start from the see url, Downloader will download the content
- PageProcessor will process the result
- Add child urls from the page content
- Process custom operation through Pipeline if there is any
