package huawei;

import java.util.Map;
import java.util.Scanner;

/**
 * @Description:背包问题的强化版本
 * 题目没有说一键东西是否可以重复买，
 * 这样算的话，就表示了我买东西
 * 这个选法，必须要按照顺序输入人，
 * @Date: 2019/7/26
 * @Author 王通
 * @Version 1.0
 */

public class 购物单 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            //表示总钱数，
            int m = input.nextInt();
            //表示要卖多少个、是总共有多少个商品
            int n = input.nextInt();
            int price[] = new int[n + 1];
            int star[] = new int[n + 1];
            int fa[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                price[i] = input.nextInt();
                star[i] = price[i]*input.nextInt();
                fa[i] = input.nextInt();
            }
            int dp[][] = new int[n + 1][m + 1];
            for(int i=1;i<=n;i++){
                for (int j = 1; j <= m; j ++) {
                    if(fa[i]==0){
                        if (price[i] < j) {
                            dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-price[i]]+star[i]);
                        }
                    }else{
                        if (price[i]+price[fa[i]] < j) {
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i] - price[fa[i]] + star[i] + star[fa[i]]]);
                        }
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
