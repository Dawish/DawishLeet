package dawish.leet.Solution.baseModule;

/**
 * 链表的操作
 */
public class LinkedHandle {

    public DoubleNode head;
    public DoubleNode tail;

    /**
     * 双向链表
     */
    public class DoubleNode {
        public int no;
        public String value;
        public DoubleNode next;
        public DoubleNode pre;
    }

    /**
     * 单向链表
     */
    public class Node {
        public int no;
        public String value;
        public Node next;
    }


    /**
     * 双向链表头插入
     * @param node
     */
    public void addFirst(DoubleNode node) {
        if (null == node || head == null) {
            return;
        }
        node.next = head;
        head.pre = node;
    }


    /**
     * 双链表尾部插入
     * @param node
     */
    public void addHead(DoubleNode node){
        if(null == node || tail == null){
            return;
        }
        node.pre = tail;
        tail.next = node;
    }

    /**
     * 根据指定的索引删除节点
     * @param no
     */
    public void delete(int no){
        if(null == head || head.next == null){
            return;
        }
        DoubleNode tempNode = this.head;
        while(tempNode.next != null){
            if(tempNode.no == no){
                // 删除目标节点
                if(tempNode.pre != null){
                    tempNode.pre.next = tempNode.next;
                }
                if(tempNode.next != null){
                    tempNode.next.pre = tempNode.pre;
                }
                return;
            }
            tempNode = tempNode.next;
        }
    }

    /**
     * 根据索引修改某个节点的值
     * @param index
     * @param value
     */
    public void modify(int index, String value){
        if(this.head == null){
            return;
        }

    }

    /**
     * 双链表反转
     */
    public static DoubleNode reverseLinked(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 单链表反转
     */
    public static Node reverseLinked(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
