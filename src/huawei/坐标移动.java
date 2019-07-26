package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Date: 2019/7/26
 * @Author 王通
 * @Version 1.0
 */

public class 坐标移动 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String num = input.next();
            String[] nums = num.split(";");
            int i = 0,j = 0;
            for (String a : nums) {
                char go;
                int bu;
                if(a.length()>1){
                    go = a.charAt(0);
                    try {
                        bu = Integer.valueOf(a.substring(1));
                    } catch (NumberFormatException e) {
                        bu= 0;
                    }
                }else if(a.length()==1){
                    go = a.charAt(0);
                    bu = 1;
                }else {
                    go = 'E';
                    bu = 0;
                }
                switch (go){
                    case 'A':{ i = i-bu;break;}
                    case 'D':{ i = i+bu;break;}
                    case 'S':{ j = j-bu;break;}
                    case 'W':{ j = j+bu;break;}
                }
            }
            System.out.println(i+","+j);
        }
    }
}
