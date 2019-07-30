package Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/7/8
 * @Author 王通
 * @Version 1.0
 */

public class Main {
    public static void main(String[] args) {
        String s = "1234567890";
        for (int i = 0; i <= s.length(); i++) {
            String b = s.substring(0, i) + "()" + s.substring(i);
            System.out.println(b);
        }
    }

    public static void changeIt(int [] number,int star,int end){
        int mid = number[0];
        int begin = star;
        int finalNum = end;

    }
}
