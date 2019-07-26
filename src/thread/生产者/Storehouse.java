package thread.生产者;

/**
 * @Description:
 * @Date: 2019/7/22
 * @Author 王通
 * 这个方法用wait和notify进行编码
 * @Version 1.0
 */

public class Storehouse {

    private final int MAX = 10;
    private int number = 1;

    public synchronized void producer(){
        while (number>=MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println("生产者:"+number);
        this.notifyAll();
    }
    public synchronized void consumer(){
        while (number<=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println("消费者---"+number);
        this.notifyAll();
    }

    public static void main(String[] args) {
        Storehouse storehouse = new Storehouse();
        new Thread(()->{
            for(int i=0;i<10;i++){
                storehouse.producer();
            }
        }).start();
        new Thread(()->{
            for(int i=0;i<100;i++){
                storehouse.consumer();
            }
        }).start();
    }
}
