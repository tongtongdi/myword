package huawei;

import java.util.Scanner;

public class 句子逆序 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String number = input.nextLine();
            String s = "";
            int i = number.length()-1;
            while (i>=0){
                int j = i;
                while (j>=0&&number.charAt(j)!=' '){
                    j--;
                }
                if(j!=i){
                    s = s + number.substring(j + 1, i + 1);
                }
                if(j<0){
                    break;
                }else{
                    i = j-1;
                    s += " ";
                }
            }
            System.out.println(s);
        }
    }
}
