package binarytree;

import java.util.Stack;

/**
 * @Author Lujs
 * @Date 2022/7/20
 *给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
//递归中序遍历，也就是从最小的一个节点开始，找到k个就是我们要找的目标。
public class KthTreeNode {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
    public int KthNode(TreeNode proot,int k){
        if (proot == null){
            return -1;
        }
        //记录遍历了多少个数
        int count = 0;
        TreeNode p = null;
        //用栈辅助建立中序
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() && proot != null){
            while (proot != null){
                s.push(proot);
                //中序遍历每棵子树从最左开始
                proot = proot.left;
            }
            p = s.pop();
            //第k个直接返回
            count++;
            if (count == k){
                return p.val;
            }
            proot = p.right;
        }
        //没有找到
        return -1;
    }
}
