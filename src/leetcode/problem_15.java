package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/7/29
 * @Author 王通
 * @Version 1.0
 */

public class problem_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if(k>0 && nums[k]==nums[k-1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if(sum==0) {
                    returnList.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i<j && nums[i]==nums[++i]);
                    while (i<j && nums[j]==nums[--j]);
                }
                else if(sum<0){
                    while (i<j && nums[i]==nums[++i]);
                } else if (sum > 0) {
                    while (i<j && nums[j]==nums[--j]);
                }
            }
        }
        return returnList;
    }
}
