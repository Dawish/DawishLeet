package dawish.leet;

import org.junit.Test;

import dawish.leet.Solution.oneModule.OneModule;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class OneModuleTest {
    @Test
    public void addition_isCorrect() {

        OneModule oneModule = new OneModule();

        String str = "xfdvdv";

        System.out.println("string: "+str);

        int length = oneModule.lengthOfLongestSubstring(str);

        System.out.println("lengthOfLongestSubstring: "+length);

        String resultStr = oneModule.longestPalindrome("dgexegdxaxdxdffii");
        System.out.println("longestPalindrome: "+resultStr);
    }

    @Test
    public void addition_two() {

        OneModule oneModule = new OneModule();
//        String str = "babadada";
        String str = "tattarrattat";
//        String str = "accca";

        System.out.println("string: "+str);
        String resultStr = oneModule.longestPalindrome(str);
//        String resultStr = oneModule.longestPalindromeTest(str);
        System.out.println("longestPalindrome: "+resultStr);
    }

    @Test
    public void addition_3() {
        OneModule oneModule = new OneModule();
//        String str = "LVIII";
        String str = "MCMXCIV";
//        String str = "IX";
        System.out.println("string: "+str);
        int resultStr = oneModule.romanToInt(str);
        System.out.println("resultStr: "+resultStr);
    }

}