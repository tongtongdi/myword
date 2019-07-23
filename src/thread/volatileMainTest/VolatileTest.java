package thread.volatileMainTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/7/19
 * @Author tongtongdi
 * @Version 1.0
 */

public class VolatileTest {

    //运行开关
    private int count = 0;

    synchronized void m(){
        for(int i=0;i<100000;i++){
            count++;
        }
    }
    public static void main(String[] args) {

        //创建一个对象
        VolatileTest vt = new VolatileTest();
        //定义一个线程list
        List<Thread> threads = new ArrayList<>();
        //初始化线程
        for(int i=0;i<10;i++){
            threads.add(new Thread(()->{
                vt.m();
            },"thread"+i));
        }
        //线程启动
        threads.forEach((o)->{
            o.start();
        });
        //子线程执行主线程等待
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(vt.count);



    }

}
