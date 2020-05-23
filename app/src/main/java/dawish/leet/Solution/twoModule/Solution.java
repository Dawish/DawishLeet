package dawish.leet.Solution.twoModule;

public class Solution {

    // 默认是平衡的
    boolean flag = true;

    /**
     * 检查二叉树平衡性
     * @param root
     * @return
     */
    public int getDepth(TreeNode root){
        if(null == root){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1){
            flag = false;
            // 已经发现不平衡结束递归
            return -1;
        }
        return Math.max(leftDepth, rightDepth) +  1;
    }

    // 中序遍历的中间节点
    TreeNode middleNode;
    int miniVal = Integer.MAX_VALUE;
    // 搜索二叉树的中序遍历的节点值会是一个升序数组，
    // 所以只需要比较相邻的两个节点差值并比较就可以知道最小值
    public int getMinimumDifference(TreeNode root) {
        middleOrder(root);
        return miniVal;
    }
    /**
     * 查找搜索二叉树两个节点的最小差值
     * @param root
     */
    public void middleOrder(TreeNode root){
        if(null == root){
            return;
        }
        middleOrder(root.left);
        if(middleNode != null){
            miniVal = Math.min(Math.abs(middleNode.val - root.val), miniVal);
        }
        middleNode = root;
        middleOrder(root.right);
    }

}
