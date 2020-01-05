package dawish.leet.Solution.oneModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneModule {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }


    /**
     * 递归方法
     * @param carry 进位
     * @return
     */
    public ListNode add(ListNode l1, ListNode l2, int carry){

        if(l1 == null && l2 == null && carry == 0){
            return null;
        }

        int value1 = l1 != null ? l1.val : 0;
        int value2 = l2 != null ? l2.val : 0;

        int sum = value1 + value2 + carry;
        carry = sum/10;

        ListNode tempNode = new ListNode(sum%10);
        // 执行递归
        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;
        tempNode.next = add(l1, l2, carry);

        return tempNode;
    }

    /**
     * 求字符串中最长子序列长度
     * 执行用时 :7 ms, 在所有 java 提交中击败了83.34%的用户
     * 内存消耗 :36.9 MB, 在所有 java 提交中击败了95.18%的用户
     *
     * string: xfdvdv
     * length: 6
     * sList 2: [x]
     * sList 2: [x, f]
     * sList 2: [x, f, d]
     * sList 2: [x, f, d, v]
     * sList 1: [v]
     * sList 2: [v, d]
     * sList 1: [d]
     * sList 2: [d, v]
     * lengthOfLongestSubstring: 4
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        int length = s.length();
        // 每一次for循环里面都是一个子序列
        List<Character> sList = new ArrayList<>();
        int maxLength = 0;

        for(int i=0 ; i<length ; i++){
            char currChar = s.charAt(i);

            if(sList.contains(currChar)){
                // 有重复的就移除上一个字符及其之前的
                int extraBeginIndex = sList.indexOf(currChar);

                // 此方法会严重增加耗时 不可用，下面的for循环更优
                // sList = sList.subList(extraBeginIndex+1, sList.size());

                // 类似滑动窗口
                for (int i1 = 0; i1 <= extraBeginIndex; i1++) {
                    sList.remove(0);
                }
            }

            sList.add(currChar);
            int currSize = sList.size();
            if(currSize > maxLength){
                // 保存最长的子序列的长度
                maxLength = currSize;
            }
        }
        return maxLength;
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 回文子串 正反都是一样,示例如下：
     * "" -> ""
     * a -> a
     * aa -> aa
     * ab -> a
     * aaa -> aaa
     * acxca -> acxca
     * tattarrattat -> tattarrattat
     * accccx -> cccc
     *
     * 执行用时 :2 ms, 在所有 Java 提交中击败了99.96%的用户
     * 内存消耗 :36.1 MB, 在所有 Java 提交中击败了91的用户
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if(s == null){
            return null;
        }

        if(s != null && s.length() <= 1){
            return s;
        }

        char[] chars = s.toCharArray();
        int sLength = chars.length;
        int[] leftRightRange = new int[2];

        for (int i = 0; i < sLength; i++) {
            i = findLeftRightIndex(chars, i, leftRightRange);
        }

        return s.substring(leftRightRange[0], leftRightRange[1] + 1);

    }

    /**
     *  中心扩散算法
     *  1.从处理点中心index开始只要连续相等的都是回文子串，确定range，可以无视奇数和偶数lenght
     *  2.从满足要求的left -1 和满足要求的right + 1对比扩大range 起始位置
     * @param chars
     * @param iIndex 其实就是iLeft
     * @param leftRightRange 存放回文子串的起始index
     * @return 下一个循环index
     */
    private int findLeftRightIndex(char[] chars, int iIndex, int[] leftRightRange){
        int iRight = iIndex;
        // 倒数第二个就够了
        int max = chars.length - 1;
        // step 1
        while(iRight < max && chars[iIndex] == chars[iRight + 1]){
            iRight++;
        }

        // 保存下一个循环处理的index
        int result = iRight;

        // step 2
        while(iIndex > 0 && iRight < max && chars[iIndex  - 1] == chars[iRight + 1]){
            iIndex--;
            iRight++;
        }

        // 取最大长度的回文子串
        if(iRight - iIndex > leftRightRange[1] - leftRightRange[0]){
            leftRightRange[0] = iIndex;
            leftRightRange[1] = iRight;
        }

        return result;
    }

}
