package leetcode;

/**
 * @Description:
 * @Date: 2019/7/30
 * @Author 王通
 * @Version 1.0
 */

public class problem_22_1 {
    public static void main(String[] args){
        String s="abc";
        pailie(s,"");
    }
    public static void pailie(String s, String temp){//参数设计地尽量地简洁
            System.out.println(temp);
        for(int i=0;i<s.length();i++){
            String news=s.substring(0, i)+s.substring(i+1,s.length());//去掉String中的某个字母
            pailie(news, temp+s.charAt(i));
        }
    }
}
