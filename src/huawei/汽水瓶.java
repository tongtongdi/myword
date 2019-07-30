package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Date: 2019/7/28
 * @Author 王通
 * @Version 1.0
 */

public class 汽水瓶 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        List<Integer> list = new ArrayList<>();
        while ((input = bufferedReader.readLine()) != null) {
            if(input.length()<=0) break;
            list.add(Integer.valueOf(input));
        }
        for (int i : list) {
            int n = 0;
            while (i >= 3) {
                int w = i/3;
                n+=w;
                i = i / 3 + i % 3;
            }
            System.out.println(n);
        }
    }

    public static int num(int d) {
        return d/3;
    }
}
