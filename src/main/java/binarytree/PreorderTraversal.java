package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @Author Lujs
 * @Date 2022/7/16
 */
/*
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * */
public class PreorderTraversal {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return null;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        if (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null){
                queue.add(poll.left);
            }
            if (poll.right != null){
                queue.add(poll.right);
            }
        }
        return list;
    }
}
