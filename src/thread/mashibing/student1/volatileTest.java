package thread.mashibing.student1;

/**
 * @Description:
 * @Date: 2019/7/18
 * @Author 王通
 * qq:729728698
 * @Version 1.0
 */

public class volatileTest {

    //初始状态为true
    //boolean run = true;
    volatile boolean run = true;

    //线程中的方法
    void showStart(){
        System.out.println("showStart is running.....");
        while (run){

        }
        System.out.println("showStart is ending....");
    }


    public static void main(String[] args) throws InterruptedException {
        volatileTest volatileTest = new volatileTest();
        //线程一启动
        new Thread(()->{
            volatileTest.showStart();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //主线程休眠一秒
        Thread.sleep(1000);

        //线程二启动
        new Thread(()->{
            volatileTest.run = false;
        }).start();
    }
}
