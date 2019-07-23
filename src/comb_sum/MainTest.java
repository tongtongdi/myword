package comb_sum;

/**
 * @Description:
 * @Date: 2019/7/23
 * @Author 王通
 * @Version 1.0
 */

public class MainTest {
     static int[] a = new int[100];
     static int count = 0;
    public static void main(String[] args) {
        int m =3 ,k = 5;
        a[0] = k;
        int num = sumShow(m, k);
        System.out.println(num);
    }

    public static int sumShow(int m,int n){
        for(int i=0;i>=n;i--){
            a[n] = i;
            if(n>1){
                sumShow(i-1,n-1);
            }
            else{
                count++;
                for(int j=a[0];j>0;j--){
                    System.out.print(a[j]+",");
                }
                System.out.println(",");
            }
        }
        return count;
    }
}
