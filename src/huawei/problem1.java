package huawei;

import java.util.Scanner;

public class problem1 {
        public static void main(String []args){
            Scanner input = new Scanner(System.in);
            String numb = (String)input.nextLine().toLowerCase();
            char b = input.next().toLowerCase().charAt(0);
            int count = 0;
            for(int i=0;i<numb.length();i++){
                if(numb.charAt(i) == b){
                    count++;
                }
            }
            System.out.println(count);
        }
}
