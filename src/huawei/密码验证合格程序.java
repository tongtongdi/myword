package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Description:
 * @Date: 2019/7/28
 * @Author 王通
 * @Version 1.0
 */

public class 密码验证合格程序 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        List<String> list = new ArrayList<>();
        while ((string = bufferedReader.readLine())!=null) {
            if((string.length()<=0)) break;
            list.add(string);
        }
        for (String s : list) {
            boolean b = true;
            if(s.length()<=8){
                b = false;
            }
            int[] check = new int[4];
            for(int i=0;i<s.length();i++){
                char num = s.charAt(i);
                if(num<='Z'&&num>='A') check[0] = 1;
                else if(num<='z'&&num>='a') check[1] = 1;
                else if(num<='9' && num>='0') check[2] = 1;
                else{
                    check[3] = 1;
                }
            }
            int d = 0;
            for (int i : check) {
                if(i==0) {
                    d++;
                }
            }
            if(d>=2) b = false;
            Set<String> set = new HashSet<>();
            for (int i = 0; i <= s.length() - 3; i++) {
                String sub = s.substring(i, i + 3);
                if (set.contains(sub)) {
                    b = false;
                    break;
                }else{
                    set.add(sub);
                }
            }
            String nums = "OK";
            if(b==true)
                nums = "OK";
            else{
                nums = "NG";
            }
            System.out.println(nums);
        }

    }
}
