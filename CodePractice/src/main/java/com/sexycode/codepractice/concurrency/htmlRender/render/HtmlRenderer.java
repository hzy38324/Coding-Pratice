package com.sexycode.codepractice.concurrency.htmlRender.render;

import com.sexycode.codepractice.concurrency.htmlRender.entity.ImageData;
import com.sexycode.codepractice.concurrency.htmlRender.entity.ImageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface HtmlRenderer {
    Logger logger = LoggerFactory.getLogger(HtmlRenderer.class);
    int DEFAULT_ELE_NUM = 5;

    void renderPage(String source) throws Exception;

    default void renderText(String source) throws InterruptedException {
        logger.info("go into renderText");
        TimeUnit.SECONDS.sleep(1);
        logger.info("finish renderText");
    }

    default List<ImageInfo> scanForImageInfo(String source) {
        logger.info("go into scanForImageInfo");
        return Collections.nCopies(DEFAULT_ELE_NUM, new ImageInfo());
    }

    default void renderImage(ImageData imageData) throws InterruptedException {
        logger.info("go into renderImage");
        TimeUnit.SECONDS.sleep(1);
        logger.info("finish renderImage");
    }
}
