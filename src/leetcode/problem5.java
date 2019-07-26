package leetcode;

/**
 * @Description:
 * @Date: 2019/7/25
 * @Author 王通
 * @Version 1.0
 */

public class problem5 {

    /**
     * 方法一：表示n2也是很恶心
     * @param s
     * @return
     */
    /*public static String longestPalindrome(String s) {
        String returnS = "";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String che = s.substring(i, j);
                if(checkIt(che) && che.length()>returnS.length()){
                    returnS = che;
                }
            }
        }
        return returnS;

    }

    public static Boolean checkIt(String s) {
        if(s.length()==0) return true;
        else if(s.length()==1) return true;
        else{
            return checkIt(s.substring(1,s.length()-1))&&s.charAt(0)==s.charAt(s.length()-1);
        }
    }
*/
    public static String longestPalindrome(String s) {
        if(s==null || s.length()<=1) return s;
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            int len1 = findCenter(s, i, i + 1);
            int len2 = findCenter(s, i, i);
            int lenght = Math.max(len1, len2);
            if (lenght > end-start+1) {
                start = i - (lenght-1)/2;
                end = i + lenght / 2;
            }
        }
        return s.substring(start,end+1);

    }

    public static int findCenter(String s,int left,int right){
        int L = left, R = right;
        while (L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        //这里的R位置和L位置已经不能符合要求，因此R-L-1，而不是R-L+1
        return R-L-1;

    }

    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        Long start = System.nanoTime();
        String returns = longestPalindrome(s);
        Long end = System.nanoTime();

        System.out.println("结果:" + returns + "用时(纳秒):" + (end - start));
    }
}
