package mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *将一个正整数m分为n个正整数相加的和
 * 这个题可以转化为将m个苹果放在n个篮子里面，篮子不能为空，且苹果和篮子都一样，哇，第一反应肯定是动态规划，但怎么动、怎么规、怎么划
 * 12折组合问题？
 * 走棋盘问题，有没有很像
 * @author wangtong
 */

public class TryIt {
    /**
     * 常见的求一共多少种
     * @param args
     */
    /*public static void main(String[] args) {
        //
        int m = 5;
        int[][] number = new int[m+1][m+1];
        //m个苹果放在一个篮子里面只有一种
        for(int i =0;i<m+1;i++){
            number[i][1] = 1;
        }
        for(int i=1;i<m+1;i++){
            for(int j=2;j<i+1;j++){
                //既然篮子都不能为空，那么就是有一个篮子里面放了一个，所有篮子至少两个。这两种情况去分析
                number[i][j] = number[i-1][j-1]+number[i-j][j];
            }
        }
        int sum = 0;
        for(int j=1;j<m+1;j++){
            sum+=number[m][j];
        }
        System.out.println(sum);
    }*/

    /**
     * 打印出多少种
     * @param args
     *//*
    public static void main(String[] args) {
        //
        int m = 5;
        if(m==0){
            System.out.println(0);
            return ;
        }
        List<String>[][] number = new List[m+1][m+1];
        //m个苹果放在一个篮子里面只有一种
        for(int i=0;i<m+1;i++){
            for(int j=0;j<m+1;j++){
                number[i][j] = new ArrayList<String>();
            }
        }
        for(int i =0;i<m+1;i++){
            List<String> n = new ArrayList<String>(i);
            n.add(""+i);
            number[i][1] = n;
        }
        for(int i=1;i<m+1;i++){
            for(int j=2;j<i+1;j++){
                //既然篮子都不能为空，那么就是有一个篮子里面放了一个，所有篮子至少两个。这两种情况去分析
                List<String> l1 = number[i-1][j-1];
                List<String> l2 = number[i-j][j];
                List<String> list = new ArrayList<>();
                l1.addAll(l2);
                for(int d=0;d<l1.size();d++){
                    list.add(j+"+"+l1.get(d));
                }
            number[i][j] =list;
            }
        }

        for(int i=1;i<m+1;i++){
            System.out.println(number[m][i]);
        }
    }*/
    public static void main(String[] args) {
        //
        int m = 5;
        if (m == 0) {
            System.out.println(0);
            return;
        }
        List<String>[][] number = new List[m + 1][m + 1];
        //m个苹果放在一个篮子里面只有一种
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                number[i][j] = new ArrayList<String>();
            }
        }
        for (int i = 0; i < m + 1; i++) {
            List<String> n = new ArrayList<String>(i);
            n.add("" + i);
            number[i][i] = n;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = i-1; j >0; j--) {
                //既然篮子都不能为空，那么就是有一个篮子里面放了一个，所有篮子至少两个。这两种情况去分析
                List<String> l1 = number[i - j][j];
                List<String> l2 = number[i][j+1];
                List<String> list = new ArrayList<>();
                l1.addAll(l2);
                for (int d = 0; d < l1.size(); d++) {
                    list.add(j + "+" + l1.get(d));
                }
                number[i][j] = list;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            System.out.println(number[m][i]);
        }
    }


}
