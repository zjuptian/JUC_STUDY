package com.tp.juc.exercise;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2021/9/13
 *
 * @author Patric Tian
 */
@Slf4j
public class PrintBySort {
    private static int flag = 1;

    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (true) {
                    while (flag != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    log.info("a");
                    flag = 2;
                    lock.notifyAll();
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                while(true) {
                    while (flag != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    log.info("b");
                    flag = 3;
                    lock.notifyAll();
                }

            }
        }, "t2");

        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                while(true) {
                    while (flag != 3) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    log.info("c");
                    flag = 1;
                    lock.notifyAll();
                }
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
