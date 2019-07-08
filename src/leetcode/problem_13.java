package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Date: 2019/7/8
 * @Author 王通
 * @Version 1.0
 */

public class problem_13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MMCMXCIV"));
    }
    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0;
        int pre = 0;
        for(int i=s.length()-1;i>=0;i--){
            int nowInde = map.get(s.charAt(i));
            if(pre>nowInde){
                sum = sum-nowInde;
                continue;
            }
            pre = nowInde;
            sum = sum + nowInde;
        }
        return sum;
    }
}
