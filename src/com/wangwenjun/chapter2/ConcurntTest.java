package com.wangwenjun.chapter2;

import thread.chapter2.TicketSeller;

/**
 * 这个方法很挫，把变量都声明成为了静态方法来使用
 */
public class ConcurntTest {
    public static void main(String[] args) {
        TickTable tickTable = new TickTable("桌子1");
        tickTable.start();
        TickTable tickTable1 = new TickTable("桌子2");
        tickTable1.start();
        TickTable tickTable2 = new TickTable("桌子3");
        tickTable2.start();
    }
}

class TickTable extends Thread {

    private static final int tickNum = 100;
    private static int index = 1;
    private String name;



    public TickTable(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        while (index <= 100) {
            System.out.println("柜台："+this.name + "售卖了："+ index++);
        }
    }
}
