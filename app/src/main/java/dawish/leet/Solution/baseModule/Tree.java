package dawish.leet.Solution.baseModule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

import dawish.leet.Solution.twoModule.TreeNode;

public class Tree {

    /**
     * 递归求二叉树深度
     * @param root
     * @return
     */
    public static int getTreeDeepin(TreeNode root){

        if(root == null){
            return  0;
        }
        int leftDeepin = getTreeDeepin(root.left) + 1;
        int rightDeepin = getTreeDeepin(root.right) + 1;
        return leftDeepin >= rightDeepin ? leftDeepin : rightDeepin;
    }

    /**
     * 非递归求二叉树深度
     * @param root
     * @return
     */
    public static int getTreeDeepin2(TreeNode root){

        if(root == null){
            return 0;
        }
        int deepin = 0;
        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.add(root);

        if(!deque.isEmpty()){
            TreeNode treeNode = deque.remove();
            if(treeNode.left != null){
                deque.add(treeNode.left);
            }
            if(treeNode.right != null){
                deque.add(treeNode.right);
            }
            deepin++;
        }

        return deepin;
    }

    /**
     * 二叉树之字打印
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        LinkedList<TreeNode> list = new LinkedList<>();
        ArrayList<ArrayList<Integer> >  res = new ArrayList<>();
        if(pRoot == null)
            return res;
        boolean flag = true;
        list.addLast(pRoot);
        while(list.size() > 0){
            ArrayList<Integer> temp = new ArrayList<>();
            int s = list.size();
            for(int i = 0;i < s;i ++){
                TreeNode node = list.pollFirst();
                if(node.left != null)
                    list.addLast(node.left);
                if(node.right != null)
                    list.addLast(node.right);
                if(flag)
                    temp.add(node.val);
                else
                    temp.add(0,node.val);
            }
            res.add(temp);
            flag = !flag;
        }
        return res;
    }

}
