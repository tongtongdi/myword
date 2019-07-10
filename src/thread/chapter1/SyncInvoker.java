package thread.chapter1;

/**
 * @Description:
 * @Date: 2019/7/8
 * @Author 王通
 * @Version 1.0
 */

public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        Future<String> submit = futureService.submit(() -> {
            try {
                Thread.sleep(10001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        },System.out::println);
        System.out.println("=============");
        System.out.println("do someThing else");
        Thread.sleep(1000);

        System.out.println("=============");
    }
    private static String get() throws InterruptedException{
        Thread.sleep(10000);
        return "FINISH";
    }
}
