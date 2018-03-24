package com.sexycode.codepractice.concurrency.htmlRender.render;

import com.sexycode.codepractice.concurrency.htmlRender.entity.ImageData;
import com.sexycode.codepractice.concurrency.htmlRender.entity.ImageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/13
 */
public class FutureRenderer implements HtmlRender {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void renderPage(String source) throws Exception {
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        Callable<List<ImageData>> task =
                () -> {
                    List<ImageData> result = new ArrayList<>();
                    for (ImageInfo imageInfo : imageInfos)
                        result.add(imageInfo.downloadImage());
                    return result;
                };

        // start download image before render text
        Future<List<ImageData>> future = executor.submit(task);

        renderText(source);

        List<ImageData> imageData = future.get();
        for (ImageData data : imageData)
            renderImage(data);
    }
}
