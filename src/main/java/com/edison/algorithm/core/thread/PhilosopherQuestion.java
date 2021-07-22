package com.edison.algorithm.core.thread;

/**
 * 描述:
 * 哲学家进餐
 *
 * @author gengyongchang
 * @create 2021-07-20 13:17
 */
public class PhilosopherQuestion {
    private boolean[] used = new boolean[]{false, false, false, false, false};
    private static String LOCK = "lock";

    public static void main(String[] args) {
        PhilosopherQuestion philosopherQuestion = new PhilosopherQuestion();
        philosopherQuestion.new Philosopher(0).start();
        philosopherQuestion.new Philosopher(1).start();
        philosopherQuestion.new Philosopher(2).start();
        philosopherQuestion.new Philosopher(3).start();
        philosopherQuestion.new Philosopher(4).start();


    }

    class Philosopher extends Thread {
        private int num;

        public Philosopher(int num) {
            this.num = num;
        }

        public void eating() {
            System.out.println("my num is" + num + ",I am eating...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void thinking() {
            System.out.println("my num is " + num + ", I am thinking ...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void takeChopsticks() {
            synchronized (LOCK) {
                int min = Math.min(num, (num + 1) % 5);
                int max = Math.max(num, (num + 1) % 5);
                if (!used[min]) {
                    used[min] = true;
                    if (!used[max]) {
                        used[max] = true;
                    } else {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }

        public void putDownChopsticks() {
            synchronized (LOCK) {
                used[num] = false;
                used[(num + 1) % 5] = false;
                System.out.println("my num is" + num + ", I have finished...");
                LOCK.notifyAll();
            }

        }

        @Override
        public void run() {
            while (true) {
                thinking();
                takeChopsticks();
                eating();
                putDownChopsticks();
            }
        }
    }
}