package com.wangwenjun.chapter2;

public class MainTest {
    public static void main(String[] args) {
        ConcurntTestRun concurntTestRun = new ConcurntTestRun();
        new Thread(concurntTestRun).start();
        new Thread(concurntTestRun).start();
        new Thread(concurntTestRun).start();
    }
}
