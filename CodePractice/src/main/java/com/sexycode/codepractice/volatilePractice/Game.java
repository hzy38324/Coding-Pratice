package com.sexycode.codepractice.volatilePractice;

/**
 * <p>
 *
 * @author: hzy created on 2018/02/04
 */
public class Game {

    public static void main(String[] args) throws InterruptedException {
        // Game begun! Init goalNotifier thread
        GoalNotifier goalNotifier = new GoalNotifier();
        Thread goalNotifierThread = new Thread(goalNotifier);
        goalNotifierThread.start();

        // After 3s
        Thread.sleep(3000);
        // Goal !!!
        goalNotifier.setGoal(true);
    }

}
