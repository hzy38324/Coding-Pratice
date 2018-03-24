package com.sexycode.codepractice.concurrency.htmlRender.render;

import com.sexycode.codepractice.concurrency.htmlRender.entity.ImageData;
import com.sexycode.codepractice.concurrency.htmlRender.entity.ImageInfo;

import java.util.List;
import java.util.concurrent.*;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/13
 */
public class CompletionServiceRenderer implements HtmlRender {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void renderPage(String source) throws Exception {
        final List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService =
                new ExecutorCompletionService<>(executor);
        for (final ImageInfo imageInfo : info)
            completionService.submit(() ->
                    imageInfo.downloadImage());

        renderText(source);

        for (int t = 0, n = info.size(); t < n; t++) {
            Future<ImageData> f = completionService.take();
            ImageData imageData = f.get();
            renderImage(imageData);
        }
    }

}