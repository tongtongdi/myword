package leetcode;

import java.util.Arrays;

/**
 * @Description:
 * @Date: 2019/7/25
 * @Author 王通
 * @Version 1.0
 */

public class problem_292 {
    public static void main(String[] args) {
        int[] numbers = new int[]{45,1,3,45,2,3,43,54,34,34,234,247,564,456,};
        kuaiSuPaiXu(numbers,0,numbers.length-1);
        System.out.println(Arrays.toString(numbers));

    }
    public static void kuaiSuPaiXu(int[] numbers,int start,int end){
        int kai = start, jie = end;
        int mid = numbers[start];
        while (kai<jie){
            while (kai<jie && mid<numbers[jie]){
                jie--;
            }
            if(kai<jie){
                numbers[kai++] = numbers[jie];
            }
            while (kai<jie && mid>numbers[kai]){
                kai++;
            }
            if(kai<jie){
                numbers[jie--] = numbers[kai];
            }
        }
        numbers[kai] = mid;
        System.out.println(kai==jie);
        if(kai>start) kuaiSuPaiXu(numbers,start,jie-1);
        if(jie<end) kuaiSuPaiXu(numbers,kai+1,end);
    }
}
