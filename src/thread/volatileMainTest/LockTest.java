package thread.volatileMainTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Date: 2019/7/22
 * @Author 王通
 * @Version 1.0
 */

public class LockTest {

    public int number = 50000;
    public static void main(String[] args) {
        LockTest lt = new LockTest();
        Object o = new Object();
        Lock lock = new ReentrantLock();
        new Thread(()->{


            while (true){

                if(lt.number<=0) break;
                  lt.number--;
                  System.out.println(Thread.currentThread().getName()+"===="+lt.number);

            }

        },"thread-1").start();
        new Thread(()->{
                while (true){

                    if(lt.number<=0) break;
                    lt.number--;
                    System.out.println(Thread.currentThread().getName()+"====="+lt.number);


            }

        },"thread-2").start();
    }
}
