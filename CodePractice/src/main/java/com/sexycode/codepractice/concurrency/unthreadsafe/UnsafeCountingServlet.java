package com.sexycode.codepractice.concurrency.unthreadsafe;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: hzy
 * @since:
 */
public class UnsafeCountingServlet extends GenericServlet implements Servlet {
    private long count = 0;

    public long getCount() {
        return count;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ++count;
        // To something else...
    }
}
