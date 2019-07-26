package leetcode;

import java.util.Stack;

/**
 * @Description:
 * @Date: 2019/7/24
 * @Author 王通
 * @Version 1.0
 *
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 *
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class problem_1021 {
    /**
     * 解法一
     * @param S
     * @return正常思路一般思路
     */
    public static String removeOuterParentheses(String S) {
        if(S==null || S.length()==0) return "";
        int len = S.length();
//         StringBuilder newStr = new StringBuilder();
        StringBuffer newStr = new StringBuffer(S);
        Stack<Character> charStack = new Stack<>();
        int start = 0;
        for(int i=0;i<len;i++){
            if(S.charAt(i)=='('){
                charStack.push(S.charAt(i));
            }else{
                charStack.pop();
            }
            if(charStack.empty() && i!=0){
                String ad = S.substring(start+1,i);
                newStr.append(ad);
                start = i+1;
            }
        }
        return newStr.toString();
    }

    /**
     * 这个有点厉害的思路
     * 用一个计数器初始值为0，走起，然后进行加加操作，我遇到(加加，遇到)减减，当leftCount>1就是在(里面有(的时候
     * 我把你再放进来，然后再等到leftcount==0的时候，表示遍历过的就是题目所说的原语，不用把最后一个字符放进来,
     * 于是保证leftcount>0就可以，你不得不感叹，感叹，别人的脑子是多么的棒！！！！
     * @param S
     * @return
     */
    public static String removeOuterParentheses2(String S) {
        if(S==null || S.length()==0) return "";
        StringBuilder sb = new StringBuilder();
        int leftCount=0;
        for (int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c=='(') {
                leftCount++;
                if (leftCount>1) sb.append(c);
            }
            else{
                leftCount--;
                if(leftCount>0)  sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Long begin = System.nanoTime();
        String s = removeOuterParentheses2("()(())(())(()())()()()(())()()()()(())(())()(()())(())((())(()(()())(())()()()))()()()()((()))()()(())");
        Long end = System.nanoTime();
        System.out.println("结果："+s);
        System.out.println("耗时(纳秒):"+(end-begin));
    }
}
