package dawish.leet.Solution.baseModule;

import java.util.ArrayList;
import java.util.LinkedList;

import dawish.leet.Solution.twoModule.TreeNode;

public class Tree {

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
