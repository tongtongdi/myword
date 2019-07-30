package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:
 * @Date: 2019/7/26
 * @Author 王通
 * @Version 1.0
 */

public class problem_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numLength = nums1.length + nums2.length;
        int mid = (numLength) / 2 + 1;
        boolean ou = numLength % 2 == 0 ? true : false;
        int[] number = new int[2];
        int i = 0, j = 0;
        if (numLength < 1) return 0;
        if (nums1.length == 0)
            if (ou)
                return ((double) nums2[mid - 2] + nums2[mid - 1]) / 2;
            else return nums2[mid - 1];
        if (nums2.length == 0)
            if (ou)
                return ((double) nums1[mid - 2] + nums1[mid - 1]) / 2;
            else return nums1[mid - 1];
        //上面是特殊情况，
        for (int e = 0; e < mid; e++) {
            if (i < nums1.length && j < nums2.length) {
                //这个就是正常走下去
                if (nums1[i] > nums2[j]) {
                    number[0] = number[1];
                    number[1] = nums2[j];
                    j++;
                } else {
                    number[0] = number[1];
                    number[1] = nums1[i];
                    i++;
                }
            } else if (i >= nums1.length) {
                //
                number[0] = number[1];
                number[1] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                number[0] = number[1];
                number[1] = nums1[i];
                i++;
            }
        }
            System.out.println(Arrays.toString(number));
            if (ou) return ((double) number[0] + number[1]) / 2;
            else return number[1];
        }

    public static void main(String[] args) {
        int[] n = new int[]{1,67};
        int[] m = new int[]{3,4};

        System.out.println(findMedianSortedArrays(n, m));
    }
}
