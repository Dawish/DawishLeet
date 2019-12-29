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

    }
}