package leetcode;

import java.util.Arrays;

/**
 * @Description:
 * @Date: 2019/7/23
 * @Author 王通
 * @Version 1.0
 */

public class problem_121 {

    public int maxProfit(int[] prices) {
        int N = prices.length;
        if(prices.length<=1) return 0;
        int[] Sub = new int[N];
        Sub[0] = 0;
        int min = Math.min(prices[0],prices[1]);
        Sub[1] = prices[1] - prices[0] <0 ? 0:prices[1] - prices[0];
        for(int i=2;i<prices.length;i++){
            if(prices[i]<min){
                Sub[i] = Sub[i-1];
                min = prices[i];
            }else{
                Sub[i] = Math.max(Sub[i-1],prices[i] - min);

            }
        }
        return Sub[N-1];
    }

    public static void main(String[] args) {
        problem_121 p = new problem_121();
        int[] numb = new int[]{7,1,5,3,6,4};
        System.out.println(p.maxProfit(numb));
    }
}
