package dawish.leet.Solution.oneModule;

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

}
