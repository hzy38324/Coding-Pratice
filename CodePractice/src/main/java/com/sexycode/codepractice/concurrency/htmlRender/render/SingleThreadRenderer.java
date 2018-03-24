package com.sexycode.codepractice.concurrency.htmlRender.render;

import com.sexycode.codepractice.concurrency.htmlRender.entity.ImageData;
import com.sexycode.codepractice.concurrency.htmlRender.entity.ImageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/13
 */
public class SingleThreadRenderer implements HtmlRender {

    public void renderPage(String source) throws Exception {
        renderText(source);

        List<ImageData> imageData = new ArrayList<ImageData>();
        for (ImageInfo imageInfo : scanForImageInfo(source))
            imageData.add(imageInfo.downloadImage());

        for (ImageData data : imageData)
            renderImage(data);
    }

}