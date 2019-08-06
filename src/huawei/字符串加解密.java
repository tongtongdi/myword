import java.util.*;

public class 字符串加解密{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String number1 = input.nextLine();
            String number = "";
            for(int i=0;i<number1.length();i++){
                char c = number1.charAt(i);
                if((c<='z'&&c>='a')||(c<='Z'&&c>='A')){
                    number +=c;
                }else if(number.length()>0 && number.charAt(number.length()-1)!=' '){
                    number +=(char)32;
                }
            }
            System.out.println("转化后的字符串"+number);
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