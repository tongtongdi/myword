package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 字串的连接最长路径查找 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int number = input.nextInt();
            String[] numbers = new String[number];
            for(int i=0;i<numbers.length;i++){
                numbers[i] = input.next();
            }
            Arrays.sort(numbers);
            for (String s : numbers) {
                System.out.println(s);
            }
        }
    }
}
