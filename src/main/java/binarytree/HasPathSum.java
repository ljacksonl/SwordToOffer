package binarytree; /**
 * @Author Lujs
 * @Date 2022/7/16
 */

/**
 * 给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
 */
public class HasPathSum {
    public class TreeNode{
        int val = 0;
        TreeNode left =null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
    public boolean hasPathSum(TreeNode root,int sum){
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0){
            return true;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}
