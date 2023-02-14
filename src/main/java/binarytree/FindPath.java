package binarytree;

/**
 * @Author Lujs
 * @Date 2022/7/30
 * 给定一个二叉树root和一个整数值 sum ，求该树有多少路径的的节点值之和等于 sum
 * 路径定义不需要从根节点开始，也不需要在叶子节点结束，但是一定是从父亲节点往下到孩子节点
 */
public class FindPath {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
    private int res = 0;
    //dfs查询以某结点为根的路径数
    private void dfs(TreeNode root,int sum){
        if (root == null){
            return;
        }
        //符合目标值
        if (sum == root.val){
            res++;
        }
        //进入子节点继续找
        dfs(root.left,sum-root.val);
        dfs(root.right,sum-root.val);
    }
    //dfs 以每个结点作为根查询路径
    public int findPath(TreeNode root,int sum){
        if (root==null){
            return res;
        }
        //查询以某结点为根的路径数
        dfs(root,sum);
        //以其子结点为新根
        findPath(root.left,sum);
        findPath(root.right,sum);
        return res;
    }
}
