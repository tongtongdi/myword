package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class mingmingdesuijishu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuffer string = new StringBuffer();

        while (input.hasNext()){
            int max = input.nextInt();
            Set<Integer> set = new ConcurrentSkipListSet<>();
            for(int i=0;i<max;i++){
                set.add(input.nextInt());
            }
            for(int number:set){
                System.out.println(number);
            }
        }

    }
}
