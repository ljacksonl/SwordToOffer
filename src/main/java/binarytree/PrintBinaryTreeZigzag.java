package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author Lujs
 * @Date 2022/7/18
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintBinaryTreeZigzag {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        TreeNode head = pRoot;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (head == null){
            return res;
        }
        //队列存储，进行层次遍历
        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.offer(head);
        TreeNode p;
        boolean flag = true;
        while (!temp.isEmpty()){
            //记录二叉树的某一行
            ArrayList<Integer> row = new ArrayList<>();
            int n = temp.size();
            //奇数行反转，偶数行不反转
            flag = !flag;
            //因先进入的是根节点，故每层节点多少，队列大小就是多少
            for (int i = 0; i < n; i++) {
                p = temp.poll();
                row.add(p.val);
                //若是左右孩子存在，则存入左右孩子作为下一个层次
                if (p.left != null){
                    temp.offer(p.left);
                }
                if (p.right != null){
                    temp.offer(p.right);
                }
            }
            //奇数行反转，偶数行不反转
            if (flag){
                Collections.reverse(row);
            }
            res.add(row);
        }
        return res;
    }
}
