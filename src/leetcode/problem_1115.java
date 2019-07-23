package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Date: 2019/7/22
 * @Author 王通
 * @Version 1.0
 */

public class problem_1115 {
    private int n;
    private int st = 1;
    Lock lock = new ReentrantLock();
    Condition fooCd =  lock.newCondition();
    Condition bar = lock.newCondition();
    public problem_1115(int n) {
        this.n = n;

    }
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if(st!=1){
                fooCd.await();
            }
            st = 2;
            printFoo.run();
            bar.signal();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.

    }
    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if(st!=2){
                bar.await();
            }
            st = 1;
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooCd.signal();
            }
    }

}
