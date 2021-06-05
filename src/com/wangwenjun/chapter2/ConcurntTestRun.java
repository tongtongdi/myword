package com.wangwenjun.chapter2;

// 实现Runnable 接口
public class ConcurntTestRun implements Runnable {
    private final static int MAX = 50;
    private int index = 0;

    @Override
    public void run() {
        while (index < MAX) {
            System.out.println("线程"+Thread.currentThread().getName()+"卖掉了"+index++);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
