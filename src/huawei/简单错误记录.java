package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @Date: 2019/7/28
 * @Author 王通
 * @Version 1.0
 */

public class 简单错误记录 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = null;
        Map<String, Integer> map = new LinkedHashMap<>();
        while ((readLine = bufferedReader.readLine()) != null) {
            if(readLine.length()<=0) break;
            String[] number = readLine.split(" ");
            number[0] = number[0].substring(number[0].lastIndexOf("\\")+1);
            if(number[0].length() > 16){
                number[0] = number[0].substring(number[0].length() - 16);
            }
            String mapFirst = number[0] + " " + number[1];
            if(map.containsKey(mapFirst)){
                int value = map.get(mapFirst)+1;
                map.put(mapFirst, value);
            }else{
                map.put(mapFirst, 1);
            }
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            count++;
            if (count > (map.size() - 8))
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
}
