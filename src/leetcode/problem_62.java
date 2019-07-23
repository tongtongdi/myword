package leetcode;

/**
 * @Description:
 * @Date: 2019/7/22
 * @Author 王通
 * @Version 1.0
 */

public class problem_62 {
    public static int uniquePaths(int m, int n) {
        if(n==1)
            return 1;
        if(m==1)
            return 1;
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }

}
