package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description:
 * @Date: 2019/7/29
 * @Author 王通
 * @Version 1.0
 */

public class problem_16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2]-target;
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if(sum<target){
                    i++;
                }else if(sum>target){
                    j--;
                }else{
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(ans)) {
                    ans = sum-target;
                }
            }
        }
        return ans+target;

    }

    public static void main(String[] args) {
        int [] num = new int[]{-1,2,1,-4};
        System.out.println(threeSumClosest(num,1));
    }
}
