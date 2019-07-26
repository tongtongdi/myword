package thread.生产者;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Description:
 * @Date: 2019/7/25
 * @Author 王通
 * @Version 1.0
 */

public class QueueTest {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>(10);
        Random r = new Random(1000);
        new Thread(()->{
            for (int i=0;i<1000;i++){
                try {
                    Thread.sleep(100);
                    System.out.println("生产者:"+"thread-"+i);
                    queue.put("thread-"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        Thread[] xiaofei = new Thread[10];
        for(int i=0;i<xiaofei.length;i++){
            xiaofei[i] = new Thread(()->{
                try {
                    for(int j=0;j<100;j++){
                        System.out.println("消费者:"+Thread.currentThread().getName()+"消费:"+queue.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        for(Thread t:xiaofei){
            t.start();
        }

        Boolean e = 12 % 10 == 0 ? true : false;

        TreeNode node = new DefaultMutableTreeNode();

    }
}
