package thread.mashibing.map;

import thread.chapter1.Future;

import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @Date: 2019/7/24
 * @Author 王通
 * @Version 1.0
 */

public class ConCurentLinkentMap {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedBlockingDeque<>();
        Thread[] threads = new Thread[100];
        Random r = new Random();
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(()->{
                for(int j=0;j<100;j++){
                    try {
                        queue.add("Thread"+ r.nextInt(1000));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        showIt(threads);
        System.out.println(queue.size());
    }
    public static void showIt(Thread[] threads){
        long start = System.currentTimeMillis();
        for(Thread t:threads){
            t.start();
        }
        for(Thread t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("时间:"+(end-start));
    }
}
