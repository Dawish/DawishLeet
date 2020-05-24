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


    int num = 0;
    // 搜索二叉树中序遍历可以得到一个升序数组 右中左可以得到一个降序的
    /**
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
     * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        convertOrder(root);
        return root;
    }

    public void convertOrder(TreeNode root){
        if(root == null){
            return;
        }
        convertOrder(root.right);
        // 加上上一个大于自己的值
        root.val += num;
        // 保存上一个大于自己值
        num = root.val;
        convertOrder(root.left);
    }

    int sum;
    /**
     * 从根到叶的二进制数之和
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        orderTree(root, 0);
        return sum;
    }
    // 先序遍历求和
    public void orderTree(TreeNode root, int pathVal){
        if(root == null){
            return;
        }
        // 累加路径上的val值
        pathVal = ((pathVal<<1) + root.val) % 1000000007;
        // 遇到叶子节点求一次sum值
        if(root.left == null && root.right == null){
            sum += pathVal;
        }
        orderTree(root.left, pathVal);
        orderTree(root.right, pathVal);
    }

}
