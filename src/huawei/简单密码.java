package huawei;

import java.util.Scanner;

/**
 * @Description:
 * @Date: 2019/7/28
 * @Author 王通
 * @Version 1.0
 */

public class 简单密码 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String oldPaw = input.nextLine();
            StringBuilder newPaw = new StringBuilder();
            for (int i = 0; i < oldPaw.length(); i++) {
                char n = oldPaw.charAt(i);
                if(n>='A' && n<='Z'){
                    newPaw.append(changeIt(n));
                }else if (n >= 'a' && n <= 'z') {
                    if (n >= 'a' && n <= 'c') {
                        newPaw.append(2);
                    }else if(n >= 'd' && n <= 'f') {
                        newPaw.append(3);
                    }else if(n >= 'g' && n <= 'i') {
                        newPaw.append(4);
                    }else if(n >= 'j' && n <= 'l') {
                        newPaw.append(5);
                    }else if(n >= 'm' && n <= 'o') {
                        newPaw.append(6);
                    }else if(n >= 'p' && n <= 's') {
                        newPaw.append(7);
                    }else if(n >= 't' && n <= 'v') {
                        newPaw.append(8);
                    }else if(n >= 'w' && n <= 'z') {
                        newPaw.append(9);
                    }
                }else{
                    newPaw.append(n);
                }
            }
            System.out.println(newPaw.toString());
        }
    }

    public static char changeIt(char nu) {
        if(nu=='Z') return 'a';
        else{
            return (char) (nu - 'A' + 'a'+1);
        }
    }
}
