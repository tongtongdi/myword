package thread.mashibing.student2;

import java.util.concurrent.Executor;

//执行器
//执行器执行方法
public class Excutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        Executor e = new Excutor();
        e.execute(()->{
            System.out.println("admin"+Thread.currentThread().getName());
        });
    }
}
