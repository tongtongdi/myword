package thread.chapter2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QuenTest {
    private static Queue<String> queue = new ConcurrentLinkedQueue<>();
    static {
        for(int i=0;i<1000;i++){
            queue.add("飘飘：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                while (true){
                    String d = queue.poll();
                    if(d==null){
                        break;
                    }
                    System.out.println(d);
                }
            }).start();
        }
    }
}
