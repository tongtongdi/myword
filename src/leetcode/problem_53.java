package leetcode;

public class problem_53 {
        public static int maxSubArray(int[] nums) {
            int numsSize = nums.length;
            int array[] = new int[numsSize];
            for(int i=0; i < numsSize; i++) {
                array[i] = 0;
            }
            array[0] = nums[0];
            for(int i=1; i < numsSize; i++) {
                int test = array[i-1] + nums[i];
                if (test > nums[i] && test > array[i-1]) {
                    array[i] = test;
                } else {
                    array[i] = nums[i];
                }
            }
            return array[numsSize-1];
        }
        public static void main(String[] args){
            int nums[] = new int[]{ -2,1,-3,4,-1,2,1,-5,4};
            System.out.println(maxSubArray(nums));
        }
}
