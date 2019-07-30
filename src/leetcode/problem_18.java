package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:四数之和
 * @Date: 2019/7/29
 * @Author 王通
 * @Version 1.0
 */

public class problem_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            for(int j= i+1;j<nums.length-2;j++){
                int k = j+1,s = nums.length-1;
                if(nums[j] == nums[j-1] && j!=i+1){
                    continue;
                }
                while (k < s) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[s];
                    if(sum<target){
                        while (k<s&&nums[k]==nums[++k]);
                    }else if(sum>target){
                        while (k<s&&nums[s]==nums[--s]);
                    }else{
                        lists.add(Arrays.asList(nums[i], nums[j], nums[k], nums[s]));
                        while (k<s&&nums[k]==nums[++k]);
                        while (k<s&&nums[s]==nums[--s]);
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-5,-5,-3,2,5,0,4};
        System.out.println(fourSum(nums,-7));
    }
}
