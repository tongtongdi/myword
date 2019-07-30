package thread.mashibing.queue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Date: 2019/7/24
 * @Author 王通
 * @Version 1.0
 */

public class DelayTest {

    static DelayQueue<Mytask> delayQueue = new DelayQueue<>();

    static Random r = new Random();

    static class Mytask implements Delayed {
        long runtime;

        Mytask(Long time){
            runtime = time;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runtime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            }else if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)){
                return 1;
            }else{
                return 0;
            }
        }

        @Override
        public String toString(){
            return String.valueOf(this.runtime);
        }
    }

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        Mytask t1 = new Mytask(now + 1000);
        Mytask t2 = new Mytask(now + 1500);
        Mytask t3 = new Mytask(now + 2000);
        Mytask t4 = new Mytask(now + 500);
        Mytask t5 = new Mytask(now + 2500);
        delayQueue.put(t1);
        delayQueue.put(t2);
        delayQueue.put(t3);
        delayQueue.put(t4);
        delayQueue.put(t5);
        System.out.println(delayQueue);
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(delayQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*while (delayQueue.size()>0) {
            System.out.println(delayQueue.poll());
        }*/

    }
}
