package leetcode.problem_303;

/**
 * @Description:
 * @Date: 2019/7/18
 * @Author 王通
 * @Version 1.0
 */

public class NumArray {
    private int[] data;

    public NumArray(int[] nums) {
        data = nums;
    }

    public int sumRange(int i, int j) {
        if(i<0 || j>=data.length){
            return 0;
        }
        int sum = 0;
        for(int n = i;n<=j;n++){
            sum +=data[n];
        }
        return sum;
    }
}