package binarytree;

import java.util.ArrayList;

/**
 * @Author Lujs
 * @Date 2022/7/17
 * 给定一棵二叉树以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点
 * 二叉树非空，且每个节点值均不同
 */
public class LowestCommonAncestor2 {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
    //记录是否找到到o的路径
    public boolean flag = false;
    //求得根节点到目标节点的路径
    public void dfs(TreeNode root,ArrayList<Integer> path,int o){
        if (flag||root == null){
            return;
        }
        path.add(root.val);
        //节点值都不同，可以直接用值比较
        if (root.val == o){
            flag = true;
            return;
        }
        //dfs遍历查找
        dfs(root.left,path,o);
        dfs(root.right,path,o);
        //找到
        if (flag){
            return;
        }
        //回溯
        path.remove(path.size()-1);
    }

    public int lowestCommonAncestor2 (TreeNode root, int p, int q) {
        //求根节点到两个节点的路径
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        dfs(root,path1,p);
        //重置flag，查找下一个
        flag = false;
        dfs(root,path2,q);
        int res = 0;
        //比较两个路径，找到第一个不同的点
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            int x = path1.get(i);
            int y = path2.get(i);
            if (x == y){
                //最后一个相同的节点就是最近公共祖先
                res = path1.get(i);
            }else {
                break;
            }
        }
        return res;
    }
}
