package com.sexycode.codepractice.concurrency.htmlRender.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/24
 */
public class ImageInfo {
    private Logger logger = LoggerFactory.getLogger(ImageInfo.class);

    public ImageData downloadImage() throws InterruptedException {
        logger.info("go into downloadImage");

        TimeUnit.SECONDS.sleep(1);

        logger.info("finish downloadImage");

        return new ImageData();
    }
}
