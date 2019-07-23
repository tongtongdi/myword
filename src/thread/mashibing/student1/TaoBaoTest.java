package thread.mashibing.student1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/7/19
 * @Author 王通
 * @Version 1.0
 */

public class TaoBaoTest {

     volatile List<Object> lists = new ArrayList();

    public void add(Object o){
        lists.add(o);
    }

    public Integer size(){
        return lists.size();
    }

    public static void main(String[] args) {
        TaoBaoTest tbt = new TaoBaoTest();
        Object o = new Object();
        Thread t1 = new Thread(()->{
            synchronized (o){
           for (int i=1;i<10;i++){
                   tbt.add(1);
               System.out.println(Thread.currentThread().getName()+"输出："+i);
                   if(i==5){
                       o.notify();
                       try {
                           o.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
            }
        },"t1");
        Thread t2 = new Thread(()->{
                synchronized (o){
                    if(tbt.size()!=5){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    o.notify();
                }
            System.out.println("执行结束！"+Thread.currentThread().getName());
        },"t2");
        t2.start();
        t1.start();



    }

}
