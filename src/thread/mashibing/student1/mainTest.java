package thread.mashibing.student1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:测试Atomic。。。方法
 * @Date: 2019/7/19
 * @Author 王通
 * @Version 1.0
 */

public class mainTest {

  AtomicInteger count = new AtomicInteger();
  //int count = 0;
     synchronized void m() {
        for(int i=0;i<10000000;i++){
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        mainTest t = new mainTest();
        List<Thread> threads = new ArrayList<Thread>();
        for(int i=0;i<10;i++){
            threads.add(new Thread(t::m, "thread-" + i));
        }
        Long end = System.currentTimeMillis();
        System.out.println("现在时间："+ end);
        threads.forEach((o)->{
            o.start();
        });
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("时间差："+(System.currentTimeMillis()-end));
        System.out.println(t.count.get());

    }
}
