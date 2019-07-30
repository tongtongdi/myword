package leetcode;

import java.util.*;

/**
 * @Description:
 * @Date: 2019/7/29
 * @Author 王通
 * @Version 1.0
 */

public class problem_17 {
    public static List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r','s'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y','z'));
        if(digits==null || digits.length()<=0) return new ArrayList<>();
        List<String>[] lists = new List[digits.length()+1];
        for (int i = 0; i < digits.length(); i++) {
            if (i == 0 && digits.charAt(i) != '1') {
                List<String> firstList = new ArrayList<>();
                for (int d = 0; d < map.get(digits.charAt(0)).size(); d++) {
                    firstList.add(map.get(digits.charAt(0)).get(d)+"");
                }
                lists[i] = firstList;
                continue;
            }
            if (digits.charAt(i)=='1') {
                lists[i] = lists[i - 1];
                continue;
            }else {
                lists[i] = changetIt(lists[i-1],map.get(digits.charAt(i)));
            }
        }
        return lists[lists.length-2];
    }

    public static List<String> changetIt(List<String> list1, List<Character> newList) {
        List<String> returnList = new ArrayList<>();
        try {
            for (int i = 0; i < newList.size(); i++) {
                for (int j = 0; j < list1.size(); j++) {
                    returnList.add(newList.get(i)+list1.get(j));
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
        return returnList;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
