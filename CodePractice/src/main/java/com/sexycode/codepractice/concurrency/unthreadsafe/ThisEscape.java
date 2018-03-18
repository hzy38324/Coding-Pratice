package com.sexycode.codepractice.concurrency.unthreadsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hzy
 * @since:
 */
public class ThisEscape {
    private final List<Event> listOfEvents;

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        listOfEvents = new ArrayList<Event>();
    }

    void doSomething(Event e) {
        listOfEvents.add(e);
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}