package com.sexycode.codepractice.concurrency.htmlRender.test;

import com.sexycode.codepractice.concurrency.htmlRender.render.CompletionServiceRenderer;
import com.sexycode.codepractice.concurrency.htmlRender.render.FutureRenderer;
import com.sexycode.codepractice.concurrency.htmlRender.render.SingleThreadRenderer;
import org.junit.Test;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/24
 */
public class RenderTest {

    public static final String DEFAULT_SOURCE = "<html><h1>Hello World</h1><img src='hi.png'></img></html>";

    @Test
    public void test_SingleThreadRenderer() throws Exception {
        new SingleThreadRenderer().renderPage(DEFAULT_SOURCE);
    }

    @Test
    public void test_FutureRenderer() throws Exception {
        new FutureRenderer().renderPage(DEFAULT_SOURCE);
    }
    @Test
    public void test_CompletionServiceRenderer() throws Exception {
        new CompletionServiceRenderer().renderPage(DEFAULT_SOURCE);
    }

}
