package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/8/5
 * @Author 王通
 * @Version 1.0
 */

public class problem_30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s.length()==0){
                return list;
        }
        int wordLength = words[0].length();
        int length = words.length*words[0].length();
        for (int i = 0; i <= s.length() - length; i++) {
           // System.out.println("检查i"+i);
            if(checkItCan(s.substring(i,i+length),words)){
                list.add(i);
            }
        }
        return list;
    }
    public static boolean checkItCan(String s,String[] words){
        //int length = words.length;
        int charLength = words[0].length();
        int[] number = new int[s.length()];
        for(int i=0;i<number.length;i+=charLength){
            number[i] = 1;
        }
        for (int i = 0; i < words.length; i++) {
            int num = getIndex(s,words[i],charLength);
            //System.out.println("这个num:"+num+"zhege:"+s+"这个检查:"+words[i]+"长度:"+charLength);
            if(num==-1) return false;
            else{
                number[num] = 0;
                s = s.substring(0, num) + s.substring(num + charLength, s.length());
            }
        }
        if(s.length()<=0) return true;
        else{
            return false;
        }
    }

    public static int getIndex(String s,String c,int x){
        int num = -1 ;
        for(int i=0;i<=s.length()-x;i+=x){
            if(c.equals(s.substring(i,i+x))){
                num = i;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "ababaab";
        String[] words = new String[]{"ab","ba","ba"};
        System.out.println(findSubstring(s,words));
    }
}
