package com.tp.juc.test;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2021/8/26
 *
 * @author Patric Tian
 */
@Slf4j
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(() -> {
            log.info("hello");
        }, "t1").start();
    }
}
