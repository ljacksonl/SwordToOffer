package binarytree;

/**
 * @Author Lujs
 * @Date 2022/7/11
 */
/*
* 操作给定的二叉树，将其变换为原二叉树的镜像。
* 二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
* */
public class MirrorBinaryTree {
    public class TreeNode{
        int val = 0;
        TreeNode left =null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode Mirror(TreeNode root){
        if (root == null){
            return null;
        }
        //先递归子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //交换
        Mirror(root.right);
        Mirror(root.left);
        return root;
    }

}
