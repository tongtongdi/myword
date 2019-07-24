package thread.chapter3;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {

       // Map<String, String> map = new ConcurrentHashMap<>();
       // Map<String, String> map = new Hashtable<>();
        Map<String, String> map = new ConcurrentSkipListMap<>();
        Thread[] threads = new Thread[100];
        Random r = new Random();
        Long star = System.currentTimeMillis();
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(()->{
                for(int j=0;j<10000;j++){
                    map.put("admin"+r.nextInt(10000), "number" + r.nextInt(10000));
                }
            });
        }
        Arrays.asList(threads).forEach((m)->{
            m.start();
        });
        Arrays.asList(threads).forEach((m)->{
            try {
                m.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-star));

    }
}
