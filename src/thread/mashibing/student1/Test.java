package thread.mashibing.student1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/7/18
 * @Author 王通
 * @Version 1.0
 */

public class Test {

    private static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        Thread t1 = new Thread(()->{
            for(int i=0;i<1000;i++){
                number++;
            }

        });
        t1.start();
        Thread.sleep(1000);
        System.out.println(number);
    }
}
