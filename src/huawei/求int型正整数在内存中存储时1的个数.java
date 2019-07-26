package huawei;

import java.util.Scanner;

/**
 * @Description:
 * @Date: 2019/7/26
 * @Author 王通
 * @Version 1.0
 */

public class 求int型正整数在内存中存储时1的个数 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*while (input.hasNext()) {
            int number = input.nextInt();
            int test = number;
            int count = 0;
            while (test!=0){
                test = test & (test-1);
                count++;
            }
            System.out.println(count);
        }*/
        while (input.hasNext()){
            int number = input.nextInt();
            int test = number;
            int count = 0;
            int f = 1;
            while (f<=test){
                if ((test & f) >= 1) {
                    count++;
                }
                f = f<<1;
            }
            System.out.println(count);
        }
    }
}
