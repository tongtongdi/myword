package leetcode;

/**
 * @Description:
 * @Date: 2019/7/29
 * @Author 王通
 * @Version 1.0
 */

public class problem_10 {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) return true;
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if(p.charAt(j)=='*'){
                if(j==p.length()-1) return true;
                while (i<s.length()){

                }
            }
        }
        return true;
    }
}
