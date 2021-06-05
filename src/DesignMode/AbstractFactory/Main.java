package DesignMode.AbstractFactory;

public class Main {
    static final String a = "dfasdf";
    static final String b = "afdsf";
    public static void main(String[] args) {
        int[] string = new int[5];
        new Thread(()-> {
            while (true) {
                synchronized (a) {
                    System.out.println("获取到a");
                    synchronized(b) {
                        System.out.println("获取到b");
                    }
                }
            }
        }).start();
        new Thread(()-> {
            while (true) {
                synchronized (b) {
                    System.out.println("获取到b");
                    synchronized(a) {
                        System.out.println("获取到a");
                    }
                }
            }
        }).start();
    }
}
