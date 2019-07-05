package study_It;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:
 * @Date: 2019/7/5
 * @Author 王通
 * @Version 1.0
 */

public class Array_sort_student {
    public static void main(String[] args) {
        int[] a = new int[]{12, 3, 2, 23, 23, 2, 3, 2, 3, 2, 2, 4, 575,};
        changeIt(0, 1, a);
        Arrays.toString(a);
    }

    public static void changeIt(int left,int right,int[] a){
        for (int i = left, j = i; i < right; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == left) {
                    break;
                }
            }
            a[j + 1] = ai;
        }

    }
}
