package thread.mashibing.student2;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(5);
        for(int i=0;i<6;i++){
            e.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.out.println("当前线程名字："+Thread.currentThread().getName());
            });
        }
        e.shutdown();
        System.out.println(e.isTerminated());
        System.out.println(e.isShutdown());
        System.out.println(e);
    }
}
