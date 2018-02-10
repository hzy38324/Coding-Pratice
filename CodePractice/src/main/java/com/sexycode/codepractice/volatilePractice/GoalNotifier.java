package com.sexycode.codepractice.volatilePractice;

/**
 * <p>
 *
 * @author: hzy created on 2018/02/04
 */
public class GoalNotifier implements Runnable {
    public boolean goal = false;
//    public volatile boolean goal = false;

    public boolean isGoal() {
        return goal;
    }

    public void setGoal(boolean goal) {
        this.goal = goal;
    }

    @Override
    public void run() {
        while (true) {
            if (isGoal()) {
                System.out.println("Goal !!!!!!");

                // Tell the referee the ball is in.
                // ...

                // reset goal flag
                setGoal(false);
            }
        }
    }
}
