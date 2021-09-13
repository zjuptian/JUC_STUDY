package com.tp.juc.test;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2021/9/13
 *
 * @author Patric Tian
 */
@Slf4j
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("2");
        }, "t2");

        Thread t1 = new Thread(() -> {
            //t2 insert
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("1");
        }, "t1");

        t1.start();
        t2.start();

    }
}
