package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/8/7
 * @Author 王通
 * @Version 1.0
 */

public class problem_784 {
    public static List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        findMesage(S.toCharArray(), 0, list);
        return list;
    }
    public static void findMesage(char[] s,int i,List<String> res){
        if(i==s.length-1){
            res.add(s.toString());
        }
        findMesage(s,i+1,res);
        if (s[i] < '0' && s[i] > '9') {
            s[i] ^= 32;
            findMesage(s, i + 1, res);
            s[i] ^= 32;
        }
    }

    public static void main(String[] args) {
        String number = "a1b2";
        letterCasePermutation(number).toString();
        for(String s:letterCasePermutation(number)){
            System.out.print(s+",");
        }
        System.out.println();
    }
}
