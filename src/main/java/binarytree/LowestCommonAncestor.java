package binarytree;

import java.util.ArrayList;

/**
 * @Author Lujs
 * @Date 2022/7/17
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先
 * 如果节点p和节点q 都在左子树上，那么应该到左子树上去寻找最近公共祖先；
 * 如果节点p和节点q都在右子树上，那么应该到右子树上去寻找最近公共祖先；
 * 如果节点p和节点q 一个在左子树节点，一个在右子树节点，那么根节点就是最近公共祖先。。
 */
public class LowestCommonAncestor {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
    //求得根节点到目标节点的路径
    public ArrayList<Integer> getPath(TreeNode root,int target){
        ArrayList<Integer> path = new ArrayList<>();
        TreeNode node = root;
        //节点值都不同，可以直接用值比较
        while (root.val != target){
            path.add(node.val);
            //小的在左子树
            if (target < node.val){
                node = node.left;
            }else {
                //大的在右子树
                node = node.right;
            }
        }
        path.add(node.val);
        return path;
    }
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        //求根节点到两个节点的路径
        ArrayList<Integer> path_p = getPath(root, p);
        ArrayList<Integer> path_q = getPath(root, q);
        int res = 0;
        //比较两个路径，找到第一个不同的点
        for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
            int x = path_p.get(i);
            int y = path_q.get(i);
            if (x == y){
                res = path_p.get(i);
            }else {
                break;
            }
        }
        return res;
    }
}
