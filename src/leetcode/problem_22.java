package leetcode;

import java.util.*;

/**
 * @Description:
 * @Date: 2019/7/29
 * @Author 王通
 * @Version 1.0
 */

public class problem_22 {

    public static List<String> generateParenthesis(int n) {
        if(n==0) return new ArrayList<>();
        List<String>[] lists = new List[n+1];
        lists[1] = Arrays.asList("()");
        for (int i = 2; i <= n; i++) {
            Set<String> newSet = new HashSet<>();
            List<String> list = new ArrayList<>();
            for (String s : lists[i - 1]) {
                for (int j = 0; j <= s.length(); j++) {
                    String b = s.substring(0, j) + "()" + s.substring(j);
                    newSet.add(b);
                }
            }
            for (String s : newSet) {

                list.add(s);
            }
            lists[i] = list;
        }
        return lists[n];
    }
    public static List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        changeIt("", list, n, n);
        return list;
    }

    public static void changeIt(String s, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
        }
        if (right > left) {
            changeIt(s + ")", result, left, right - 1);
        }
        if (left > 0) {
            changeIt(s+"(",result,left-1,right);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis2(3));
    }
}
