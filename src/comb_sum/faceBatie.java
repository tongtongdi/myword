package comb_sum;

import java.util.Scanner;

/**
 * @Description:
 *将整数m分成任意n个数的和，然后都输出出来，不允许为空/允许为空，
 * 这个问题可以排列组合的问题，就是将m个苹果放在n个篮子里面，苹果相同，篮子相同，为空不为空没说
 * @Date: 2019/7/23
 * @Author 王通
 * @Version 1.0
 */

public class faceBatie {
    /**
     * 分成n个数，数可以为0
     * 动态规划========
     * 转化为苹果篮子的思路，然后可以选择给每个篮子放一个苹果，或者不放，两种可能，不放就意味着至少有一个篮子是空的。
     * 那么每个篮子放一个苹果就是（m-n,n）,不放就是(m,n-1)然后得到公式:f(m,n) = f(m-n,n)+f(m,n-1);
     * 然后进行动态规划，这个方法只能求出来总共多少种吗？
     * 这个问题也是走棋盘、杨辉三角、一类。。。。
     * @param m 整数
     * @param n 分成几份
     * @return 返回多少种分法
     */
    public static int numberSum(int m, int n) {
        int numbers[][] = new int[m+1][n+1];
        //m个苹果放在一个篮子里面只有一种方法，1个苹果放在n个篮子也是一种，0个苹果放在n个篮子是1种，m个苹果放在0个篮子也是0种，0个苹果放在0个篮子里面是一种，没地方放
        //初始化一哈
        for(int i=0;i<n;i++){
            numbers[0][i] = 0;
        }
        for(int i=0;i<m;i++){
            numbers[i][0] = 1;
        }
        for(int i=0;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i>=j){
                    numbers[i][j] = numbers[i-j][j]+numbers[i][j-1];
                }else{
                    numbers[i][j] = numbers[i][i];
                }
            }
        }
        return numbers[m][n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer number = input.nextInt();
        int result = 0;
        for(int i=0;i<number;i++){
            System.out.println();
            result+=numberSum(number,i);
        }
        System.out.println(result);
    }

}
