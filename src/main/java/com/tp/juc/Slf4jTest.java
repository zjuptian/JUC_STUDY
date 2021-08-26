package com.tp.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Slf4jTest {
    public static void main(String[] args) {
        new Thread(() -> {
            log.info("t1");
        }, "t1").start();
        log.info("1111");
    }
}
