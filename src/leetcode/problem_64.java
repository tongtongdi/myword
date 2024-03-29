package leetcode;

/**
 * @Description:
 * @Date: 2019/8/6
 * @Author 王通
 * @Version 1.0
 */

public class problem_64 {
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=1;i<grid.length;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<grid[0].length;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[2][2];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(nums));
    }
}
