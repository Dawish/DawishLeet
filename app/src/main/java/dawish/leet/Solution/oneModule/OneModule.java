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
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {



        return 0;
    }

    /**
     * 求字符串中最长子序列长度
     * 执行用时 :7 ms, 在所有 java 提交中击败了83.34%的用户
     * 内存消耗 :36.9 MB, 在所有 java 提交中击败了95.18%的用户
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

}
