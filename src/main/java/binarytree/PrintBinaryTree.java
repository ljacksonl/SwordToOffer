package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Lujs
 * @Date 2022/7/24
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //层次遍历
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        TreeNode head = pRoot;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //如果是空，则直接返回空数组
        if (head == null){
            return null;
        }
        //队列存储，进行层次遍历
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(head);
        TreeNode p;
        int n = temp.size();
        while (!temp.isEmpty()){
            //记录二叉树的某一行
            ArrayList<Integer> row = new ArrayList<>();
            //因先进入的是根节点，故每层节点多少，队列大小就是多少
            for (int i = 0; i < n; i++) {
                p = temp.poll();
                row.add(p.val);
                //若是左右孩子存在，则存入左右孩子作为下一个层次
                if (p.left!=null){
                    temp.offer(p.left);
                }
                if (p.right!=null){
                    temp.offer(p.right);
                }
            }
            res.add(row);
        }
        return res;
    }
}
