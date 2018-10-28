package com.sexycode.codepractice.concurrency.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;


/**
 * Created by hongzeyang
 * Time 2018/10/28 上午11:33
 * Desc
 */
public class OneShotLatch {

    public static final int STATE_OPEN = 1;

    public static final int SUCCESS = 1;

    public static final int FAIL = -1;

    private final Sync sync = new Sync();


    public void release() {
        sync.releaseShared(0);
    }


    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }


    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected int tryAcquireShared(int nothing) {
            return getState() == STATE_OPEN ? SUCCESS : FAIL;
        }


        @Override
        protected boolean tryReleaseShared(int nothing) {
            setState(STATE_OPEN);
            return true;
        }
    }
}
