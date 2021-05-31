package leetcode;

public class problem_415 {
    public static void main(String[] args) {
        String string1 = "128";
        String  string2 = "123";
        System.out.println(addStrings(string1, string2));
    }

    public static String addStrings(String num1, String num2) {
        String result = new String();
        int []interGer = new int[Math.max(num1.length(), num2.length()) + 1];
        char[] numInt1 = num1.toCharArray();
        char[] numInt2 = num2.toCharArray();
        int number1[] = ChangeCharToInt(numInt1);
        int number2[] = ChangeCharToInt(numInt2);
        int chanyu = 0;
        for (int i = 0; i < number1.length || i < number2.length; i++) {
            int resultTmp = 0;
            if (i < number1.length && i < number2.length) {
                resultTmp = number1[i] + number2[i] + chanyu;
            } else if (i >= number1.length) {
                resultTmp = number2[i] + chanyu;
            } else if (i >= number2.length) {
                resultTmp = number1[i] + chanyu;
            } else {
                System.out.println("error");
                return "";
            }
            interGer[i] = resultTmp % 10;
            chanyu = resultTmp / 10;
        }
        interGer[interGer.length - 1] = chanyu;
        result = zifuchuan(interGer);
        return result;
    }
    public static String zifuchuan(int []ziFuChuan) {
        StringBuffer string = new StringBuffer();
        int Length = ziFuChuan.length - 1;
        if (ziFuChuan[Length] == 0) {
            Length = Length - 1;
        }
        for (int i = Length; i >= 0; i--) {
            string.append(ziFuChuan[i]);
        }
        return string.toString();
    }

    public static int[] ChangeCharToInt(char []charList) {
        int charListLength = charList.length;
        int start = 0;
        int[] intList = new int[charListLength];
        for (int i = charListLength - 1; i >= 0; i--) {
            intList[start++] = (int)charList[i] - (int)'0';
        }
        return intList;
    }

}
