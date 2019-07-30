package thread.mashibing.student2;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description:
 * @Date: 2019/7/24
 * @Author 王通
 * @Version 1.0
 * 写时复制list
 */

public class CopyOnWriterList {

    public static void main(String[] args) {
        List<String> numbers =
                //new Vector<>();
                new LinkedList<>();
               // new CopyOnWriteArrayList<>();///事件监听器，会用到大内存
        Random r = new Random();
        Thread[] threads = new Thread[100];
        for(int i=0;i<100;i++){
            threads[i] = new Thread(()->{
                for(int j=0;j<1000;j++){
                    numbers.add("thee" + r.nextInt(10000));
                }
            });
        }
        Long start = System.currentTimeMillis();
        for(int i=0;i<100;i++){
            try {
                threads[i].start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<100;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println("list大小:"+numbers.size());
    }

}
