package thread.生产者;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Date: 2019/7/22
 * @Author 王通
 * @Version 1.0
 */

public class StoreWork<T> {

    private final int MAX = 10;

    private LinkedList<T> list = new LinkedList<>();

    private Lock lock = new ReentrantLock();

    private Condition produceLock = lock.newCondition();

    private Condition consumeLock = lock.newCondition();
    public void produce(T t){
        try {
            lock.lock();
            while (list.size()>=10){
                produceLock.await();
            }
            list.add(t);
            Thread.sleep(10);
            System.out.println("produce++"+list.size());
            consumeLock.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public T consume(){
        T t = null;
        try {
            lock.lock();
            while (list.size()<=0){
                consumeLock.await();
            }
            Thread.sleep(10);
            t =  list.removeFirst();
            System.out.println("consume--"+list.size());
            produceLock.signal();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        StoreWork<String> sw = new StoreWork<>();
        for(int i=0;i<100;i++){
            new Thread(()->{
                sw.produce(Thread.currentThread().getName()+"=======");
            },"produce-"+i).start();
        }
        for(int i=0;i<100;i++){
            new Thread(()->{
               sw.consume();
            },"consume-"+i).start();
        }
    }
}
