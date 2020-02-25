package leetcode.face;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class problem2 {
    public static int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if(!set.contains(fronts[i])&&fronts[i]<min){
                min = fronts[i];
            }
            if (!set.contains(backs[i]) && backs[i] < min) {
                min = backs[i];
            }
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1};
        int[] b = new int[]{1,1};
        System.out.println(Arrays.stream(a).max());
        System.out.println();
        System.out.println(flipgame(a, b));
    }
}
