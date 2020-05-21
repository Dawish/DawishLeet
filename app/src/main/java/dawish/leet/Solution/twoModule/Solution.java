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

}
