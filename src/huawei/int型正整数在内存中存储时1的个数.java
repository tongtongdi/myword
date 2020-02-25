package huawei;

import java.util.Scanner;

public class int型正整数在内存中存储时1的个数 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int count = 0;
            int num = input.nextInt();
            int flat = 1;
            while (flat<=num){
                if ((num & flat) != 0) {
                    count++;
                }
                flat = flat<<1;
            }
            System.out.println(count);
        }
    }
}
