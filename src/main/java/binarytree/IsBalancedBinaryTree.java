package binarytree;

/**
 * @Author Lujs
 * @Date 2022/7/16
 */
/*
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * */
public class IsBalancedBinaryTree {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
    public boolean isBalanced(TreeNode root){
        //在下面的获取树深度的方法中，如果返回值为-1说明不平衡，为0或者正整数就是平衡
        return Depth(root) != -1;
    }

    //用后序遍历方法遍历二叉树的每个节点，则在遍历到一个节点之前就已经遍历到它的左，右子树。
    // 只要遍历每个节点的时候记录深度，就可以一边遍历一边判断每个节点是否平衡。
    public int Depth(TreeNode root){
        if (root == null){
            return 0;
        }
        //递归到树底部计算当前根节点左子树的深度，从底向上计算过程中如果发现一处不平衡，直接返回-1，也不会再递归总根节点的右子树
        int left = Depth(root.left);
        if (left == -1){
            return -1;
        }
        //在当前根节点左子树平衡的前提下再递归计算右子树的深度，如果右子树有一处不平衡也直接返回-1，递归结束
        int right = Depth(root.right);
        if (right == 1){
            return -1;
        }
        if (Math.abs(left - right) > 1){
            return -1;
        }else {
            return Math.max(left,right)+1;
        }
    }

}


