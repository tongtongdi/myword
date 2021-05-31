package Test;

import java.util.HashMap;

public class makeString {
    public static void main(String[] args) {
        boolean num = isPathCrossing("ESSWNEE");
        System.out.println(num);
    }

    static public boolean isPathCrossing(String path) {
        HashMap<Integer, HashMap<Integer, Boolean>> map = new HashMap<>();
        int x = 0, y = 0;
        for (char ch: path.toCharArray()) {
            if (!map.containsKey(x)) {
                map.put(x, new HashMap<Integer, Boolean>());
            }
            map.get(x).put(y, true);
            switch(ch) {
                case 'N':
                    ++y;
                    break;
                case 'S':
                    --y;
                    break;
                case 'E':
                    ++x;
                    break;
                case 'W':
                    --x;
                    break;
                default:{
                    System.out.println(" enter error Number!");
                }
            }
            if (map.containsKey(x) && map.get(x).containsKey(y)) {
                return true;
            }
        }
        return false;
    }
}
